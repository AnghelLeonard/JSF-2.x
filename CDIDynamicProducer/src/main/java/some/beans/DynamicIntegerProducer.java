package some.beans;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.util.AnnotationLiteral;
import org.omnifaces.util.Beans;

public class DynamicIntegerProducer implements Bean<Integer> {

    @SuppressWarnings("all")
    public static class DefaultAnnotationLiteral extends AnnotationLiteral<Default> implements Default {
        private static final long serialVersionUID = 1L;
    }

    @Override
    public Class<?> getBeanClass() {
        return Integer.class;
    }

    @Override
    public Set<Type> getTypes() {
        return new HashSet<>(asList(Integer.class, Object.class));
    }

    @Override
    public Integer create(CreationalContext<Integer> creationalContext) {
        InjectionPoint injectionPoint = Beans.getCurrentInjectionPoint(creationalContext);
        System.out.println("Current Injection Point: " + injectionPoint);
        return new Random().nextInt(1000);
    }

    @Override
    public Set<Annotation> getQualifiers() {
        return singleton((Annotation) new DefaultAnnotationLiteral());
    }

    @Override
    public Class<? extends Annotation> getScope() {
        return Dependent.class;
    }

    @Override
    public Set<Class<? extends Annotation>> getStereotypes() {
        return emptySet();
    }

    @Override
    public Set<InjectionPoint> getInjectionPoints() {
        return emptySet();
    }

    @Override
    public boolean isAlternative() {
        return false;
    }

    @Override
    public boolean isNullable() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void destroy(Integer instance, CreationalContext<Integer> creationalContext) {

    }
}
