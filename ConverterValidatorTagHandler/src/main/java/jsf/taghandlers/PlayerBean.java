package jsf.taghandlers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PlayerBean {
    
    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());        
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void save(){
        LOG.log(Level.INFO, "Saving:  {0}", name);
    }
    
}
