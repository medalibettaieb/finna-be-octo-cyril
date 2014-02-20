package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Position
 * 
 */
@Entity
public class Position implements Serializable {

	private int id;
	private float credit;
	private float averageCost;
	private static final long serialVersionUID = 1L;

	private Bank bank;
	private Currency currency;

	public Position() {
		super();
	}

	public Position(Bank bank, Currency currency, float amount) {
		super();
		this.credit += amount;
		this.bank = bank;
		this.currency = currency;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCredit() {
		return this.credit;
	}

	public void setCredit(float credit) {
		this.credit += credit;
	}

	@ManyToOne
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@ManyToOne
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public float getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(float averageCost) {
		this.averageCost = averageCost;
	}

}
