package models;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.Logger;
import play.data.validation.Required;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;

 
@Entity(name="User1")
public class User extends GenericModel {
    
	@Id
    @Required
    public String username;
    
    @Required
    public String password;
    
    public String fullname;


	public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }   
    
    public static User connect(String username, String password) {
    	
    /*	System.out.println(" Logged in User================> "+username);
  
    	 final String dbURL = "ldap://10.237.5.183:389/dc=cts,dc=com";
    	 final String dbDriver = "com.sun.jndi.ldap.LdapCtxFactory";
         DirContext ctx = null;
    	 
         Hashtable<String, String> env = new Hashtable<String, String>();
 		env.put(Context.INITIAL_CONTEXT_FACTORY, dbDriver);
 		env.put(Context.PROVIDER_URL, dbURL);
 		env.put(Context.SECURITY_AUTHENTICATION, "simple");
 		env.put(Context.SECURITY_PRINCIPAL, "cts\\"+username);
 		env.put(Context.SECURITY_CREDENTIALS, password);	
 		try {
			ctx = new InitialDirContext(env);
			if(password.equals(""))
				System.out.println("Empty");				
			else				
			return find("byUsername", username).first();
		} catch (Exception e) {
			Logger.info("LDAP Connectivity exception");
			Logger.error(e, "LDAPDataAccessManager",  e.getMessage());			
			e.printStackTrace();
		}*/
 		return find("byUsername", username).first();
    }   
    
    public String toString() {
        return fullname;
    }   
 
}
