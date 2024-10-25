package mypackage;

public class CheckerBean {
    String name,hob,email,gender,error; int age; 
    public CheckerBean() 
    { 
        name=""; 
        hob=""; 
        email=""; 
        gender=""; 
        error=""; 
        age=0; 
    } 
    public void setName(String n) 
    { 
        name=n; 
    } 
    public String getName() 
    { 
        return name; 
    } 
    public void setAge(int a) 
    { 
        age=a; 
    } 
    public int getAge() 
    { 
        return age; 
    } 
    public void setHob(String h) 
    { 
        hob=h; 
    } 
    public String getHob() 
    { 
        return hob; 
    }
     public void setEmail(String e) 
    { 
        email=e; 
    } 
    public String getEmail() 
    { 
        return email; 
    } 
    public void setGender(String g) 
    { 
        gender=g; 
    } 
    public String getGender() 
    { 
        return gender; 
    } 
    public String getError() 
    { 
        return error; 
    } 
    public boolean validate() 
    { 
        boolean res=true; 
        if(name.trim().equals("")) 
        { 
            error+="<br>ENTER FIRST NAME"; 
            res=false; 
        } 
        if(age<0||age>99) 
        { 
            error+="<br>AGE INVALID";  
            res=false; 
        } 
        String emailregex="^[A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 
        Boolean b=email.matches(emailregex); 
        if(!b) 
        { 
            error+="<br>EMAIL INVALID"; 
            res=false; 
        } 
        return res;
    }
    
}
