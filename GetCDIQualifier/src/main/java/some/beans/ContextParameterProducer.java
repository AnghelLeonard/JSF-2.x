package some.beans;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import org.omnifaces.util.Beans;
import org.omnifaces.util.Faces;

public class ContextParameterProducer {

    public static final String CONTEXT_PARAM_NOT_FOUND = "CONTEXT_PARAM_NOT_FOUND";

    @SuppressWarnings("unused") // Workaround for OpenWebBeans not properly passing it as produce() method argument.
    @Inject
    private InjectionPoint injectionPoint;

    @Produces
    @ContextParam
    public String produce(InjectionPoint injectionPoint) {
        ContextParam contextParam = Beans.getQualifier(injectionPoint, ContextParam.class);
        return contextParam.name().isEmpty() ? CONTEXT_PARAM_NOT_FOUND : Faces.getInitParameter(contextParam.name());
    }
}
