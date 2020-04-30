package CalendarUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.color.ColorSpace;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventPanel {
	JPanel event_panel;
	JLabel event_label;
	String start_date, end_date;

	public EventPanel(String event) {
		if (!(event.equals("")) || !(event == null)) {
			event_panel = new JPanel();
			String[] eventArr = event.split("/");
			String[] color_str;
			int[] color;
			String title;
			for (int i = 0; i < eventArr.length; i++) {
				eventArr[i].trim();
			}
			title = eventArr[0];
			start_date = eventArr[1].trim();
			end_date = eventArr[2].trim();
		
			if(!(eventArr[3].equals("")) || !(eventArr[3]==null)) {
				color_str = eventArr[3].split(",");
				color = new int[color_str.length];

				for (int i = 0; i < color_str.length; i++) {
					color[i] = Integer.parseInt(color_str[i].trim());
				}
				
				
			}
			else {
				color = new int[3];
				color[0] = 172;
				color[1] = 219;
				color[1] = 218;
			}
			// System.out.println(color[0] + " " + color[1] + " " + color[2]);
			event_label = new JLabel(title, JLabel.CENTER);
			event_panel.setBackground(new Color(color[0], color[1], color[2]));
			// event_panel.setBackground(new Color(color[0], color[1], color[2]));
			event_label.setForeground(Color.white);
			event_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
			// 제목길이 4~5자 제한
			event_panel.add(event_label);
		}
	}

	public EventPanel(String event, boolean nouse) {
		if (!(event.equals("")) || !(event == null)) {
			event_panel = new JPanel();
			String[] eventArr = event.split("/");
			String[] color_str;
			int[] color;
			String title;
			for (int i = 0; i < eventArr.length; i++) {
				eventArr[i].trim();
			}
			title = null;
			start_date = eventArr[1].trim();
			end_date = eventArr[2].trim();
			color_str = eventArr[3].split(",");
			color = new int[color_str.length];

			for (int i = 0; i < color_str.length; i++) {
				color[i] = Integer.parseInt(color_str[i].trim());
			}
			// System.out.println(color[0] + " " + color[1] + " " + color[2]);
			event_label = new JLabel(title, JLabel.CENTER);

			event_panel.setBackground(new Color(color[0], color[1], color[2]));
			// event_panel.setBackground(new Color(color[0], color[1], color[2]));
			event_label.setForeground(Color.white);
			event_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
			// 제목길이 4~5자 제한
			event_panel.add(event_label);
		}
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public JPanel getEvent_panel() {
		return event_panel;
	}

	public void setEvent_panel(JPanel event_panel) {
		this.event_panel = event_panel;
	}

	public JLabel getEvent_label() {
		return event_label;
	}

	public void setEvent_label(JLabel event_label) {
		this.event_label = event_label;
	}
}
