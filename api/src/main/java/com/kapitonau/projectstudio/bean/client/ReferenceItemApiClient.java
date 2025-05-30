package com.kapitonau.projectstudio.bean.client;

import com.kapitonau.commonspring.feign.interceptor.JwtLocaleRequestInterceptor;
import com.kapitonau.projectstudio.referenceservice.api.ReferenceItemApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "reference-service", contextId = "ReferenceItemApi-contextId", url = "${api.reference-service.url}", configuration = JwtLocaleRequestInterceptor.class)
public interface ReferenceItemApiClient extends ReferenceItemApi {
}
