package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Corporate;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

public class TestAddCustomer {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();
			CurrencyServicesRemote proxy = (CurrencyServicesRemote) context
					.lookup(jndiName);

			Corporate corporate = new Corporate();
			corporate.setId(1);
			corporate.setTypeActivity("seller");
			corporate.setLogin("login");
			corporate.setPassword("password");

			proxy.addCustomer(corporate);
			
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
