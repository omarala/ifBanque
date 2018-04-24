

import java.util.Random;

import controleur.Controleur;
import controleur.Utilisateur;
import model.Compte;
import model.Courant;
import model.Model;
import model.Livret;
import model.Credit;
import model.Operation;
import utilitaires.Date;
import vue.Vue;

public class IfBanque {

	public static void main(String[] args) {
		Compte compte1 = new Courant(12324.5, false);
		Compte compte2 = new Courant(123443, false);
		Compte compte3 = new Courant(66443.6, true);
		Livret LivretA = new Livret(0.5, 10000.0);
		Credit dettes = new Credit(0.5, 100000.0, new Date(3, 1, 1905),  5);

		Operation op1 = new Operation("ezrjhe", new Date(3, 1, 2244), 1234.6);
		Operation op2 = new Operation("credit", new Date(4, 12, 2003), 124.6);
		Operation op3 = new Operation("debit", new Date(1, 12, 2331), -1234.6);
		Operation op4 = new Operation("loyer", new Date(5, 05, 2018), -333.33);
		Operation op5 = new Operation("loyer", new Date(5, 04, 2018), -333.33);
		Operation op6 = new Operation("loyer", new Date(5, 03, 2018), -333.33);
		Operation op7 = new Operation("loyer", new Date(5, 02, 2018), -333.33);
		Operation op8 = new Operation("loyer", new Date(5, 05, 2018), -333.33);
		Operation op9 = new Operation("loyer", new Date(5, 05, 2018), -333.33);
		Operation op10 = new Operation("alimentation générale", new Date(19, 04, 2018), -24.68);
		Operation op11 = new Operation("divertissement", new Date(21, 04, 2018), -11.50);
		Operation op12 = new Operation("crédit", new Date(5, 01, 2018), 100);
		Operation op13 = new Operation("billet de train", new Date(22, 04, 2018), -75);
		Operation op14 = new Operation("salaire", new Date(25, 04, 2018), 3329.62);
		Operation op15 = new Operation("transfert", new Date(2, 05, 2018), -2000);
		Operation op16 = new Operation("transfert", new Date(2, 05, 2018), 2000);
		Operation op17 = new Operation("alimentation générale", new Date(4, 05, 2018), -56.78);
		
		
		compte2.getHistorique().add(op1);
		compte2.getHistorique().add(op2);
		compte2.getHistorique().add(op3);
		compte1.getHistorique().add(op4);
		compte1.getHistorique().add(op5);
		compte1.getHistorique().add(op6);
		compte1.getHistorique().add(op7);
		compte1.getHistorique().add(op8);
		compte1.getHistorique().add(op9);
		compte2.getHistorique().add(op10);
		compte3.getHistorique().add(op11);
		compte3.getHistorique().add(op12);
		compte2.getHistorique().add(op13);
		compte1.getHistorique().add(op14);
		compte1.getHistorique().add(op15);
		LivretA.getHistorique().add(op16);
		compte2.getHistorique().add(op17);
		
		
		
		
		Model model = new Model();
		model.getListCompte().add(compte1);
		model.getListCompte().add(compte2);
		model.getListCompte().add(compte3);
		model.getListCompte().add(LivretA);
		model.getListCredit().add(dettes);
		Utilisateur user = new Utilisateur(21312, "Thomas", "Leletty");
		
		Vue view = new Vue();
		
		Controleur cont = new Controleur(model, view, user);
	}

}
