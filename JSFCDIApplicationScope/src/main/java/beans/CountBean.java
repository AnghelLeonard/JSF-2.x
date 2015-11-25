package beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
// import javax.faces.bean.ManagedBean;
// import javax.faces.bean.ManagedProperty;
// import javax.faces.bean.ApplicationScoped;

// @ManagedBean   
// @ApplicationScoped
@Named
@ApplicationScoped
public class CountBean implements Serializable {
    
    //@ManagedProperty("#{initBean}")
    @Inject
    private InitBean initBean;

    private static final Logger LOG = Logger.getLogger(CountBean.class.getName());

    private int count;

    public CountBean() {
        LOG.info("CountBean#Initializing counter ...");
        count = 0; // will be override in the init() method
    }
    
    @PostConstruct
    public void init(){
        LOG.info("CountBean#Initializing counter with @PostConstruct ...");
        count = initBean.getInit();
    }

    public void countActionVoid() {
        LOG.info("CountBean#countActionVoid() - Increasing counter ...");
        count++;
    }
    
    public String countActionAndForward() {
        LOG.info("CountBean#countActionAndForward() - Increasing counter ...");
        count++;
        return "count";
    }
    
    public String countActionAndRedirect() {
        LOG.info("CountBean#countActionAndRedirect() - Increasing counter ...");
        count++;        
        
        return "count?faces-redirect=true;";
    }

    /*
    public void setInitBean(InitBean initBean) {
        this.initBean = initBean;
    } 
    */

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }  
}
