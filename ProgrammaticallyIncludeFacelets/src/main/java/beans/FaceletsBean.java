package beans;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.omnifaces.util.Components;
import org.omnifaces.util.Faces;

@Named
@RequestScoped
public class FaceletsBean {

    private final String cfiletext = "|file C - text as ui:param via managed bean...  ";

    public void addFaceletAction() throws IOException {

        // classic approach
        /*
         FacesContext context = FacesContext.getCurrentInstance();
         FaceletContext faceletContext = (FaceletContext) context.getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);

         faceletContext.includeFacelet(context.getViewRoot(), "/files/fileA.xhtml");
         faceletContext.setAttribute("bparam", "file B - text as ui:param via string literal...");
         faceletContext.includeFacelet(context.getViewRoot(), "/files/fileB.xhtml");
         faceletContext.setAttribute("cparam", cfiletext);
         faceletContext.includeFacelet(context.getViewRoot(), "/files/fileC.xhtml");
         */
                
        // OmniFaces shortcut
        Components.includeFacelet(Faces.getViewRoot(), "/files/fileA.xhtml");
        Faces.getFaceletContext().setAttribute("bparam", "file B - text as ui:param via string literal...");
        Components.includeFacelet(Faces.getViewRoot(), "/files/fileB.xhtml");
        Faces.getFaceletContext().setAttribute("cparam", cfiletext);
        Components.includeFacelet(Faces.getViewRoot(), "/files/fileC.xhtml");
    }
}
