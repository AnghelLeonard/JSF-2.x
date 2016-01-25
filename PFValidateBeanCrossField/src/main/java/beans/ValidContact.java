package beans;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author Anghel Leonard
 */
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import org.primefaces.validate.bean.ClientConstraint;

@Documented
@Constraint(validatedBy = {ContactValidator.class})
@ClientConstraint(resolvedBy=ValidContactClientConstraint.class)
@Target({ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
public @interface ValidContact {

    String message() default "Invalid contact !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
