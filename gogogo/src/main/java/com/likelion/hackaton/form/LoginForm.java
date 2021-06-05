package com.likelion.hackaton.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginForm {
    @NotBlank(message = "이메일을 입력하세요.")
    private String email;

    @NotBlank(message = "패스워드를 입력하세요.")
    private String password;
}
