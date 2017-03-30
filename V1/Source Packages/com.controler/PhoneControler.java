 
package com.controler;

  import com.dao.PersonalDao;
 import java.util.Random;
 import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 

@ManagedBean(name="phonecontroler")
@ViewScoped
public class PhoneControler {
    
 
    @ManagedProperty(value="#{personalDaoImpl}")
    PersonalDao personalDao;
    
    String phone;
    
    boolean visP1;
    boolean visP2;
    boolean visP3;
    boolean visP4;
    
    String  pin;
     
    String  inputPin;
    
    //********
      public String generPin(){
    
        Random r  = new Random();
          int i = r.nextInt(9999) ;
       
             this.setPin( String.valueOf(i));
                return "";
     }
    //********
    public void executeChargeTel(){
    if(this.inputPin.equalsIgnoreCase(this.pin)){
           this.setVisP3(true);
           this.setVisP4(true);
           this.setVisP2(false);
           this.setVisP1(false);
           this.setInputPin("");
           this.setPin("");}
      else {this.setInputPin("");
             FacesContext fc = FacesContext.getCurrentInstance();
               FacesMessage msg = new FacesMessage("pin wrong");
                  fc.addMessage(null, msg);
    
    }}
     
    public void executeVisPan1Pan2(boolean a, boolean b){
     this.visP1 = a; this.visP2 = b;this.setPin("****");this.setInputPin("");this.setPhone("");
    }
     public void executeVisPan1Pan2Pan3Pan4(boolean a, boolean b,boolean c,boolean d){
     this.visP1 = a; this.visP2 = b;this.visP3 = c;this.visP4 = d; this.setPin("****");this.setInputPin("");this.setPhone("");
     
    }
    public boolean executeVisible(boolean b){
        if(this.phone!=null&&b)
              return true;
    else{ 
            erasePhone();
           return false;
        }}
      
    public void erasePhone(){
    this.setPhone("");
    
    
    }
    public String chargePlay(){
    if(this.phone.startsWith("601"))
    return "confirmBookPassword.xhtml?faces-redirect=true";
    else {
         FacesContext fc = FacesContext.getCurrentInstance();
       FacesMessage msg = new FacesMessage("operator incorect");
      fc.addMessage(null, msg);
        return "";}
    
    }
    public String chargeT(){
       if(this.phone.startsWith("8")) 
    return "confirmBookPassword.xhtml?faces-redirect=true";
       else {
         FacesContext fc = FacesContext.getCurrentInstance();
       FacesMessage msg = new FacesMessage("operator incorect");
      fc.addMessage(null, msg);
        return "";}}
    
    public String chargeOrange(){
       if(this.phone.startsWith("5")) 
    return "confirmBookPassword.xhtml?faces-redirect=true";
     else  {
       FacesContext fc = FacesContext.getCurrentInstance();
       FacesMessage msg = new FacesMessage("operator incorect");
      fc.addMessage(null, msg);
        return "";}}
    
     
      public String  getPhone(){return this.phone;}
 public void setPhone(String  p){this.phone = p; }
    
    
    public void setPersonalDao(PersonalDao p){this.personalDao = p;}
    
    
 public void setVisP1 (boolean v){this.visP1 = v;    }
   public boolean isVisP1 (){return visP1 ;}
    
   public void setVisP2 (boolean v){this.visP2 = v;  }
   public boolean isVisP2 (){return visP2 ;}
   
     public void setVisP3 (boolean v){this.visP3 = v;  }
   public boolean isVisP3 (){return visP3 ;}
   
    public void setVisP4 (boolean v){this.visP4 = v;  }
   public boolean isVisP4 (){return visP4 ;}
   
     
    public String getPin(){  return this.pin; }
 public void setPin(String  pin){this.pin = pin;}

  public String  getInputPin(){return this.inputPin;}
 public void setInputPin(String  pin){this.inputPin = pin;}
    
    
    
}
