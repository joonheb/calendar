package CalendarUI;

import javax.swing.JPanel;

public class EventStruct {
	int year, month;
	JPanel[] panel;
	public EventStruct(int year, int month, JPanel[] panel) {
		this.year = year;
		this.month = month;
		this.panel = panel;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public JPanel[] getPanel() {
		return panel;
	}
	public void setPanel(JPanel[] panel) {
		this.panel = panel;
	}
}
