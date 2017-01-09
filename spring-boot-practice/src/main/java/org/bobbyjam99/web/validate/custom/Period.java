package org.bobbyjam99.web.validate.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PeriodValidator.class})
public @interface Period {

    String message() default "{org.bobbyjam99.validator.constraints.Period.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldFrom() default "from";
    String fieldTo() default "to";

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public static @interface List{
        Period[] valie();
    }
}
