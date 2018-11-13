import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VueConsultationPassager extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[Modele.getNbPassager()][4];
	private String[] title = { "Numero", "Nom", "Prenom", "Ville" };
	
	public VueConsultationPassager(){
		for(int i =0; i<Modele.getNbPassager();i++){
			this.data[i][0]=Modele.voirPassager().get(i).getNumP();
			this.data[i][1]=Modele.voirPassager().get(i).getNomP();
			this.data[i][2]=Modele.voirPassager().get(i).getPrenomP();
			this.data[i][3]=Modele.voirPassager().get(i).getVille();
		}
		this.tableau = new JTable(this.data, this.title);
		this.tableau.setRowHeight(30); // espacement des cellules
		this.tableau
				.setPreferredScrollableViewportSize(new Dimension(300, 300));
		this.scrollPane = new JScrollPane(this.tableau);
		
		this.add(this.scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
