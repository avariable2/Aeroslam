import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class VueAjouterPassager extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel txtNom,txtPrenom,txt3,txtVille;
	private JTextField txtf1,txtf2;
	private JButton btn;
	private JTextField txtf3;
	
	public VueAjouterPassager(){
		this.setLayout(new GridLayout(7,1));
		
		this.txtNom = new JLabel("Nom du Passager : ");
		this.txtf1 = new JTextField();
		this.txtf1.setPreferredSize(new Dimension(100,30));
		this.txtPrenom = new JLabel("Prenom du Passager : ");
		this.txtf2 = new JTextField();
		this.txtf2.setPreferredSize(new Dimension(100,30));
		this.txtVille = new JLabel("Ville du Passager : ");
		this.txtf3 = new JTextField();
		this.txtf3.setPreferredSize(new Dimension(100,30));
		this.btn = new JButton("Valider");
		this.btn.addActionListener(this);
		
		this.add(this.txtNom);
		this.add(this.txtf1);
		this.add(this.txtPrenom);
		this.add(this.txtf2);
		this.add(this.txtVille);
		this.add(this.txtf3);
		this.add(this.btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btn){
			if(!this.txtf3.getText().equals(null) && !this.txtf2.getText().equals(null) && !this.txtf1.getText().equals(null)){
				Modele.ajoutePassager(this.txtf1.getText(),this.txtf2.getText(),this.txtf2.getText());
				this.txt3 = new JLabel("Votre Passager a bien été ajouter a la base de donnee.");
				this.add(this.txt3);
				revalidate();
			}else{
				this.txt3 = new JLabel("Veuillez saisir tout les champs.");
				this.add(this.txt3);
				revalidate();
			}
		}
	}
	
	
}