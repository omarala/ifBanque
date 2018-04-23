package model;

import java.util.LinkedList;

public class Courant extends Compte {


	public boolean compteConjoint;


	public Courant(int idCompte) {
		super(idCompte);
		this.compteConjoint = false;
	}

	
	public Courant(int idCompte, double solde, boolean compteConjoint) {
		super(idCompte, solde);
		this.compteConjoint = compteConjoint;
	}



	/**
	 * renvoie si le compte est conjoint avec une autre personne ou pas
	 */
	public boolean getCompteConjoint() {
		return this.compteConjoint;
	}

}