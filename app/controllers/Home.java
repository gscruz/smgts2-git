package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import java.util.*;

import models.*;

import views.html.*;

@Security.Authenticated(Secured.class)
public class Home extends Controller {
  
    public static Result index() {
        return TODO;
    }
	
}
