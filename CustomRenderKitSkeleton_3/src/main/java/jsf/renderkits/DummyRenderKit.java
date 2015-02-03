package jsf.renderkits;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitWrapper;
import javax.faces.render.Renderer;
import jsf.renderers.DummyRenderer;

public class DummyRenderKit extends RenderKitWrapper {

    private static final Logger LOG = Logger.getLogger(DummyRenderKit.class.getName());
    private RenderKit renderKit;

    public DummyRenderKit() {
    }

    public DummyRenderKit(RenderKit renderKit) {
        LOG.log(Level.INFO, "Default RenderKit instance provided by JSF: {0}", renderKit.getClass().getSimpleName());
        this.renderKit = renderKit;
    }    
    
    @Override
    public Renderer getRenderer(String family, String rendererType) {        
        // instruct JSF to use the DummyRenderer for each component that belongs to the "javax.faces.Input" family
        if (family.equals("javax.faces.Input")) {
            LOG.log(Level.INFO, "--- Delegating renderer of type {0} for component in family {1} ---", new Object[]{rendererType, family});
            Renderer renderer = getWrapped().getRenderer(family, rendererType);
            return new DummyRenderer(renderer);
        }
        return getWrapped().getRenderer(family, rendererType);
    }
    
    @Override
    public RenderKit getWrapped() {
        return renderKit;
    }

}
