package com.dr5hx.web.validation;

import com.dr5hx.web.annotation.MyConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintClass implements ConstraintValidator<MyConstraint, Object> {
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("自定义注解开始");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
//        System.out.println(value.getClass().getName());
        System.out.println(value);
        return false;
    }
}
