package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import model.Operation;
import model.Compte;

public class ComptePanel extends JPanel {
	private JTable historique;

	/**
	 * Create the panel.
	 */
	public ComptePanel(Compte compte) {

		
		setLayout(new BorderLayout());
		JLabel lblSoldeActuel = new JLabel("     Solde actuel : " + compte.getSolde() + "€");

		
		Object[][] vectOp = new Object[compte.getHistorique().size()][4];
		int i = 0;
		for(Operation op : compte.getHistorique()) {
			vectOp[i] = op.getRowOperation();
			i++;
		}
		System.out.println(Operation.getRowName());
		JTable tabHistorique = new JTable(vectOp, Operation.getRowName());
		JScrollPane scrollPane = new JScrollPane(tabHistorique);
		tabHistorique.setSize(500,300);
		add(lblSoldeActuel, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.SOUTH);

	}
}
