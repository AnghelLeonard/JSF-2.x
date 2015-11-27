package beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

@ManagedBean
@NoneScoped
public class InitBean implements Serializable {
    
    private static final Logger LOG = Logger.getLogger(InitBean.class.getName());
        
    private int init;

    public InitBean() {
        LOG.info("InitBean#Constructor invoked ...");
        init = 5;
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }
}
