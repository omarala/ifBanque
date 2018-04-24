package model;

import controleur.Controleur;

public class Courant extends Compte {


	public boolean compteConjoint;


	public Courant() {
		super();
		this.compteConjoint = false;
	}

	
	public Courant( double solde, boolean compteConjoint) {
		super(solde);
		this.compteConjoint = compteConjoint;
	}



	/**
	 * renvoie si le compte est conjoint avec une autre personne ou pas
	 */
	public boolean getCompteConjoint() {
		return this.compteConjoint;
	}
	
	public boolean isCourant() {
		return true;
	}

}