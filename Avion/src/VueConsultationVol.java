import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VueConsultationVol extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableau;
	private JScrollPane scrollPane;
	private Object[][] data = new Object[Modele.getNbVol()][5];
	private String[] title = { "Numero Vol", "Date départ", "Numero Avion", "Numero Destination", "Type" };
	
	public VueConsultationVol(){
		for(int i =0; i<Modele.getNbVol();i++){
			this.data[i][0]=Modele.voirVol().get(i).getNumVol();
			this.data[i][1]=Modele.voirVol().get(i).getDate().getDateFrancais();
			this.data[i][2]=Modele.voirVol().get(i).getNumAvion();
			this.data[i][3]=Modele.voirVol().get(i).getDestination();
			if((boolean) (this.data[i][4]=Modele.voirVol().get(i).getType()==0)){
				this.data[i][4]="Commerciaux";
			}else{
				this.data[i][4]="Courrier";
			}
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
