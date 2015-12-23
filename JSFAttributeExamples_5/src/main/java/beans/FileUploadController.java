package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class FileUploadController {

    public void handleFileUpload(FileUploadEvent evt) {
        String playerName = (String) evt.getComponent().getAttributes().get("playerNameAttr");
        String playerSurname = (String) evt.getComponent().getAttributes().get("playerSurnameAttr");
        FacesMessage msg = new FacesMessage("Succesful", evt.getFile().getFileName() + " is uploaded for " + playerName + " " + playerSurname);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
