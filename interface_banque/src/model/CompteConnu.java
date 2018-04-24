package model;

public class CompteConnu extends Compte{

	public int rib;

	public String nom;

	public String prenom;

	public CompteConnu(int rib, String nom, String prenom) {
		super();
		this.rib = rib;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getRib() {
		return this.rib;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}
	
	@Override
	public String toString() {
		return ""+prenom+" "+nom.toUpperCase();
	}

}