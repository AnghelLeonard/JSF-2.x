package beans;

import java.lang.reflect.Member;
import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Anghel Leonard
 */
public class MyLogger {  
    
    @Produces
    Logger produceLogger(InjectionPoint injectionPoint) {

        // get the field injection (e.g. fooLog, buzzLog, bizzLog)       
        Member field = injectionPoint.getMember();
        System.out.println("Member: " + field);

        // get the class containing the field injection
        Class<?> fieldClass = field.getDeclaringClass();
        System.out.println("Class: " + fieldClass);

        // get the class name
        String className = fieldClass.getName();
        System.out.println("Class name: " + className);

        return Logger.getLogger(className);
    }
}
