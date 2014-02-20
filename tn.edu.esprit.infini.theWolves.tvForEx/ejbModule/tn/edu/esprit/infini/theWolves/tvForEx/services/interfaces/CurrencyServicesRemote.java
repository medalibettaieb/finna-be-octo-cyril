package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;

@Remote
public interface CurrencyServicesRemote {

	List<Currency> findAllCurrencies();

	boolean addCurrency(Currency currency);

	boolean addTransaction(Bank bank, Currency currency,
			String typeOfTransaction, int amount, float f);

	Bank findBankById(int id);

	Currency findCurrencyById(int id);

	boolean createOffer(Bank bank, Currency currency, float cotation);

	boolean addBank(Bank bank);

	boolean addCrossTransaction(Bank bank, Bank bankBid, Currency currency,
			Currency currencyCross, String type, int amount, float cotation,
			float cotationBase);

	boolean addCustomer(Customer customer);

	boolean updatePosition(Transaction transaction);

	Position findPositionByBankCurrency(Bank bank, Currency currency);
}
