package beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CountBean implements Serializable {

    @ManagedProperty(value = "#{initBean}")
    private InitBean initBean;

    private static final Logger LOG = Logger.getLogger(CountBean.class.getName());

    private int count;

    public CountBean() {
        LOG.info("CountBean#Initializing counter ...");
        count = 0; // will be override in the init() method
    }

    @PostConstruct
    public void init() {
        LOG.info("CountBean#Initializing counter with @PostConstruct ...");
        count = initBean.getInit();
    }

    public void increaseCount() {
        count++;
        initBean.setInit(count);
        LOG.log(Level.INFO, "Current value: {0}", count);
    }

    public InitBean getInitBean() {
        return initBean;
    }

    public void setInitBean(InitBean initBean) {
        this.initBean = initBean;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
