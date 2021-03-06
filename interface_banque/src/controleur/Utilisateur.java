package controleur;

import java.util.LinkedList;

import model.Compte;
import model.CompteConnu;
import model.Operation;
import utilitaires.Date;

public class Utilisateur {

	private int idUtilisateur;

	private String prenom;

	private String nom;

	public Utilisateur(int idUtilisateur, String prenom, String nom) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.prenom = prenom;
		this.nom = nom;
	}

	public boolean transferer(Compte compteDebiteur, Compte crediteur, double montant) {
		compteDebiteur.majSolde();
		if (montant < compteDebiteur.getSolde()) {

			Operation debit = new Operation("virement", new Date(), -montant);
			compteDebiteur.getOpAVenir().addFirst(debit);
			if(crediteur.isCourant() || crediteur.isLivret()) {
				Operation credit = new Operation("virement", new Date(), montant);
				crediteur.getOpAVenir().add(credit);
				crediteur.majSolde();
			}
			return true;
		}
		return false;
	}
	
	public void ajoutCompteConnu(LinkedList<Compte> listCompteConnu, int rib, String nom, String prenom) {
		CompteConnu nouveauCompte = new CompteConnu(rib, nom, prenom);
		listCompteConnu.add(nouveauCompte);
	}
	
	
	
}