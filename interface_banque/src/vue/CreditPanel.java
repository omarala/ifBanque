package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import model.Credit;

public class CreditPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CreditPanel(Credit credit) {
		setLayout(new FlowLayout());
		JLabel lblMontantDate = new JLabel("vous avez contracté un crédit de "+ credit.getMontantEmprunte()+"€ le " + credit.getDateDebut()+"pour une durée de "+credit.getDuree()+"ans.");
		JLabel lblTaux = new JLabel("le taux est de :"+ credit.getTaux()*100+ "%");
		JLabel lblMensualite = new JLabel("la prochaine mensualité est de "+ credit.getMensualite()+"€.");

		add(lblMontantDate);
		add(lblTaux);
		add(lblMensualite);
	}

}
