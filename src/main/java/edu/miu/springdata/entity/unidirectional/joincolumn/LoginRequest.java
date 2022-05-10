package edu.miu.springdata.entity.unidirectional.joincolumn;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String email;

    private String password;

}
