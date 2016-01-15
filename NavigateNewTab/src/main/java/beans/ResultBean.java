package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ResultBean {
    
    public String navigate(){
        return "result";
    }
 
    public String navigateWithRedirect(){
        return "result?faces-redirect=true;";
    }
}
