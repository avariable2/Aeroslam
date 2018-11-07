import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VueConsultationDestination extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[Modele.getNbDestination()][2];
	private String[] title = { "Ville", "Pays" };
	
	public VueConsultationDestination(){
		for(int i =0; i<Modele.getNbDestination();i++){
			this.data[i][0]=Modele.voirDestination().get(i).getVille();
			this.data[i][1]=Modele.voirDestination().get(i).getPays();
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
