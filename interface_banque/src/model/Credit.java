package model;

import java.util.Date;

public class Credit {

	private int idCredit;

	private double taux;

	private double montantEmprunte;

	private Date dateDebut;

	private int duree;

	public Credit(int idCredit, double taux, double montantEmprunte, Date dateDebut, int duree) {
		super();
		this.idCredit = idCredit;
		this.taux = taux;
		this.montantEmprunte = montantEmprunte;
		this.dateDebut = dateDebut;
		this.duree = duree;
	}

	public int getIdCredit() {
		return idCredit;
	}

	public void setIdCredit(int idCredit) {
		this.idCredit = idCredit;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getMontantEmprunte() {
		return montantEmprunte;
	}

	public void setMontantEmprunte(double montantEmprunte) {
		this.montantEmprunte = montantEmprunte;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getMensualite(){
		//TO-DO
		return 0.0;
	}
	
	

}