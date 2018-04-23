package model;

import java.sql.Date;

public class Livret extends Compte {

  public Livret(int idCompte) {
		super(idCompte);
		// TODO Auto-generated constructor stub
	}

private double taux;

  private Date dateNextEcheance;

  private double soldeInitial;

  /** 
   *  renvoie le taux du livret
   */
  public double getTaux() {
	return taux;
  }

  /** 
   *  renvoie la date de la prochaine next echeance
   */
  public Date getDateNextEcheance() {
	return this.dateNextEcheance;
  }

  /** 
   *  renvoie le montant des interets percus à la prochaine echeance
   */
  public double prochainInteret() {
	return this.getSolde()*this.taux;
  }

}