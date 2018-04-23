package vue;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import javax.swing.JTextField;
import model.CompteConnu;
import model.Courant;

public class VirementPanel extends JPanel {

	JComboBox boxCompte;
	JComboBox boxCompteConnu;
	JTextField txtMontant;
	/**
	 * Create the panel.
	 */
	public VirementPanel(LinkedList<Courant> listCompte, LinkedList<CompteConnu> listConnu) {
		setLayout(new FlowLayout());

		boxCompte = new JComboBox(listCompte.toArray());
		boxCompte.setSize(new Dimension(200, 100));
		
		boxCompteConnu = new JComboBox(listConnu.toArray());
		boxCompteConnu.setSize(new Dimension(200, 100));

		txtMontant = new JTextField("le montant en euros");
		txtMontant.setSize(new Dimension(200, 100))

		add(boxCompte);
		add(boxCompteConnu);
		add(txtMontant);


	}

}
