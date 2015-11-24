package beans;

import java.io.Serializable;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value="schedule")
public class ScheduleBean implements Serializable {
    
    private String day;
    private String hourstart;
    private String regcode;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHourstart() {
        return hourstart;
    }

    public void setHourstart(String hourstart) {
        this.hourstart = hourstart;
    }

    public String getRegcode() {
        return regcode;
    }

    public void setRegcode(String regcode) {
        this.regcode = regcode;
    }          
}
