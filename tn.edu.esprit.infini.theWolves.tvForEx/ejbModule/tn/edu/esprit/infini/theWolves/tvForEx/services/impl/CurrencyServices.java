package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

/**
 * Session Bean implementation class CurrencyServices
 */
@Stateless
public class CurrencyServices implements CurrencyServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CurrencyServices() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> findAllCurrencies() {
		String jpql = "select c from Currency c";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public boolean addCurrency(Currency currency) {
		boolean b = false;
		try {
			entityManager.persist(currency);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

	@Override
	public boolean addTransaction(Bank bank, Currency currency,
			String typeOfTransaction, int amount, float cotation) {
		boolean b = false;
		try {
			Transaction transaction = new Transaction(typeOfTransaction,
					amount, bank, currency, cotation);
			entityManager.persist(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

	@Override
	public Bank findBankById(int id) {

		return entityManager.find(Bank.class, id);
	}

	@Override
	public Currency findCurrencyById(int id) {

		return entityManager.find(Currency.class, id);
	}

	@Override
	public boolean createOffer(Bank bank, Currency currency, float cotation) {
		boolean b = false;
		try {
			Transaction transaction = new Transaction(cotation, bank, currency);
			entityManager.persist(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

	@Override
	public boolean addBank(Bank bank) {
		boolean b = false;
		try {
			entityManager.persist(bank);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

	@Override
	public boolean addCrossTransaction(Bank bank, Bank bankBid,
			Currency currency, Currency currencyCross, String type, int amount,
			float cotation, float cotationBase) {
		Transaction transactionCross = new Transaction(type, amount, cotation,
				cotationBase, bank, currency, bankBid, currencyCross);
		boolean b = false;
		try {
			entityManager.persist(transactionCross);
			updatePosition(transactionCross);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;

	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean b = false;
		try {
			entityManager.persist(customer);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;

	}

	@Override
	public boolean updatePosition(Transaction transaction) {
		boolean b = false;
		try {
			// // the buyer bank
			// Position position = new Position(transaction.getBank(),
			// transaction.getCurrency(), transaction.getAmount());
			// Position position2 = new Position(transaction.getBank(),
			// transaction.getCurrencyCross(),
			// -(transaction.getCotation() * transaction.getAmount()));
			// // the seller bank
			// Position position3 = new Position(transaction.getBankCross(),
			// transaction.getCurrencyCross(), -transaction.getAmount());
			// Position position4 = new Position(transaction.getBankCross(),
			// transaction.getCurrency(),
			// (transaction.getCotation() * transaction.getAmount()));
			//
			// List<Position> positions = new ArrayList<Position>();
			// positions.add(position);
			// positions.add(position2);
			// positions.add(position3);
			// positions.add(position4);
			// for (Position p : positions) {
			// entityManager.merge(p);
			// }
			Position position = findPositionByBankCurrency(
					transaction.getBank(), transaction.getCurrency());
			if (position == null) {
				position = new Position(transaction.getBank(),
						transaction.getCurrency(), transaction.getAmount());
				entityManager.merge(position);
			} else if (position != null) {
				position.setCredit(transaction.getAmount());
				entityManager.merge(position);
			}

			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;

	}

	@Override
	public Position findPositionByBankCurrency(Bank bank, Currency currency) {
		String jpql = "select p from Position p where p.bank= :param1 and p.currency= :param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", bank);
		query.setParameter("param2", currency);

		Object object = null;
		try {
			object = query.getSingleResult();
			return (Position) object;

		} catch (Exception e) {
			System.err.println("pas de position ...");
		}
		return (Position) object;

	}

}
