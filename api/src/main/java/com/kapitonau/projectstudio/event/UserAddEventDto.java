package com.kapitonau.projectstudio.event;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserAddEventDto {

    private String email;
    private String firstName;
    private String lastName;
    private String userRole;

}
