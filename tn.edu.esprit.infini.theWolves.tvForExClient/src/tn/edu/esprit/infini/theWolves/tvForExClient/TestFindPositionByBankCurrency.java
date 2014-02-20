package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

public class TestFindPositionByBankCurrency {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();
			CurrencyServicesRemote proxy = (CurrencyServicesRemote) context
					.lookup(jndiName);

			Bank bank = proxy.findBankById(1);
			Currency currency = proxy.findCurrencyById(1);
			Position position = proxy
					.findPositionByBankCurrency(bank, currency);

			System.out.println(position.getId());

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
