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


	public LinkedList<Compte> getListCompteConnu() {
		LinkedList<Compte> list = listCompte;
		for(Compte c:listCompteConnu) {
			list.add((Compte)c);
		}
		return list;
	}

	public LinkedList<Compte> toListCompte(){
		LinkedList<Compte> list = new LinkedList<Compte>();
		for(CompteConnu c:listCompteConnu) {
			list.add(c);
		}
		return list;
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
			if(compte.isCourant()) {
				courants.add((Courant)compte);
			}
		}
		return courants;
	}


}