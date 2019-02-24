package hu.nemethi.mybudget.validation.annotations;

import hu.nemethi.mybudget.validation.PresentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = PresentValidator.class)
@Documented
public @interface Present {

    String message() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

}
