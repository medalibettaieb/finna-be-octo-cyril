package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Bank
 * 
 */
@Entity
public class Bank implements Serializable {

	private int id;
	private String name;
	private static final long serialVersionUID = 1L;

	private List<Transaction> transactions;
	private List<Transaction> transactionsCross;
	

	public Bank() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "bank")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@OneToMany(mappedBy = "bankCross")
	public List<Transaction> getTransactionsCross() {
		return transactionsCross;
	}

	public void setTransactionsCross(List<Transaction> transactionsCross) {
		this.transactionsCross = transactionsCross;
	}

}
