package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

/**
 * Entity implementation class for Entity: Corporate
 *
 */
@Entity

public class Corporate extends Customer implements Serializable {

	
	private String typeActivity;
	private static final long serialVersionUID = 1L;

	public Corporate() {
		super();
	}   
	public String getTypeActivity() {
		return this.typeActivity;
	}

	public void setTypeActivity(String typeActivity) {
		this.typeActivity = typeActivity;
	}
   
}
