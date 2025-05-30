package com.kapitonau.commonspring.security;

import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.util.*;
import java.util.function.Supplier;

public class GlobalAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {


    private final SecurityProps.ResourceMatcher resourceMatcher;

    public GlobalAuthorizationManager(SecurityProps.ResourceMatcher resourceMatcher) {
        this.resourceMatcher = resourceMatcher;
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication.get();
        Jwt token = jwtAuthenticationToken.getToken();
        Collection<GrantedAuthority> authorities = jwtAuthenticationToken.getAuthorities();

        List<LinkedTreeMap<String, String>> spacesAuthorities = token.getClaim("spaceAuthorities");

        if (spacesAuthorities == null || spacesAuthorities.isEmpty()) {
            return new AuthorizationDecision(false);
        }

        List<String> autorities = new ArrayList<>();
        for (LinkedTreeMap<String, String> spacesAuthority : spacesAuthorities) {
            for (Map.Entry<String, String> stringStringEntry : spacesAuthority.entrySet()) {

                if (stringStringEntry.getKey().equals("authorities")) {
                    autorities.add(String.valueOf(stringStringEntry.getValue()));
                }

            }
        }

        for (String autority : autorities) {
            if (autority.contains(resourceMatcher.getAccess())) {
                return new AuthorizationDecision(true);
            }
        }

        return new AuthorizationDecision(false);
    }
}
