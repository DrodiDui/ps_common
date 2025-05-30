package com.kapitonau.commonspring.feign;

import com.kapitonau.commonspring.feign.exception.FeignRawException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();


    @Override
    public Exception decode(String methodKey, Response response) {
//        String clientName = methodKey.substring(0, methodKey.indexOf("#"));
//        String methodName = methodKey.substring(methodKey.indexOf("#"), methodKey.indexOf("("));
//        String bodyStr = "EMPTY";
//        try {
//            bodyStr = IOUtils.toString(response.body().asReader());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        log.info("{} {} {} decoding",  methodKey, response.status(), bodyStr);

//        if (methodKey.startsWith("AuthClient")) {
        if (response.status() >= 400) {

            Response.Body body = response.body();
            String bodyStr = "{}";

            if (body != null) {
                try {
                    bodyStr = IOUtils.toString(response.body().asReader());
                } catch (IOException e) {
                    log.warn(e.getMessage());
                }
            }
//            log.info("{} {} {} decoding",  methodKey, response.status(), bodyStr);
//            log.warn("WARN-{}: {}", response.status(), methodKey);
            log.info("Response body: {}", bodyStr);
            throw new FeignRawException(response.status(), bodyStr, response.headers());
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }

}
