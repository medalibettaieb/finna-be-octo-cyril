package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Currency
 * 
 */
@Entity
public class Currency implements Serializable {

	private int id;
	private String label;
	private String initials;
	private static final long serialVersionUID = 1L;

	private List<Transaction> transactions;
	private List<Transaction> transactionsCross;

	public Currency() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getInitials() {
		return this.initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	@OneToMany(mappedBy = "currency")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@OneToMany(mappedBy = "currencyCross")
	public List<Transaction> getTransactionsCross() {
		return transactionsCross;
	}

	public void setTransactionsCross(List<Transaction> transactionsCross) {
		this.transactionsCross = transactionsCross;
	}

}
