package vue;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Compte;
import model.Model;
import model.Operation;

public class ComptePanel extends JPanel {
	private JTable tabHistorique;
	private JComboBox boxCategorie;
	private String categorie;
	private int selectedOperation;
	private boolean boolChangedCategorie;

	/**
	 * Create the panel.
	 */
	public ComptePanel(Compte compte) {

		boolChangedCategorie = false;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lblSoldeActuel = new JLabel("     Solde actuel : " + compte.getSolde() + "€");

		
		Object[][] vectOp = new Object[compte.getHistorique().size()][4];
		int i = 0;
		for(Operation op : compte.getHistorique()) {
			vectOp[i] = op.getRowOperation();
			i++;
		}
		System.out.println(Operation.getRowName());
		tabHistorique = new JTable(vectOp, Operation.getRowName());
		tabHistorique.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int i = 0;
					selectedOperation = tabHistorique.getSelectedRow();

					boolChangedCategorie = true;
					getThis().revalidate();
				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(tabHistorique);
		tabHistorique.setSize(500,300);
		JPanel panCategorie = new JPanel();
		JTextField txtCategorie = new JTextField("Choisir une categorie : ");
		txtCategorie.setEditable(false);
		panCategorie.add(txtCategorie);
		boxCategorie = new JComboBox(Model.listCategorie.toArray());
		panCategorie.add(boxCategorie);
		boxCategorie.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					if(boolChangedCategorie == true) {
					categorie = (String)e.getItem();
					tabHistorique.setValueAt(categorie, selectedOperation, 1);
					boolChangedCategorie = false;
					compte.getHistorique().get(selectedOperation).setCategorie(categorie);
					}
				}
				
			}
		});;
		add(lblSoldeActuel);
		add(scrollPane);
		add(panCategorie);

	}
	
	public String getCategorie() {
		return categorie;
	}
	
	public int getSelectedOperation() {
		return selectedOperation;
	}
	
	public boolean getBoolChangedCategorie() {
		return boolChangedCategorie;
	}
	
	public void resetBool() {
		boolChangedCategorie = false;
	}
	
	public Object[][] linkedListToArray(Compte compte){
		Object[][] vectOp = new Object[compte.getHistorique().size()][4];
		int i = 0;
		for(Operation op : compte.getHistorique()) {
			vectOp[i] = op.getRowOperation();
			i++;
		}
		return vectOp;
	}
	
	public ComptePanel getThis() {
		return this;
	}
}
