package vue;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import model.Livret;

public class LivretPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LivretPanel(Livret livret) {
		setLayout(new GridLayout(3, 1));
		JLabel lblSolde = new JLabel("Le solde déposée est de : " +livret.getSoldeInitial() + "€");
		JLabel lblTaux = new JLabel("Le taux d'intérêt est de :" + livret.getTaux() * 100 + "%");
		JLabel lblEcheance = new JLabel("la prochaine mensualité est de " + livret.prochainInteret() + "€.");

		add(lblSolde);
		add(lblTaux);
		add(lblEcheance);

	}

}
