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
	private Object[][] data = new Object[nb][5];
	private String[] title = { "Numero Vol", "Date départ", "Numero Avion", "Numero Destination", "Passagers" };
	private JLabel txtNumV;
	private JComboBox listeVol;
	private ArrayList<VolCourrier> lesVol;
	private JButton btn;
	
	public VueConsultationVolAPassager(){
		/*ArrayList<VolCourrier> lesVol = Modele.voirVolCourrier();
		for(int i =0; i<Modele.getNbVol();i++){
			this.data[i][0]=lesVol.get(i).getNumVol();
			this.data[i][1]=lesVol.get(i).getDate().getDateFrancais();
			this.data[i][2]=lesVol.get(i).getNumAvion();
			this.data[i][3]=lesVol.get(i).getDestination();
			for(int j = 0;j<lesVol.get(i).getNbPassagerVC();i++){
				Passager lePassager = lesVol.get(i).voirLesPassagersDuVol().get(j);
				this.data[i][j+4]=lePassager.getNomP();
			}
		}
		this.tableau = new JTable(this.data, this.title);
		this.tableau.setRowHeight(30); // espacement des cellules
		this.tableau
				.setPreferredScrollableViewportSize(new Dimension(300, 300));
		this.scrollPane = new JScrollPane(this.tableau);*/
		
		//this.add(this.scrollPane);
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
			
		}
	}
	
}
