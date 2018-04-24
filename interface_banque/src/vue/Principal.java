package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Compte;
import model.CompteConnu;
import model.Courant;
import model.Credit;
import model.Livret;

public class Principal extends JFrame {

	JComboBox boxCompte;
	JButton btnVosComptes;
	JButton btnFaireUnVirement;
	JButton btnVosLivrets;
	JButton btnVosCredits;
	JPanel centerPane;
	VirementPanel virPanel;

	/**
	 * Create the panel.
	 */
	public Principal(String title) {

		this.setTitle(title);
		this.setSize(new Dimension(800, 600));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		GridLayout grid = new GridLayout(6,0);
		panel.setLayout(grid);

		btnVosComptes = new JButton("Vos comptes");
		btnVosComptes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnVosComptes, 4, 0);

		btnFaireUnVirement = new JButton("Faire un virement");
		panel.add(btnFaireUnVirement, 3, 0);

		btnVosLivrets = new JButton("Vos livrets");
		panel.add(btnVosLivrets, 2, 0);

		btnVosCredits = new JButton("Vos crédits");
		panel.add(btnVosCredits, 1, 0);

		centerPane = new JPanel(new FlowLayout());

		JLabel lblGestionnaireDeComptes = new JLabel("Gestionnaire de comptes IfBank");
		lblGestionnaireDeComptes.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGestionnaireDeComptes.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGestionnaireDeComptes, BorderLayout.NORTH);
		getContentPane().add(centerPane, BorderLayout.CENTER);

		virPanel = new VirementPanel(new LinkedList<Courant>(), new LinkedList<CompteConnu>());
	}

	public Principal getThis() {
		return this;
	}
	
	public void afficheListCompte(LinkedList<Compte> listCompte) {
		
		boxCompte = new JComboBox<>(listCompte.toArray());
		majCenterPane();
		boxCompte.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					centerPane.removeAll();
					centerPane.add(boxCompte);
					Compte compte = (Compte) boxCompte.getSelectedItem();
					ComptePanel apercu = new ComptePanel(compte);
					centerPane.add(apercu, BorderLayout.SOUTH);
					getThis().revalidate();
				}
			}
		});
		
		majCenterPane();
		
	}

	public void afficheListCredit(LinkedList<Credit> listCredit) {
		boxCompte = new JComboBox<>(listCredit.toArray());
		majCenterPane();
		if(listCredit.size() == 1){
			centerPane.removeAll();
			centerPane.add(boxCompte);
			Credit credit = (Credit) boxCompte.getSelectedItem();
			CreditPanel apercu = new CreditPanel(credit);
			centerPane.add(apercu, BorderLayout.SOUTH);
			getThis().revalidate();

		}else{
			boxCompte.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					centerPane.removeAll();
					centerPane.add(boxCompte);
					Credit credit = (Credit) boxCompte.getSelectedItem();
					CreditPanel apercu = new CreditPanel(credit);
					centerPane.add(apercu, BorderLayout.SOUTH);
					getThis().revalidate();
				}
			});
			
		}
		

	}

	public void afficheListLivret(LinkedList<Livret> listLivret) {
		boxCompte = new JComboBox<>(listLivret.toArray());
		majCenterPane();
		if(listLivret.size() == 1){
			centerPane.removeAll();
			centerPane.add(boxCompte, BorderLayout.BEFORE_FIRST_LINE);
			Livret livret = (Livret) boxCompte.getSelectedItem();
			LivretPanel apercu = new LivretPanel(livret);
			centerPane.add(apercu, BorderLayout.SOUTH);
			getThis().revalidate();

		}else{
		boxCompte.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				centerPane.removeAll();
				centerPane.add(boxCompte,BorderLayout.BEFORE_FIRST_LINE);
				Livret livret = (Livret) boxCompte.getSelectedItem();
				LivretPanel apercu = new LivretPanel(livret);
				centerPane.add(apercu, BorderLayout.SOUTH);
				getThis().revalidate();
			}
		});
	}


	}

	public void affichageVirement(LinkedList<Courant> listCompte, LinkedList<CompteConnu> listConnu){
		System.out.println(listCompte);
		virPanel.majComboCompteConnu(listConnu);
		virPanel.majComboCompte(listCompte);
		centerPane.removeAll();
		centerPane.add(virPanel);
		getContentPane().add(centerPane, BorderLayout.CENTER);
		this.revalidate();
		getThis().repaint();
	}

	public void majCenterPane() {
		boxCompte.setSize(new Dimension(100, 100));
		centerPane.removeAll();
		centerPane.revalidate();
		centerPane.repaint();
		centerPane.add(boxCompte, BorderLayout.BEFORE_FIRST_LINE);
		this.getContentPane().add(centerPane, BorderLayout.CENTER);
		this.revalidate();
	}
	
	
	public void addBoutonVosCompteListener(ActionListener a) {
		btnVosComptes.addActionListener(a);
	}

	public void addBoutonLivretListener(ActionListener a) {
		btnVosLivrets.addActionListener(a);
	}

	public void addBoutonVosCreditListener(ActionListener a) {
		btnVosCredits.addActionListener(a);
	}

	public void addBoutonVirementListener(ActionListener a) {
		btnFaireUnVirement.addActionListener(a);
	}

	public void addBoutonValiderVirementListener(ActionListener a){
		virPanel.getBtnValider().addActionListener(a);
	}

	public JComboBox getBoxCompte() {
		return boxCompte;
	}

	public JButton getBtnVosCompte() {
		return btnVosComptes;
	}

	public JButton getBtnFaireUnVirement() {
		return btnFaireUnVirement;
	}

	public JButton getBtnVosLivrets() {
		return btnVosLivrets;
	}

	public JButton getBtnVosCredits() {
		return btnVosCredits;
	}

	public VirementPanel getVirPanel(){
		return virPanel;
	}


}
