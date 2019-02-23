package hu.nemethi.mybudget.validation;

import hu.nemethi.mybudget.validation.annotations.Present;

import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ConstraintValidator implements javax.validation.ConstraintValidator<Present, LocalDateTime> {


    @Override
    public void initialize(Present constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {

        if( value == null ){
            return false;
        }

        LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
        return localDateTime.isEqual(value.truncatedTo(ChronoUnit.HOURS));
    }
}
