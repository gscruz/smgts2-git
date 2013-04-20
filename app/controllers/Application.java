package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Application extends Controller {

	// -- Authentication
	
	public static class Login {

		public String user_name;
		public String user_pass;

		public String validate() {
			if(Accounts.authenticate(user_name, user_pass) == null) {
				return "Invalid user or password";
			}
			return null;
		}

	}
	
	/**
     * Login page.
     */
    public static Result login() {
        return ok(
            login.render(form(Login.class))
        );
    }
	
	/**
     * Handle login form submission.
     */
	 
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("user_name", loginForm.get().user_name);
            return redirect(
                routes.Home.index()
            );
        }
    }
	
	/**
     * Logout and clean the session.
     */
	
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.login()
        );
    }
}
