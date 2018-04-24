package model;

import java.sql.Date;

public class Livret extends Compte {
  
  private double taux;

  private Date dateNextEcheance;

  private double soldeInitial;

  public Livret(double taux, double soldeInitial) {
    super();
    this.taux = taux;
    this.soldeInitial = soldeInitial;
		// TODO Auto-generated constructor stub
	}


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
   *  renvoie la date de la prochaine next echeance
   */
  public double getSoldeInitial() {
    return this.soldeInitial;
  }

  /** 
   *  renvoie le montant des interets percus à la prochaine echeance
   */
  public double prochainInteret() {
	return soldeInitial*this.taux;
  }

    @Override
    public String toString(){
      return "Livret" + getIdCompte();
    }

    public boolean isLivret(){
      return true;
    }
}