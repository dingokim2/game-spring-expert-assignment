package com.gameexpert.chat.service;

import java.time.Duration;
import java.util.List;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRateLimitService {

    private final StringRedisTemplate redisTemplate;

    private static final DefaultRedisScript<Boolean> INCREASE_SCRIPT = new DefaultRedisScript<>("""
            local chatCount = tonumber(redis.call('GET', KEYS[1]) or '0')
            local EXPIRE_SECONDS = 10
            if chatCount >= 5 then
                return false
            end
            redis.call('INCR', KEYS[1])
            if(chatCount == 0) then
                redis.call('EXPIRE', KEYS[1], EXPIRE_SECONDS)
            end
            return true
            """, Boolean.class);

    public boolean allow(Long playerId) {
        String key = "chat:limit:" + playerId;
        // TODO Lv 19: 횟수 확인부터 최초 만료 설정까지 원자적으로 실행합니다.
        return redisTemplate.execute(INCREASE_SCRIPT, List.of(key));
    }
}
