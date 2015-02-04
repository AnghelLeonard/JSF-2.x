package jsf.renderkits;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitWrapper;
import javax.faces.render.Renderer;

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
        LOG.log(Level.INFO, "--- Delegating renderer of type {0} for component in family {1} ---", new Object[]{rendererType, family});
        return getWrapped().getRenderer(family, rendererType);
    }

    @Override
    public void addRenderer(String family, String rendererType, Renderer renderer) {
        LOG.log(Level.INFO, "--- Adding the renderer of type {0} for component in family {1} ---", new Object[]{rendererType, family});
        getWrapped().addRenderer(family, rendererType, renderer);
    }

    @Override
    public RenderKit getWrapped() {
        return renderKit;
    }

}
