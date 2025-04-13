package com.ito.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private  String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCOde) {
        coursePrefix = theCourseCOde.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean resullt;

        if(theCode != null) {
            resullt = theCode.startsWith(coursePrefix);
        } else {
            resullt = true; // null is valid
        }
        return resullt;
    }
}
