import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VueConsultationAvion extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[Modele.getNbAvion()][3];
	private String[] title = { "Numero Avion", "Nom" ,"Nombre de place" };
	
	public VueConsultationAvion(){
		for(int i =0; i<Modele.getNbAvion();i++){
			this.data[i][0]=Modele.voirAvion().get(i).getNumAvion();
			this.data[i][1]=Modele.voirAvion().get(i).getNomAvion();
			this.data[i][2]=Modele.voirAvion().get(i).getNbPlaces();
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
