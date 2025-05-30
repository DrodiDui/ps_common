package com.kapitonau.commonspring.security;

import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class GlobalSpaceAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    private final SecurityProps.SpaceResourceMatcher resourceMatcher;

    public GlobalSpaceAuthorizationManager(SecurityProps.SpaceResourceMatcher resourceMatcher) {
        this.resourceMatcher = resourceMatcher;
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication.get();
        Jwt token = jwtAuthenticationToken.getToken();
        String spaceHeader = object.getRequest().getHeader("Space");
        if (spaceHeader == null || spaceHeader.isEmpty()) {
            return new AuthorizationDecision(false);
        }

        List<LinkedTreeMap<String, String>> spacesAuthorities = token.getClaim("spaceAuthorities");

        if (spacesAuthorities == null || spacesAuthorities.isEmpty()) {
            return new AuthorizationDecision(false);
        }

        Map<String, List<String>> spaceAuthoritiesMap = new HashMap<>();
        for (LinkedTreeMap<String, String> spacesAuthority : spacesAuthorities) {
            String spaceId = "";
            String authority = "";
            for (Map.Entry<String, String> stringStringEntry : spacesAuthority.entrySet()) {

                if (stringStringEntry.getKey().equals("spaceId")) {
                    spaceId = String.valueOf(stringStringEntry.getValue());
                }

                if (stringStringEntry.getKey().equals("authorities")) {
                    authority = String.valueOf(stringStringEntry.getValue());
                }


            }
            spaceAuthoritiesMap.put(spaceId, List.of(authority));
        }

        String requestAccess = resourceMatcher.getAccess();

        if (requestAccess == null || requestAccess.isEmpty()) {
            return new AuthorizationDecision(false);
        }

        List<String> authorities = spaceAuthoritiesMap.getOrDefault(spaceHeader, null);

        if (authorities == null) {
            return new AuthorizationDecision(false);
        }

        for (String authority : authorities) {
            if (authority.contains(requestAccess)) {
                return new AuthorizationDecision(true);
            }
        }

        return new AuthorizationDecision(false);

    }
}
