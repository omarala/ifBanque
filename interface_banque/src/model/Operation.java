package model;

import java.sql.Date;

public class Operation {

	private int idOperation;

	private String categorie = "undefined";

	private Date date;

	public double montant;

	public Operation(int idOperation, String categorie, Date date, double montant) {
		super();
		this.idOperation = idOperation;
		this.categorie = categorie;
		this.date = date;
		this.montant = montant;
	}

	public int getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Object[] getRowOperation() {
		Object[] vect = new Object[4];
		vect[0] = idOperation;
		vect[1] = categorie;
		vect[2] = ""+date.getDate()+"-"+date.getMonth()+"-"+date.getYear();
		vect[3] = montant;
		return vect;
	}

	public static Object[] getRowName() {
		Object[] vect = new Object[4];
		vect[0] = "idOperation";
		vect[1] = "categorie";
		vect[2] = "date";
		vect[3] = "montant";
		return vect;
	}
	
}