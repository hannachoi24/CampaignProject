package com.likelion.hackaton.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailDuplicationValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnique {
    String message() default "중복된 이메일 입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
