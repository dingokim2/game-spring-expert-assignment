package com.gameexpert.ws.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.gameexpert.api.SessionRegistry;
import com.gameexpert.ws.NicknameHandshakeInterceptor;
import com.gameexpert.ws.WorldBroadcaster;
import com.gameexpert.ws.WorldSessionRegistry;
import com.gameexpert.ws.WsMessageContext;
import com.gameexpert.ws.dto.OnlineUsersResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.format.jackson.JacksonJsonFormatMapper;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import javax.swing.text.html.parser.Entity;

@Component
@RequiredArgsConstructor
public class OnlineUsersWsHandler implements WsMessageHandler {
    private final WorldSessionRegistry registry;
    private final WorldBroadcaster broadcaster;

    // mapper 추가
    private final JsonMapper mapper = JsonMapper.builder().build();

    @Override
    public String type() {
        return "onlineUsers";
    }

    @Override
    public void handle(WsMessageContext context, JsonNode message) {
        // TODO Lv 15: 현재 월드의 열린 연결에서 닉네임을 조회하고 요청자에게 응답합니다.

        List<String> users = new ArrayList<>();

        Collection<SessionRegistry.Entry> entries = registry.entries(context.worldId());
        for(SessionRegistry.Entry entry : entries){
            if(!entry.session().isOpen()) continue;

            String nickName = (String) entry.session().getAttributes().get(NicknameHandshakeInterceptor.ATTR_NICKNAME);
            users.add(nickName);
        }
        users.sort(null);

        OnlineUsersResponse onlineUsersResponse = new OnlineUsersResponse(users, users.size());

        broadcaster.sendTo(context.session(), mapper.valueToTree(onlineUsersResponse));
    }
}
