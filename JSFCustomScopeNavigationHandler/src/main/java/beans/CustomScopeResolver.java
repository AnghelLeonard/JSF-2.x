package beans;

import java.beans.FeatureDescriptor;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.PropertyNotFoundException;
import javax.el.PropertyNotWritableException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Leonard
 */
public class CustomScopeResolver extends ELResolver {

    private static final Logger logger = Logger.getLogger(CustomScopeResolver.class.getName());

    @Override
    public Object getValue(ELContext context, Object base, Object property) {

        logger.log(Level.INFO, "Get Value property : {0}", property);

        if (property == null) {
            throw new PropertyNotFoundException("NULL_PARAMETERS");
        }

        FacesContext facesContext = (FacesContext) context.getContext(FacesContext.class);

        if (base == null) {

            Map<String, Object> applicationMap = facesContext.getExternalContext().getApplicationMap();
            CustomScope scope = (CustomScope) applicationMap.get(CustomScope.SCOPE);

            if (CustomScope.SCOPE.equals(property)) {
                logger.log(Level.INFO, "Found request | base={0} property={1}", new Object[]{base, property});
                context.setPropertyResolved(true);
                return scope;
            } else {
                logger.log(Level.INFO, "Search request | base={0} property={1}", new Object[]{base, property});
                if (scope != null) {
                    Object value = scope.get(property.toString());
                    if (value != null) {
                        logger.log(Level.INFO, "Found request | base={0} property={1}", new Object[]{base, property});
                        context.setPropertyResolved(true);
                    } else {
                        logger.log(Level.INFO, "Not found request | base={0} property={1}", new Object[]{base, property});
                        context.setPropertyResolved(false);
                    }
                    return value;
                } else {
                    return null;
                }
            }
        }

        if (base instanceof CustomScope) {

            CustomScope baseCustomScope = (CustomScope) base;
            Object value = baseCustomScope.get(property.toString());
            logger.log(Level.INFO, "Search request | base={0} property={1}", new Object[]{base, property});

            if (value != null) {
                logger.log(Level.INFO, "Found request | base={0} property={1}", new Object[]{base, property});
                context.setPropertyResolved(true);
            } else {
                logger.log(Level.INFO, "Not found request | base={0} property={1}", new Object[]{base, property});
                context.setPropertyResolved(false);
            }

            return value;
        }

        return null;

    }

    @Override
    public Class<?> getType(ELContext context, Object base, Object property) {
        return Object.class;
    }

    @Override
    public void setValue(ELContext context, Object base, Object property, Object value) {

        if (base != null) {
            return;
        }

        context.setPropertyResolved(false);

        if (property == null) {
            throw new PropertyNotFoundException("NULL_PARAMETERS");
        }
        if (CustomScope.SCOPE.equals(property)) {
            throw new PropertyNotWritableException((String) property);
        }
    }

    @Override
    public boolean isReadOnly(ELContext context, Object base, Object property) {
        return true;
    }

    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
        return null;
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext context, Object base) {
        if (base != null) {
            return null;
        }
        return String.class;
    }
}
