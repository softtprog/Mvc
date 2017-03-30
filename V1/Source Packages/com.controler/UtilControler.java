 
package com.controler;

 import com.dao.PersonalDao;
import com.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

 
@ManagedBean(name="utilcontroler")
@ViewScoped
public class UtilControler {
    
    
    
     @ManagedProperty(value="#{personalDaoImpl}")
    PersonalDao personalDao;
     
    String featurePasswords;
    
    boolean trigger = false;
    
      
    public String bookPasswordsLetter(){
    FacesContext fc = FacesContext.getCurrentInstance();
         Map<String,String> reqParam =  fc.getExternalContext().getRequestParameterMap();
     featurePasswords = reqParam.get("featurePasswords");
    return "/pages/confirmBookPassword.xthml?faces-redirect=true&featurePasswords ="+featurePasswords ;
    }
    
       public void setPersonalDao(PersonalDao p){this.personalDao = p;}
     
   

 

    
    public String getFeaturePasswords(){return this.featurePasswords;}
  public void setFeaturePasswords(String g){this.featurePasswords = g;}
    
  public boolean getTrigger(){return this.trigger;}
  public void setTrigger(boolean t){this.trigger = t;}
  
  
}
