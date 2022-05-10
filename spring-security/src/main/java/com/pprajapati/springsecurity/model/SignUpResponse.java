package com.pprajapati.springsecurity.model;

import com.pprajapati.springsecurity.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse {
  private User user;
}
