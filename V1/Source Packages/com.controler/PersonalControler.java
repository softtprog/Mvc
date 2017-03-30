package com.controler;

import com.dao.PersonalDao;
import com.model.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

 
@ManagedBean(name="personalcontroler")
@SessionScoped
public class PersonalControler implements Serializable  {
    
    public PersonalControler  (){}
    
    @ManagedProperty(value="#{personalDaoImpl}")
    PersonalDao personalDao;
     
    
    
    //Customer cust1 = new Customer();
    Customer cust = new Customer();
    
    List<String> phones = new ArrayList<>();
    
    
     String name;
     String surname;
     String adres;
     String tel;
     String email;
     String password;
     
     boolean visPan1  = false;
     
     boolean visPan2  = false;
     
     String  pin;
     
     String  inputPin;
     
     boolean initPersData;
     
     boolean initPhones;
     
      String phoneToErase;
      
      String phoneToAdd;
  
    public void initCustomerData(){
       if(!this.initPersData)
               cust = personalDao.initCustomerData();
         this.setInitPersData(true);
     
    
    }
    //*********
     public void initPhones(){
    if(!this.initPhones)
               phones = this.personalDao.initPhones();
    this.setInitPhones(true);
    
    }
    
    //*********
     public String erasePhone( ){
     phones = this.personalDao.erasePhone(phoneToErase);
     return "";
      
     
     }
     //*******
     public void addPhone(ActionEvent e){
        List<String> ph = new ArrayList<>();
         ph = this.personalDao.getPhones();
               if(!ph.contains(phoneToAdd)){
                     phones = this.personalDao.addPhone(phoneToAdd);
                     this.setPhoneToAdd("");}
               else{
       FacesContext fc = FacesContext.getCurrentInstance();
       FacesMessage msg = new FacesMessage("this phone is on your tab");
       fc.addMessage(null, msg);
       this.setPhoneToAdd("");
        } 
     }
     
     //*******
    public String changeCustomerData(){
       this.visPan1 = false;
       this.setInputPin("");
       cust = personalDao.changeCustomer(name, surname,  adres,  tel,   email,  password);
        this.setName("");
        this.setSurname("");
        this.setAdres("");
        this.setTel("");
        this.setEmail("");
        this.setPassword(""); 
           
     return "/pages/confirmChangePers.xhtml?faces-redirect=true";
    }
  //*********
    public String fetchCustData(){
     
    return "/pages/personalInf.xhtml?faces-redirect=true";
    }
    //**********
      public void generPin(){
    
         Random r  = new Random();
         int i = r.nextInt(9999) ;
         this.setPin( String.valueOf(i));
     }
    //*******
    public void showPan2(){
     if(this.inputPin.equalsIgnoreCase(this.pin)){
              this.setVisPan2(true);
              this.setInputPin("");
              this.setPin("");}
     else {
         this.setInputPin("");
         this.setPin(pin);
         FacesContext fc = FacesContext.getCurrentInstance();
         FacesMessage msg = new FacesMessage("pin wrong");
         fc.addMessage(null, msg);
      
     }
    }
     
   public void clearPanels(){
        this.executeVisPan1VisPan2(false, false);
        this.setPin("****");this.setInputPin("");
   }
    //***********
    
      public void executeVisPan1VisPan2(boolean v, boolean v1){this.visPan1 = v; this.visPan2 = v1;}
    //******
    public Customer getCust(){return this.cust;}
    public void setCust(Customer c){this.cust = c;}
    
     public void setPersonalDao(PersonalDao p){this.personalDao = p;}
     
    public void setName(String g){this.name = g;}
 public String getName(){return this.name;}
    
      
  public void setSurname(String g){this.surname = g;}
 public String getSurname(){return this.surname;}
 
  public void setAdres(String g){this.adres = g;}
 public String getAdres(){return this.adres;}
 
  public void setTel(String g){this.tel = g;}
 public String getTel(){return this.tel;}
 
  public void setEmail(String g){this.email = g;}
 public String getEmail(){return this.email;}
 
  public void setPassword(String g){this.password = g;}
 public String getPassword(){return this.password;}
 
     public void setPhones(List<String> g){this.phones = g;}
 public List<String> getPhones(){ return this.phones;}

   public String getPin(){  return this.pin; }
 public void setPin(String  pin){this.pin = pin;}

  public String  getInputPin(){return this.inputPin;}
 public void setInputPin(String  pin){this.inputPin = pin;}
 
 
 public void setVisPan1 (boolean v){this.visPan1 = v;    }
   public boolean isVisPan1 (){return visPan1 ;}
    
   public void setVisPan2 (boolean v){this.visPan2 = v;  }
   public boolean isVisPan2 (){return visPan2 ;}
   
  
   public void setInitPersData (boolean v){this.initPersData = v;  }
   public boolean isInitPersData (){return initPersData ;}
   
 public void setInitPhones (boolean v){this.initPhones = v;  }
   public boolean isInitPhones (){return initPhones ;}
   
    public String  getPhoneToErase(){return this.phoneToErase;}
 public void setPhoneToErase(String  p){this.phoneToErase = p;}
   
   public String  getPhoneToAdd(){return this.phoneToAdd;}
 public void setPhoneToAdd(String  p){this.phoneToAdd = p;}
  
}
