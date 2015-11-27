package beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class CountBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(CountBean.class.getName());

    private int count;

    public CountBean() {
        count = 5;
        LOG.log(Level.INFO, "CountBean Constructor! Current value: {0}", count);
    }

    @PostConstruct
    public void CountBean() {
        count++;
        LOG.log(Level.INFO, "CountBean PostConstruct! Current value: {0}", count);
    }

    public void increaseCount() {
        count++;
        LOG.log(Level.INFO, "Current value: {0}", count);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
