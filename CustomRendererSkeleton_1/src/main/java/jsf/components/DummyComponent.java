package jsf.components;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import jsf.renderers.DummyRenderer;

@FacesComponent(value = DummyComponent.COMPONENT_TYPE, createTag = true)
public class DummyComponent extends UIComponentBase {

    public static final String COMPONENT_FAMILY = "jsf.components";
    public static final String COMPONENT_TYPE = "jsf.components.DummyComponent";

    public DummyComponent() {
        setRendererType(DummyRenderer.RENDERER_TYPE);
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }

}
