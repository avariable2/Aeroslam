import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class VueAjouterDestination extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel txt1,txt2,txt3;
	private JTextField txtf1,txtf2;
	private JButton btn;
	
	public VueAjouterDestination(){
		this.setLayout(new GridLayout(6,1));
		
		this.txt1 = new JLabel("Le nom de la Ville : ");
		this.txtf1 = new JTextField();
		this.txtf1.setPreferredSize(new Dimension(100,30));
		this.txt2 = new JLabel("Le nom du Pays : ");
		this.txtf2 = new JTextField();
		this.txtf2.setPreferredSize(new Dimension(100,30));
		this.btn = new JButton("Valider");
		this.btn.addActionListener(this);
		
		this.add(this.txt1);
		this.add(this.txtf1);
		this.add(this.txt2);
		this.add(this.txtf2);
		this.add(this.btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btn){
			if(!this.txtf2.getText().equals(null) && !this.txtf1.getText().equals(null) &&
					!Modele.verifEstdejaSaisie("destination", "ville_dest", this.txtf1.getText())){ // on verifie que la destination n'existe pas
				Modele.ajouteDestination(this.txtf1.getText(),this.txtf2.getText());
				JOptionPane.showMessageDialog(null, "Votre Destination a bien été ajouté ! ", "Information", JOptionPane.INFORMATION_MESSAGE);
				revalidate();
			}else{
				JOptionPane.showMessageDialog(null, "Veuillez saisir tout les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
				revalidate();
			}
		}
	}
	
	
}