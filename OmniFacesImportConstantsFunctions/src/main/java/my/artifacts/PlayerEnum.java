package my.artifacts;

public enum PlayerEnum {
    RAFAEL_NADAL, ROGER_FEDERER, ANDY_MURRAY, NOVAK_DJOKOVIC, MILOS_RAONIC;
    
    public String getFriendlyName(){
        String firstName = name().substring(0, name().indexOf("_"));
        String secondName = name().substring(name().indexOf("_")+1);
        return firstName.charAt(0) + firstName.substring(1).toLowerCase() + " " + secondName.charAt(0) + secondName.substring(1).toLowerCase();
    }
}

