package controleur;
import model.Compte;
import model.Operation;

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

///** 
//   *  fonction qui transfere une quantité d'argent d'un compte debiteur à un compte créditeur 
//   */
//  public void transferer(Compte compteDebiteur, Compte CompteCrediteur, double montant) {
//	compteDebiteur.majSolde();
//	afficheSolde(compteDebiteur.getSolde());
//	if(montant < compteDebiteur.getSolde()){
//		Operation debit = new Operation(12345,"debit", Date.now, montant);
//		compteDebiteur.getOpAVenir().addFirst(debit);
//		Operation credit = new Operation(12345,"credit", Date.now, montant);
//		compteCrediter.getOpAvenir().addFirst(credit);
//		
//	}else{
//		affiche("solde insuffisant sur le compte "+compteDebiteur.getIdCompte());
//	}
//  }
//
//  public void virement(Courant comptDebiteur, CompteConnu destinataire,  montant) {
//  }
//
//  public void ajouterCompteConnu(LinkedList<CompteConnu> listeCompteConnu, int rib, String nom, String prenom) {
//  }

}