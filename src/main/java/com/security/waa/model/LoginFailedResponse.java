package com.security.waa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginFailedResponse {
    private String message;
}
