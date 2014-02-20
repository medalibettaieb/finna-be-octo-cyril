package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public class Customer implements Serializable {

	
	private int id;
	private String name;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
