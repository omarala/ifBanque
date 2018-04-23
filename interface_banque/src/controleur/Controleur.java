package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import vue.Vue;

public class Controleur {

	private Model model;
	private Vue view;
	private Utilisateur user;

	public Controleur(Model model, Vue vue, Utilisateur user) {
		super();
		this.model = model;
		this.view = vue;
		this.user = user;

//		System.out.println("probleme");
//		System.out.println(view.getPrincipal().getBtnVosCompte());

		this.view.getPrincipal().addBoutonVosCompteListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getPrincipal().afficheListCompte(getThis().getModel().getListCompte());

			}
		});
		
		this.view.getPrincipal().addBoutonVosCreditListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getPrincipal().afficheListCredit(model.getListCredit());

			}
		});
		
		this.view.getPrincipal().addBoutonLivretListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getPrincipal().afficheListLivret(model.getListLivret());
				
			}
		});

	}

	public Controleur getThis() {
		return this;
	}

	public Model getModel() {
		return model;
	}

	public Vue getView() {
		return view;
	}

	public Utilisateur getUser() {
		return user;
	}
	
	
	
	
}