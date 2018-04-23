package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vue {

	ConnectionPage connect;
	Principal principal;
	
	public Vue(){
		//connect = new ConnectionPage();
		principal = new Principal("ifBanque");
//		principal.addBoutonVosCompteListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("toto");
//			}
//		});
		principal.setVisible(true);
	}

	public Principal getPrincipal() {
		return principal;
	}
}
