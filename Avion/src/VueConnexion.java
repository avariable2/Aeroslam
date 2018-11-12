import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VueConnexion extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel monPanel;
	private JLabel txt1,txt2,txtE;
	private JTextField txtf1,txtf2;
	private JButton btn1;
	public static int rep;
	
	public VueConnexion(){
		this.setLayout(new GridLayout(6,1));
		
		this.txt1 = new JLabel("Login : ");
		this.txtf1 = new JTextField();
		this.txtf1.setPreferredSize(new Dimension(100,30));
		this.txt2 = new JLabel("Mot de passe : ");
		this.txtf2 = new JTextField();
		this.txtf2.setPreferredSize(new Dimension(100,30));
		
		this.btn1 = new JButton("Valider");
		this.btn1.addActionListener(this);
		
		this.monPanel.add(this.txt1);
		this.monPanel.add(this.txtf1);
		this.monPanel.add(this.txt2);
		this.monPanel.add(this.txtf2);
		this.monPanel.add(this.btn1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btn1){
			rep = Modele.coBdd(this.txtf1.getText(), this.txtf2.getText());
			System.out.println(rep);
			if(rep == 1){
				
			}else{
				if(this.txtE == null){
					this.txtE = new JLabel("Login/ Mdp non valide ! ");
					this.monPanel.add(this.txtE);
					this.revalidate();
				}
			}
		}
	}
}
