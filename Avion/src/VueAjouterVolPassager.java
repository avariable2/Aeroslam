import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class VueAjouterVolPassager extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel txtNumV,txtPassager,txt3;
	private JTextField txtf1,txtf2;
	private JButton btn;
	private JTextField txtf3;
	private JComboBox<Integer> listeVol;
	private ArrayList<VolCourrier> lesVol;
	private JComboBox<IndexLibelle> listePassager;
	private ArrayList<Passager> lesP;
	
	public VueAjouterVolPassager(){
		this.setLayout(new GridLayout(7,1));
		
		this.txtNumV = new JLabel("Choissiez votre vol : ");
		this.listeVol = new JComboBox<Integer>();
		this.lesVol = Modele.voirVolCourrier();
		for(int i =0; i<Modele.getNbVolCourrier();i++){
			this.listeVol.addItem(lesVol.get(i).getNumVol());
		}
		this.txtPassager = new JLabel("Choisir votre passager a ajouter dans ce Vol :");
		this.listePassager = new JComboBox<IndexLibelle>();
		this.lesP = Modele.voirPassager();
		for(int i =0; i<Modele.getNbVolCourrier();i++){
			this.listePassager.addItem(new IndexLibelle(lesP.get(i).getNumP(),lesP.get(i).getNomP()));
		}
		this.btn = new JButton("Valider");
		this.btn.addActionListener(this);
		
		this.add(this.txtNumV);
		this.add(this.listeVol);
		this.add(this.txtPassager);
		this.add(this.listePassager);
		this.add(this.btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btn){
			int id = ((IndexLibelle) this.listePassager.getSelectedItem()).getNumAvion();
			if(!Modele.verifEstdejaSaisie("Vol","numvol",id) && Modele.ajouteVolPassager((int) listeVol.getSelectedItem(),id)){
				this.txt3 = new JLabel("Vous avez bien ajouter ce passager dans ce vol.");
				this.add(this.txt3);
				this.revalidate();
			}else{
				this.txt3 = new JLabel("Vous avez deja ajoutez ce passager a ce vol.");
				this.add(this.txt3);
				this.revalidate();
			}
		}
	}
	
	
}