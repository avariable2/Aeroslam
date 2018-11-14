import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class VueConsultationVolAPassager extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private int nb;
	private Object[][] data = new Object[nb][4];
	private String[] title = { "Numero Passager", "Nom", "Prenom", "Ville" };
	private JLabel txtNumV;
	@SuppressWarnings("rawtypes")
	private JComboBox listeVol;
	private ArrayList<VolCourrier> lesVol;
	private JButton btn;
	
	public VueConsultationVolAPassager(){
		this.setLayout(new GridLayout(7,1));
		
		this.txtNumV = new JLabel("Choissiez votre vol : ");
		this.listeVol = new JComboBox();
		this.lesVol = Modele.voirVolCourrier();
		for(int i =0; i<Modele.getNbVolCourrier();i++){
			this.listeVol.addItem(lesVol.get(i).getNumVol());
		}
		this.btn = new JButton("Valider");
		this.btn.addActionListener(this);
		
		this.add(this.txtNumV);
		this.add(this.listeVol);
		this.add(this.btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btn){
			this.removeAll();
			this.lesVol = Modele.voirVolCourrier();
			this.nb = lesVol.size();
			VolCourrier leVol = lesVol.get((int) this.listeVol.getSelectedIndex());
			for(int i =0; i<leVol.voirLesPassagersDuVol().size();i++){
				this.data[i][0] = leVol.voirLesPassagersDuVol().get(i).getNumP();
				this.data[i][1] = leVol.voirLesPassagersDuVol().get(i).getNomP();
				this.data[i][2] = leVol.voirLesPassagersDuVol().get(i).getPrenomP();
				this.data[i][3] = leVol.voirLesPassagersDuVol().get(i).getVille();
			}
			this.tableau = new JTable(this.data, this.title);
			this.tableau.setRowHeight(30); // espacement des cellules
			this.tableau
					.setPreferredScrollableViewportSize(new Dimension(300, 300));
			this.scrollPane = new JScrollPane(this.tableau);
			this.add(new JLabel("Les passagers du Vol en direction : "+leVol.getDestination()));
			this.add(this.scrollPane);
			this.revalidate();
		}
	}
	
}
