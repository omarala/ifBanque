package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Compte;
import model.CompteConnu;
import model.Courant;

public class VirementPanel extends JPanel {

	private JComboBox boxCompte;
	private JComboBox boxCompteConnu;
	private JTextField txtMontant;
	private double montant;
	private JLabel lblSolde;
	private JButton btnValider, btnNouveauCompte;
	private Compte compte;
	private CompteConnu compteConnu;
	private CompteConnuDialog compteConnuDialog;

	/**
	 * Create the panel.
	 */
	public VirementPanel(LinkedList<Courant> listCompte, LinkedList<CompteConnu> listConnu) {
		setLayout(new GridLayout(5,1));
		montant = 0.0;

		JPanel emptyPanel = new JPanel();
		emptyPanel.setPreferredSize(new Dimension(100,100));
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		Font font2 = new Font("SansSerif", Font.BOLD, 16);

		JPanel panCompte = new JPanel();
		JTextField txtCompte = new JTextField("votre compte : ");
		lblSolde = new JLabel();
		txtCompte.setEditable(false);
		txtCompte.setFont(font2);
		boxCompte = new JComboBox(listCompte.toArray());
		boxCompte.setPreferredSize(new Dimension(200, 40));
		panCompte.add(txtCompte);
		panCompte.add(boxCompte);
		panCompte.add(lblSolde);
		
		
		boxCompte.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					compte = (Compte)e.getItem();
					compte.majSolde();
					lblSolde.setText("solde :"+compte.getSolde()+"€");
				}
				
			}
		});
		JPanel panCompteConnu = new JPanel();
		JTextField txtCompteConnu = new JTextField("le compte destinataire: ");
		txtCompteConnu.setEditable(false);
		txtCompteConnu.setFont(font2);
		boxCompteConnu = new JComboBox(listConnu.toArray());
		boxCompteConnu.setPreferredSize(new Dimension(200, 40));
		panCompteConnu.add(txtCompteConnu);
		panCompteConnu.add(boxCompteConnu);
		panCompteConnu.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		boxCompteConnu.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					compteConnu = (CompteConnu)e.getItem();
				}
				
			}
		});
		
		JPanel panMontant = new JPanel();
		JTextField txtMessage = new JTextField("le montant en euros : ");
		txtMessage.setEditable(false);
		txtMessage.setFont(font2);
		txtMontant = new JTextField("");
		txtMontant.setPreferredSize(new Dimension(200, 40));
		panMontant.add(txtMessage);
		panMontant.add(txtMontant);

		JPanel panBouton = new JPanel();
		btnNouveauCompte = new JButton("Ajouter un compte");
		btnValider = new JButton("Valider");
		panBouton.add(btnNouveauCompte);
		panBouton.add(btnValider);
		
		compteConnuDialog = new CompteConnuDialog();

		btnNouveauCompte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				compteConnuDialog.setVisible(true);
				
			}
		});

		add(emptyPanel);
		add(panCompte, BorderLayout.CENTER);
		add(panCompteConnu, BorderLayout.AFTER_LAST_LINE);
		add(panMontant, BorderLayout.AFTER_LAST_LINE);
		add(panBouton);

	}

	public void warn(String message) {
		JOptionPane.showMessageDialog(null,message, "Error Massage",JOptionPane.ERROR_MESSAGE);
	}

	public String getMontant(){
		return txtMontant.getText();
	}

	public JButton getBtnValider(){
		return btnValider;
	}
	
	public Compte getDebiteur() {
		return compte;
	}

	public CompteConnu getCompteSelectionne() {
		return compteConnu;
	}
	
	public void addCompteConnu(CompteConnu newCompte) {
		boxCompteConnu.addItem(newCompte);
	}

	public CompteConnuDialog getCompteConnuDialog() {
		return compteConnuDialog;
	}
	
	public void majComboCompte(LinkedList<Courant> listCompte) {
		for(Courant cout:listCompte) {
			boxCompte.addItem(cout);
		}
		this.revalidate();
	}
	
	public void majComboCompteConnu(LinkedList<CompteConnu> listCompteConnu) {
		for(CompteConnu cout:listCompteConnu) {
			boxCompte.addItem(cout);
		}
		this.revalidate();
	}
}
