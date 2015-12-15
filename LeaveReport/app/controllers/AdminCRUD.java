
package controllers;

import controllers.Secure.Security;
import models.User;
import play.mvc.Before;

public class AdminCRUD extends CRUD {

    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
        	User user = User.find("byUsername", Security.connected()).first();
            renderArgs.put("user", user.fullname);
        }
    }
}
