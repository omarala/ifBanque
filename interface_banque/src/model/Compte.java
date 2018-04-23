package model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Classe abstraite d'un compte bancaire, qui sera soit un compte courant ou un
 * compte livret
 */
public abstract class Compte {

	private int idCompte;

	private double solde;

	private LinkedList<Operation> historique;

	private LinkedList<Operation> opAvenir;

	
	public Compte(int idCompte) {
		this.idCompte = idCompte;
		this.solde = 0.0;
		this.historique = new LinkedList<Operation>();
		this.opAvenir = new LinkedList<Operation>();
	}
	
	public Compte(int idCompte, double solde) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.historique = new LinkedList<Operation>();
		this.opAvenir = new LinkedList<Operation>();
	}

	/**
	 * renvoie idCompte
	 */
	public int getIdCompte() {
		return idCompte;
	}

	/**
	 * renvoie le solde du compte
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * met a jour le solde du compte en prenant en compte les opérations à venir
	 * arrivant à échéance
	 */
	public void majSolde() {
		Iterator<Operation> iter = this.opAvenir.descendingIterator();
		while (iter.hasNext()) {
			Operation oper = iter.next();
			solde += oper.getMontant();
			historique.addFirst(oper);
		}
	}

	/**
	 * renvoie 10 opérations contenue dans l"historique
	 */
	public LinkedList<Operation> getHistorique() {
		return this.historique;
	}

	/**
	 * renvoie la liste d'opérations à venir
	 */
	public LinkedList<Operation> getOpAVenir() {
		return this.opAvenir;
	}

	public boolean isLivret() {
		return false;
	}

	public boolean isCourant() {
		return false;
	}
	
	@Override
	public String toString() {
		return "courant"+idCompte;
	}

}