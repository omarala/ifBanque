package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CompteConnuDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnValider;
	private JTextField txtNom, txtInsertNom, txtPrenom, txtInsertPrenom, txtRib, txtInsertRib;

	/**
	 * Create the dialog.
	 */
	public CompteConnuDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3,1));
		
		JPanel panRib = new JPanel();
		txtRib = new JTextField("rib");
		txtRib.setEditable(false);
		txtInsertRib = new JTextField();
		txtInsertRib.setPreferredSize(new Dimension(100, 30));
		panRib.add(txtRib);
		panRib.add(txtInsertRib);
		
		JPanel panNom = new JPanel();
		txtNom = new JTextField("Nom");
		txtNom.setEditable(false);
		txtInsertNom = new JTextField();
		txtInsertNom.setPreferredSize(new Dimension(100, 30));
		panNom.add(txtNom);
		panNom.add(txtInsertNom);
		
		JPanel panPrenom = new JPanel();
		txtPrenom = new JTextField("Prenom");
		txtPrenom.setEditable(false);
		txtInsertPrenom = new JTextField();
		txtInsertPrenom.setPreferredSize(new Dimension(100, 30));
		panPrenom.add(txtPrenom);
		panPrenom.add(txtInsertPrenom);
		
		contentPanel.add(panRib);
		contentPanel.add(panNom);
		contentPanel.add(panPrenom);
		
		
		this.setVisible(false);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		btnValider = new JButton("Valider");
		getContentPane().add(btnValider, BorderLayout.SOUTH);
		
	}
	
	public void addBtnValiderListener(ActionListener a) {
		btnValider.addActionListener(a);
	}
	
	public String getRib() {
		return txtInsertRib.getText();
	}

	public String getNom() {
		return txtInsertNom.getText();
	}
	
	public String getPrenom() {
		return txtInsertPrenom.getText();
	}

	public JTextField getTxtInsertNom() {
		return txtInsertNom;
	}

	public void setTxtInsertNom(JTextField txtInsertNom) {
		this.txtInsertNom = txtInsertNom;
	}

	public JTextField getTxtInsertPrenom() {
		return txtInsertPrenom;
	}

	public void setTxtInsertPrenom(JTextField txtInsertPrenom) {
		this.txtInsertPrenom = txtInsertPrenom;
	}

	public JTextField getTxtInsertRib() {
		return txtInsertRib;
	}

	public void setTxtInsertRib(JTextField txtInsertRib) {
		this.txtInsertRib = txtInsertRib;
	}
}
