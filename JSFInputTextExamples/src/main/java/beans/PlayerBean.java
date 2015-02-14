package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable{
    
    private String name;
    private String email;
    private String weburl; 
    private String countrycode;
    private String color;
    private String date;
    private String localtime;
    private String month;
    private String age;
    private String tournaments;
    private String week;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }    
    
    public String getTournaments() {
        return tournaments;
    }

    public void setTournaments(String tournaments) {
        this.tournaments = tournaments;
    }        

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }        

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }        

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }   
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }        

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }            

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }        

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }       

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

          
}
