package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PingBean {

    private String number;
    private String ping;

    public PingBean() {
        number = "0000-000000";
        ping = "Nothing to ping!";
    }

    public void ping() {
        ping = "Ping number: " + number + "!";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPing() {
        return ping;
    }
}
