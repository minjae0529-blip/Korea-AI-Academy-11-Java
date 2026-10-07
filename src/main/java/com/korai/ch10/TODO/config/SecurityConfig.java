package com.korai.ch10.TODO.config;

import com.korai.ch10.TODO.entity.User;

import java.util.UUID;

public class SecurityConfig {
    private static String loginSession = null;

    public static String getLoginSession(){
        return loginSession;
    }

    public static void setLoginSession(String session){
        SecurityConfig.loginSession = session;
    }

    public static String generateSessionToken(User user){
        String uuid = UUID.randomUUID().toString().replaceAll("-", ""); //replace기존에 있던 문자를 다른 문자로 치환
        int userId = user.getId();
        String token = uuid + "@" + userId;         //uuid
        return token;
    }

    public static int getUserId(){
//        int startIndex = loginSession.indexOf("@")+1;
//        String userIdStr = loginSession.substring(startIndex);
        String token = loginSession;
        return Integer.parseInt(token.substring(token.indexOf("@") + 1));    // 2) 토큰에서 userId를 꺼냄
    }
}
