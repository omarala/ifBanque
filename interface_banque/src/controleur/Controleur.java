package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import model.CompteConnu;
import model.Model;
import vue.CompteConnuDialog;
import vue.VirementPanel;
import vue.Vue;

public class Controleur {
	public static int idInt = 1000000;
	public static Random rand = new Random();

	public static int getId() {
		idInt += rand.nextInt(10000);
		return idInt;
	}

	private Model model;
	private Vue view;
	private Utilisateur user;

	public Controleur(Model model, Vue vue, Utilisateur user) {
		super();
		this.model = model;
		this.view = vue;
		this.user = user;

		// System.out.println("probleme");
		// System.out.println(view.getPrincipal().getBtnVosCompte());

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

		this.view.getPrincipal().addBoutonVirementListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.getPrincipal().affichageVirement(model.getListCompte(), model.getListCompteConnu());

			}
		});


		this.view.getPrincipal().getVirPanel().getBtnValider().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VirementPanel virPane = getThis().view.getPrincipal().getVirPanel();
				String strMontant = virPane.getMontant();
				try {
					double doubleMontant = Double.parseDouble(strMontant);
					boolean test = user.transferer(virPane.getDebiteur(), virPane.getCompteSelectionne(),
							doubleMontant);
					virPane.getDebiteur().majSolde();
					if (test == true) {
						JOptionPane.showMessageDialog(null, "virement effectué avec succès", "virement",
								JOptionPane.OK_CANCEL_OPTION);
					} else {
						JOptionPane.showMessageDialog(null, "virement non effectué, votre solde ne le permet pas",
								"virement", JOptionPane.OK_CANCEL_OPTION);

					}
				} catch (NumberFormatException event) {
					getThis().view.getPrincipal().getVirPanel().warn("montant invalide");
				}

			}
		});

		this.view.getPrincipal().getVirPanel().getCompteConnuDialog().addBtnValiderListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CompteConnuDialog dialog = getThis().view.getPrincipal().getVirPanel().getCompteConnuDialog();
				CompteConnu newCompte = new CompteConnu(Integer.parseInt(dialog.getRib()), dialog.getNom(),
						dialog.getPrenom());
				view.getPrincipal().getVirPanel().addCompteConnu(newCompte);
				dialog.getTxtInsertNom().setText("");
				dialog.getTxtInsertPrenom().setText("");
				dialog.getTxtInsertRib().setText("");
				dialog.setVisible(false);
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