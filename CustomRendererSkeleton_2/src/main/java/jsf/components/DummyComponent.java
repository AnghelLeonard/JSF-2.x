package jsf.components;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import jsf.renderers.DummyRenderer;

@FacesComponent(createTag = true)
public class DummyComponent extends UIOutput {  
    
    // inherits the UIOutput component-family: javax.faces.Output
    //default renderer-type: javax.faces.Text is replaced by DummyRenderer
    
     public DummyComponent() {
        setRendererType(DummyRenderer.RENDERER_TYPE);         
    }        
}
