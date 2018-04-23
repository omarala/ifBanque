

import java.sql.Date;

import controleur.Controleur;
import controleur.Utilisateur;
import model.Compte;
import model.Courant;
import model.Model;
import model.Operation;
import vue.Vue;

public class ifBanque {

	public static void main(String[] args) {
		Compte compte1 = new Courant(123, 12324.5, false);
		Compte compte2 = new Courant(12342, 123443, false);
		Compte compte3 = new Courant(2344, 66443.6, true);

		
		Operation op1 = new Operation(12534, "ezrjhe", new Date(2244, 1, 5), 1234.6);
		Operation op2 = new Operation(12734, "credit", new Date(2000, 12, 3), 124.6);
		Operation op3 = new Operation(12434, "debit", new Date(2001, 12, 3), -1234.6);
		
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
