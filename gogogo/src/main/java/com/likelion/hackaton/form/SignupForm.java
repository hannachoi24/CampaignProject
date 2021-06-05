package com.likelion.hackaton.form;

import com.likelion.hackaton.validation.EmailUnique;
import com.likelion.hackaton.validation.InputCorrectCity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignupForm {
    @NotBlank(message = "이름을 필수로 입력하세요.")
    private String name;

    @NotBlank(message = "비밀번호를 필수로 입력하세요.")
    @Size(min=4,message = "비밀번호는 최소 4자리 입니다.")
    private String password;

    @NotBlank(message = "이메일을 필수로 입력하세요.")
    @EmailUnique
    @Email(message = "이메일 형태를 확인해주세요.")
    private String email;

    @NotBlank(message = "동네이름을 넣어주세요.")
    @InputCorrectCity
    private String city;
}

