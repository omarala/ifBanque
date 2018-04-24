package model;

import java.util.LinkedList;

public class Model {

	private LinkedList<Compte> listCompte;

	private LinkedList<Credit> listCredit;

	private LinkedList<CompteConnu> listCompteConnu;

	public static LinkedList<String> listCategorie;
	
	public Model() {
		super();
		this.listCompte = new LinkedList<Compte>();
		this.listCredit = new LinkedList<Credit>();
		this.listCompteConnu = new LinkedList<CompteConnu>();
		listCategorie = new LinkedList<String>();
		listCategorie.add("");
		listCategorie.add("Loisir");
		listCategorie.add("Alimentation");
		listCategorie.add("Sortie");
		listCategorie.add("Virement");
	}

	public LinkedList<Compte> getListCompte() {
		return listCompte;
	}


	public LinkedList<Credit> getListCredit() {
		return listCredit;
	}


	public LinkedList<CompteConnu> getListCompteConnu() {
		return listCompteConnu;
	}

	public LinkedList<Livret> getListLivret(){
		LinkedList<Livret> livrets = new LinkedList<Livret>();
		for(Compte compte : listCompte) {
			if(compte.isLivret()) {
				livrets.add((Livret)compte);
			}
		}
		return livrets;
	}
	
	public LinkedList<Courant> getListCourant(){
		LinkedList<Courant> courants = new LinkedList<Courant>();
		for(Compte compte : listCompte) {
//			System.out.println("compte");
			if(compte.isCourant()) {
//				System.out.println("courant");
				courants.add((Courant)compte);
			}
		}
		return courants;
	}


}