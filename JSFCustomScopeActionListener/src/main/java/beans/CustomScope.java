package beans;

import java.util.concurrent.ConcurrentHashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.PostConstructCustomScopeEvent;
import javax.faces.event.PreDestroyCustomScopeEvent;
import javax.faces.event.ScopeContext;

public class CustomScope extends ConcurrentHashMap<String, Object> {
    
    public static final String SCOPE = "CUSTOM_SCOPE";
 
    public CustomScope(){
        super();
    }
 
    public void scopeCreated(final FacesContext ctx) {
 
        ScopeContext context = new ScopeContext(SCOPE, this);
        ctx.getApplication().publishEvent(ctx, PostConstructCustomScopeEvent.class, context);
 
    }
 
    public void scopeDestroyed(final FacesContext ctx) {
 
        ScopeContext context = new ScopeContext(SCOPE,this);
        ctx.getApplication().publishEvent(ctx, PreDestroyCustomScopeEvent.class, context);
    } 
}
