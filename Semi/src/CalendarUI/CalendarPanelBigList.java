package CalendarUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class CalendarPanelBigList {
	JPanel big_panel, small_panel, small_panel2;
	JLabel [] day = new JLabel[4];
	
	
	public CalendarPanelBigList(int i, int what_day, int llll) {
		big_panel = new JPanel();
		big_panel.setLayout(new GridLayout(4,1,0,0));
		big_panel.setBackground(Color.white);
		big_panel.setBorder(new LineBorder(Color.BLACK));
		small_panel = new JPanel();
		//small_panel2 = new JPanel();
		big_panel.add(small_panel);
		//big_panel.add(small_panel2);
		//small_panel2.setBackground(Color.BLUE);
		day[0] = new JLabel(String.valueOf(i), JLabel.CENTER);
		day[0].setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
		//System.out.println(i);
		
		if(what_day==7 || what_day==1) {
			if(what_day==1) day[0].setForeground(new Color(233,233,233));
			else day[0].setForeground(new Color(233,233,233));
		}
		else 
			day[0].setForeground(new Color(222,222,222));
	
			
		small_panel.add(day[0]);
		small_panel.setBackground(Color.white);
		//small_panel.setBorder(new LineBorder(Color.RED));
	}
	
	public CalendarPanelBigList(int i,int what_day) {
		big_panel = new JPanel();
		big_panel.setLayout(new GridLayout(4,1,0,0));
		

		big_panel.setBackground(Color.white);
		big_panel.setBorder(new LineBorder(Color.BLACK));
		
		small_panel = new JPanel();
		//small_panel2 = new JPanel();
		big_panel.add(small_panel);
		//big_panel.add(small_panel2);
		//small_panel2.setBackground(Color.BLUE);
		settingLabel(i, what_day);
		
		
		small_panel.setBackground(Color.white);
		//small_panel.setBorder(new LineBorder(Color.RED));
	}
	private void settingLabel(int i, int what_day) {
		day[0] = new JLabel(String.valueOf(i), JLabel.CENTER);
		day[0].setFont(new Font("³ª´®°íµñ", Font.BOLD, 20));
		if(what_day==7 || what_day==1) {
			if(what_day==1) day[0].setForeground(Color.red);
			else day[0].setForeground(Color.blue);
		}
		else 
			day[0].setForeground(Color.black);
		small_panel.add(day[0]);
		
	}
	
	public void setSmall_panel(JPanel small_panel) {
		this.small_panel = small_panel;
	}
	public JPanel getSmall_panel() {
		return small_panel;
	}
	public JPanel getBig_panel() {
		return big_panel;
	}
}
