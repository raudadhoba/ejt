package myPackage;
import jakarta.ejb.Stateless;

@Stateless
public class CCBean implements CCBeanLocal {

     public double r2Dollar(double r) 
    { 
        return r/83; 
    } 
    public double d2Rupees(double d) 
    { 
        return d*83; 
    }
}
