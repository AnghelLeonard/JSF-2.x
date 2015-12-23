package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean {

    private String name;
    private String surname;
    private String bank;
    private String cbank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCbank() {
        return cbank;
    }

    public void setCbank(String cbank) {
        this.cbank = cbank;
    } 
}
