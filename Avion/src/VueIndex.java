import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VueIndex extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int rep;
	private JPanel monPanel;
	private JLabel txt1,txt2;
	private JMenuBar barre;
	private JMenu menuC,menuA,menuD;
	private JMenuItem itemD,itemAaj,itemAc,itemDac,itemDaj;
	private JTextField txtf1;
	private JTextField txtf2;
	private JLabel txtE;
	private JButton btn1;
	private JMenu menuV;
	private JMenuItem itemVaj;

	
	public VueIndex(){
		// Page de connexion
		this.setTitle("AeroSLAM");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(new GridLayout(6,1));
		this.txt1 = new JLabel("Login : ");
		this.txtf1 = new JTextField();
		this.txtf1.setPreferredSize(new Dimension(100,30));
		this.txt2 = new JLabel("Mot de passe : ");
		this.txtf2 = new JTextField();
		this.txtf2.setPreferredSize(new Dimension(100,30));
		
		this.btn1 = new JButton("Valider");
		this.btn1.addActionListener(this);
		
		this.add(this.txt1);
		this.add(this.txtf1);
		this.add(this.txt2);
		this.add(this.txtf2);
		this.add(this.btn1);
		this.setVisible(true);
	}
	public void vueAcceuil(){
		// Page d'accueil
		this.getContentPane().removeAll();
		this.monPanel = new JPanel();
		this.txt1 = new JLabel("Bienvenue");
		this.menu();
		
		this.monPanel.add(this.txt1);
		this.getContentPane().add(this.monPanel);
		this.getContentPane().revalidate();
	}
	
	public void menu(){ 
		// genere le contenue du menu
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
		
		this.menuV = new JMenu("Vol");
		this.itemVaj = new JMenuItem("Ajouter Vol");
		this.itemVaj.addActionListener(new AjoutVol());
		
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
			// Si on clique sur la barre compte et le bouton deconnexion sa nous deconnecte 
			this.getContentPane().removeAll();
			this.dispose();
			VueIndex.rep =0;
			new VueIndex();
		}
		if(e.getSource() == this.btn1){
			rep = Modele.coBdd(txtf1.getText(), txtf2.getText());
			System.out.println(rep);
			if(rep == 1){
				this.vueAcceuil();
				this.menu();
				this.revalidate();
			}else{
				if(txtE == null){
					txtE = new JLabel("Login/ Mdp non valide ! ");
					this.add(txtE);
					revalidate();
				}
			}
		}
		
		
	}
	class Deconnection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			getContentPane().removeAll();
			dispose();
			VueIndex.rep =0;
			new VueIndex();
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
	class Connexion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getContentPane().removeAll();
			getContentPane().add(new VueAjouterDestination());
			menu();
			revalidate();
		}
		
	}
	class AjoutVol implements ActionListener{

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
