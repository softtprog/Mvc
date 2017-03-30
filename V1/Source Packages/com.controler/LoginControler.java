package com.controler;



import java.util.Date;
 import javax.faces.bean.*;
 
import java.io.Serializable;
import org.primefaces.context.RequestContext;
 
import com.dao.*;
 
import java.sql.Connection;
import java.sql.DriverManager;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 
import java.sql.*;
import java.util.ArrayList;
 
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
 
import com.model.Customer;

@ManagedBean(name="logincontroler")
@SessionScoped
public class LoginControler  {
     
     
    public LoginControler(){ }
   
    @ManagedProperty(value="#{loginDaoImpl}")
     LoginDao loginDao;
     
     
     String login;
     String password;
   // String l = customer.getLogin();
    //    String p = customer.getPassword();
        
      
    //***************** 
    public String loginAction(){
          
        
            boolean condition =  loginDao.autentication(login, password);
              if(condition){
                   HttpSession session =   (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                    session.setAttribute("login", login);
              return "/pages/personalInf.xhtml?faces-redirect=true";
   }          else
                return "/pages/logout.xhtml?faces-redirect=true";
   }
     
    
    
    //**********************
     public String logout(){
           HttpSession session =   (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.invalidate();
              return 
            "/pages/logout.xhtml?faces-redirect=true";
    }
    //*******************
     
     
    public   String showLogin() {
	String loged = "Loged user:  ";   
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		   String login = session.getAttribute("login").toString();
           return loged + login;
    
    }
    //*****************
    
    
    
    
    
    
    
    public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
     }
    public LoginDao getLoginDao(){return loginDao;} 
    
    
    //public Customer getCustomer(){return this.customer ;}
    //  public void setCustomer(Customer customer){this.customer = customer;}
       
    
         public void setPassword(String password){this.password = password;}
      public String getPassword(){return password ;}
    
  public void setLogin(String login){this.login = login;}
    public String getLogin(){return login ;}
}
