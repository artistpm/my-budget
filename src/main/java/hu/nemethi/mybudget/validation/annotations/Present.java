package hu.nemethi.mybudget.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.FutureOrPresent;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface Present {

    String message() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

}
