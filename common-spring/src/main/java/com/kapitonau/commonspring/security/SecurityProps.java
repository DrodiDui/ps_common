package com.kapitonau.commonspring.security;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecurityProps {


    private List<ResourceMatcher> matchers = new ArrayList<>();
    private List<ResourceIgnoreMather> ignoring = new ArrayList<>();
    private Map<String, List<String>> privileges = new HashMap<>();
    private List<SpaceResourceMatcher> spaceMatchers = new ArrayList<>();


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResourceMatcher {
        private String method;
        private String path;
        private String access;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SpaceResourceMatcher {
        private String method;
        private String path;
        private String access;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResourceIgnoreMather {
        private String method;
        private String path;
    }


}
