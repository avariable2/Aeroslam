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
	private JLabel txtNumV,txtPassager;
	private JButton btn;
	@SuppressWarnings("rawtypes")
	private JComboBox listeVol;
	private ArrayList<VolCourrier> lesVol;
	private JComboBox<IndexLibelle> listePassager;
	private ArrayList<Passager> lesP;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VueAjouterVolPassager(){
		this.setLayout(new GridLayout(7,1));
		
		this.txtNumV = new JLabel("Choissiez votre vol : ");
		this.listeVol = new JComboBox();
		this.lesVol = Modele.voirVolCourrier();
		for(int i =0; i<Modele.getNbVolCourrier();i++){
			this.listeVol.addItem(lesVol.get(i).getNumVol());
		}
		this.lesP = Modele.voirPassager();
		this.txtPassager = new JLabel("Choisir votre passager a ajouter dans ce Vol :");
		this.listePassager = new JComboBox();
		for(int i=0; i<Modele.getNbPassager();i++){
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
			VolCourrier leVol = Modele.rechVolCourrier((int) this.listeVol.getSelectedItem());
			Passager leP = Modele.rechPassager(id);
			leVol.ajouterPassager(leP);
			leP.ajouterVol(leVol);
			if(!Modele.verifEstdejaSaisie("Vol","numvol",id) && Modele.ajouteVolPassager((int) this.listeVol.getSelectedItem(),id)){
				JOptionPane.showMessageDialog(null, "Votre Vol a bien été ajouté ! ", "Information", JOptionPane.INFORMATION_MESSAGE);
				this.revalidate();
			}else{
				JOptionPane.showMessageDialog(null, "Vous avez deja ajoutez ce passager a ce vol.",
						"Erreur", JOptionPane.ERROR_MESSAGE);
				this.revalidate();
			}
		}
	}
	
	
}