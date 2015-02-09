package some.beans;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.enterprise.inject.Stereotype;

@Stereotype
@Target(FIELD)
@Retention(RUNTIME)
public @interface DummyStereotype {
}
