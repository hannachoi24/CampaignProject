package com.likelion.hackaton.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class NotCorrectCity implements ConstraintValidator<InputCorrectCity,String> {

    @Override
    public void initialize(InputCorrectCity inputCorrectCity) {}

    @Override
    public boolean isValid(String city, ConstraintValidatorContext cxt){
        boolean result=true;
        if( !city.contains("시") || !city.contains("구") )
            result=false;

        if(result){
            cxt.disableDefaultConstraintViolation();
            cxt.buildConstraintViolationWithTemplate(MessageFormat.format("City form not correct!",city))
                    .addConstraintViolation();
        }
        return result;
    }
}
