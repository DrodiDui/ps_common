package com.kapitonau.projectstudio.usermanagerservice.api;

import com.kapitonau.projectstudio.usermanagerservice.dto.SelfUserRegistrationPostRequest;
import com.kapitonau.projectstudio.usermanagerservice.dto.UserPostRequest;
import com.kapitonau.projectstudio.usermanagerservice.dto.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

    @PostMapping("/users")
    UserResponse createUser(@RequestBody UserPostRequest body);

    @PostMapping("/users/selfRegistration")
    UserResponse selfRegistration(@RequestBody SelfUserRegistrationPostRequest body);

}
