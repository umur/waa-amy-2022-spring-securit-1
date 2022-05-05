package com.security.waa.model;

import com.security.waa.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    private int roleId;
}
