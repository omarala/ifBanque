package vue;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.LinkedList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Operation;

public class ConnectionPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdentifiant;
	private JPasswordField txtPassword;
	public Principal princi;


	/**
	 * Create the frame.
	 */
	public ConnectionPage() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				LinkedList<Operation> list = new LinkedList<Operation>();
//				list.add(new Operation(1414, "tettea", new Date(1423, 2, 3), 1231.4));
				princi = new Principal("IfBank");
				princi.setVisible(true);
				getThis().dispose();
			}
		});
		
		JTextPane txtpnBonjourSurVotre = new JTextPane();
		txtpnBonjourSurVotre.setText("Bonjour sur votre application IfBank. Identifiez-vous pour accéder à votre gestionnaire de compte.");
		
		txtIdentifiant = new JTextField();
		txtIdentifiant.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setEchoChar('*');
		
		JLabel lblIdentifiant = new JLabel("Identifiant:");
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(txtpnBonjourSurVotre, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(206)
							.addComponent(btnConnect, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(47, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(137, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIdentifiant)
							.addGap(65)
							.addComponent(txtIdentifiant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMotDePasse)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(159))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(txtpnBonjourSurVotre, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdentifiant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdentifiant))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMotDePasse))
					.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
					.addComponent(btnConnect)
					.addGap(31))
		);
		contentPane.setLayout(gl_contentPane);
	}
	

	ConnectionPage getThis() {
		return this;
	}
}
