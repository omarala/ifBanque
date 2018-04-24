

import java.util.Random;

import controleur.Controleur;
import controleur.Utilisateur;
import model.Compte;
import model.Courant;
import model.Model;
import model.Operation;
import utilitaires.Date;
import vue.Vue;

public class IfBanque {

	public static void main(String[] args) {
		Compte compte1 = new Courant(12324.5, false);
		Compte compte2 = new Courant(123443, false);
		Compte compte3 = new Courant(66443.6, true);

		
		Operation op1 = new Operation("ezrjhe", new Date(3, 1, 2244), 1234.6);
		Operation op2 = new Operation("credit", new Date(4, 12, 2003), 124.6);
		Operation op3 = new Operation("debit", new Date(1, 12, 2331), -1234.6);
		
		compte2.getHistorique().add(op1);
		compte2.getHistorique().add(op2);
		compte2.getHistorique().add(op3);
		
		Model model = new Model();
		model.getListCompte().add(compte1);
		model.getListCompte().add(compte2);
		model.getListCompte().add(compte3);
		
		Utilisateur user = new Utilisateur(21312, "Thomas", "Leletty");
		
		Vue view = new Vue();
		
		Controleur cont = new Controleur(model, view, user);
	}
	
	

}
