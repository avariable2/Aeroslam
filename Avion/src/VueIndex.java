import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VueIndex extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel monPanel;
	@SuppressWarnings("unused")
	private JLabel txt1,txt2;
	private JMenuBar barre;
	private JMenu menuC,menuA,menuD;
	private JMenuItem itemD,itemAaj,itemAc,itemDac,itemDaj;

	
	public VueIndex(){
		this.setTitle("AeroSLAM");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setContentPane(new VueConnexion());
		if(VueConnexion.rep != 0){
			this.vueAcceuil();
		}
		this.setVisible(true);
	}
	public void vueAcceuil(){
		this.getContentPane().removeAll();
		this.monPanel = new JPanel();
		this.txt1 = new JLabel("Bienvenue");
		this.menu();
		
		this.monPanel.add(this.txt1);
		this.getContentPane().add(this.monPanel);
		this.getContentPane().revalidate();
	}
	
	public void menu(){ // genere le contenue du menu
		this.barre = new JMenuBar();
		
		this.menuC = new JMenu("Compte");
		this.itemD = new JMenuItem("Déconnexion");
		this.itemD.addActionListener(new Deconnection());
		
		this.menuA = new JMenu("Avion");
		this.itemAaj = new JMenuItem("Ajouter Avion");
		this.itemAaj.addActionListener(new AjoutAvion());
		this.itemAc = new JMenuItem("Consulter Avion");
		this.itemAc.addActionListener(new ConsultationAvion());
		
		this.menuD = new JMenu("Destination");
		this.itemDaj = new JMenuItem("Ajouter Destination");
		this.itemDaj.addActionListener(new AjoutDestination());
		this.itemDac = new JMenuItem("Consulter Destination");
		this.itemDac.addActionListener(new ConsultationDestination());
		
		this.menuA.add(this.itemAaj);
		this.menuA.add(this.itemAc);
		this.menuC.add(this.itemD);
		this.menuD.add(this.itemDaj);
		this.menuD.add(this.itemDac);
		this.barre.add(this.menuC);
		this.barre.add(this.menuA);
		this.barre.add(this.menuD);
		this.setJMenuBar(this.barre);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.itemD){
			this.getContentPane().removeAll();
			this.setContentPane(new VueConnexion());
			this.getContentPane().revalidate();
		}
		
		
	}
	class Deconnection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setContentPane(new VueConnexion());
			getContentPane().revalidate();
		}
		
	}
	class AjoutAvion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			getContentPane().removeAll();
			getContentPane().add(new VueAjouter());
			menu();
			revalidate();
		}
		
	}
	class ConsultationAvion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getContentPane().removeAll();
			getContentPane().add(new VueConsultationAvion());
			menu();
			revalidate();
		}
		
	}
	class ConsultationDestination implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getContentPane().removeAll();
			getContentPane().add(new VueConsultationDestination());
			menu();
			revalidate();
		}
		
	}
	class AjoutDestination implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getContentPane().removeAll();
			getContentPane().add(new VueAjouterDestination());
			menu();
			revalidate();
		}
		
	}
}
