package controllers;
 
import models.*;
 
public class Security extends Secure.Security {
	
    static boolean authenticate(String username, String password) {
    	return User.connect(username, password) != null;
    }
    
    static boolean check(String profile) {
    	
        User user = User.find("byUsername", Security.connected()).first();
        
      return true;
    }  
    

    
    static void onDisconnected() {
       

    }
}