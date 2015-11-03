package beans;

import java.io.Serializable;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

// @ManagedBean
// @ViewScoped
@Named
@ViewScoped
public class InitBean implements Serializable {

    private int init;

    public InitBean() {
        init = 5;
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
        
        FacesContext context = FacesContext.getCurrentInstance();
Map<String, Object> viewMap = context.getViewRoot().getViewMap();


    }

}
