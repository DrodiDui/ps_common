package com.kapitonau.commonspring.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.List;

public class ResourceServerUtil {


    private ResourceServerUtil() {
    }

    public static JwtAuthenticationToken extractJwtAuthToken() {
        return (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }

    public static Long getUserId() {
        return extractJwtAuthToken().getToken().getClaim("userId");
    }

    public static List<String> getSpaces() {
        return extractJwtAuthToken().getToken().getClaimAsStringList("spaces");
    }

}
