package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(name="user_account")
public class Accounts extends Model {
	
	@Id
	@Constraints.Required
	public Long acc_id;
	
	@Constraints.Required
	@Formats.NonEmpty
	public String user_name;
	
	@Constraints.Required
	@Formats.NonEmpty
	public String user_pass;
	
	@Constraints.Required
	public int group_id;
	
	public static Finder<Long,Accounts> find = new Finder<Long,Accounts>(Long.class, Accounts.class);
	
	public static Accounts authenticate(String user_name, String user_pass) {
		System.out.println(user_name + " " + user_pass);
		return find.where()
			.eq("user_name", user_name)
			.eq("user_pass", user_pass)
			.findUnique();
		
	}
			
}