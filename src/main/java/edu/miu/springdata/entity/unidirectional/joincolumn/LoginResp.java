package edu.miu.springdata.entity.unidirectional.joincolumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResp {
    private String accessToken;
    private String refreshToken;
}
