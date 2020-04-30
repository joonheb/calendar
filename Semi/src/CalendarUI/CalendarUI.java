package CalendarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

import Semi1.MemberDTO;
import Semi2.*;
import Semi3.*;

public class CalendarUI extends JFrame implements ActionListener, MouseListener, Runnable {
	Toolkit t = Toolkit.getDefaultToolkit();
	Calendar calendar = Calendar.getInstance();
	Calendar previous_calendar = Calendar.getInstance();
	Calendar next_calendar = Calendar.getInstance();
	Thread thread;
	List<Thread> thread_list = new ArrayList<Thread>();

	Color white_color = Color.white;
	boolean use_func = false;
	int frame_width = (int) t.getScreenSize().getWidth();
	int frame_height = (int) t.getScreenSize().getHeight();
	int width, height, first;
	int year = calendar.get(Calendar.YEAR), month = calendar.get(Calendar.MONTH) + 1;
	String[] day_str = { "일", "월", "화", "수", "목", "금", "토" };
	String[] dayEng_str = { "Sunday", "Monday", "Tuesday", "Wednsday", "Thursday", "Friday", "Saturday" };
	Container container;

	JPanel calendar_panel = new JPanel();
	JPanel north_panel = new JPanel();
	JPanel north_child = new JPanel();
	JPanel center_title = new JPanel();
	JPanel center_main = new JPanel();
	JPanel center_bind = new JPanel();
	JPanel center_panel = new JPanel();

	JPanel menu_panel = new JPanel();
	JPanel[] menuButton_panel = new JPanel[3];
	JPanel seoul_panel = new Seoul().getPanel();
	JButton[] menu_button = new JButton[3];
	UI ui;
	String[] menu = { "C:\\Users\\CJB\\Desktop\\세미\\image\\calendarview\\woman.png",
			"C:\\Users\\CJB\\Desktop\\세미\\image\\calendarview\\man.png",
			"C:\\Users\\CJB\\Desktop\\세미\\image\\calendarview\\calendar.png",
			"C:\\Users\\CJB\\Desktop\\세미\\image\\calendarview\\map.png" };

	String[] buttonImg_str = { "C:\\Users\\CJB\\Desktop\\세미\\image\\calendarview\\left.png",
			"C:\\Users\\CJB\\Desktop\\세미\\image\\calendarview\\right.png" };
	JPanel func_panel, back_panel, check_panel;

	JButton left_button, right_button;
	JLabel north_label;

	JPanel[] big_panel;
	List<EventStruct> eventlist = new ArrayList<EventStruct>();

	MemberDTO memberDTO;
	JLabel member_name;
	
	public CalendarUI(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
		setFrame();
		setContainer();
		setNorthPanel();
		setCenterPanel();
		func();

	}

	private void setFrame() {
		width = frame_width / 10;
		height = frame_height / 10;
		setTitle("SEMI PROJECT SHARED CALENDER");
		setBounds(192, 108, 1536, 864);
		setVisible(true);
		setResizable(false);
	}

	private void setContainer() {
		container = getContentPane();
		// container.setBackground(new Color(115,139,197));
		container.setBackground(white_color);
		container.setLayout(null);
		container.add(menu_panel);

		// 왼쪽 패널 : 메뉴패널
		menu_panel.setBounds(0, 0, 268, 830);
		menu_panel.setBorder(new LineBorder(new Color(115, 139, 197)));
		menu_panel.setLayout(new GridLayout(3, 1, 0, 0));
		menu_panel.setVisible(true);
		for (int i = 0; i < menuButton_panel.length; i++) {
			menuButton_panel[i] = new JPanel();
			menuButton_panel[i].setLayout(new BorderLayout());
			menuButton_panel[i].setBackground(new Color(115, 139, 197));
			menu_panel.add(menuButton_panel[i]);

		}
		menu_button[0] = new JButton() {
			protected void paintComponent(Graphics g) {
				Image image = new ImageIcon(menu[0]).getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				revalidate();
				repaint();
			}
		};

		menu_button[1] = new JButton() {
			protected void paintComponent(Graphics g) {
				Image image = new ImageIcon(menu[2]).getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				revalidate();
				repaint();
			}
		};
		menu_button[2] = new JButton() {
			protected void paintComponent(Graphics g) {
				Image image = new ImageIcon(menu[3]).getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				revalidate();
				repaint();
			}
		};

		for (int i = 0; i < menu_button.length; i++) {
			menuButton_panel[i].add(menu_button[i]);
			menu_button[i].addMouseListener(this);
		}

		// 중앙 패널 : 캘린더
		container.add(calendar_panel);
		calendar_panel.setBounds(288, 0, 1216, 830);
		calendar_panel.setBackground(new Color(115, 139, 197));
		calendar_panel.setLayout(new BorderLayout(0, 5));
		calendar_panel.add("North", north_panel);
		calendar_panel.add("Center", center_panel);
		calendar_panel.setVisible(true);
		// 오른쪽 패널 : + 기능
	}

	private void setNorthPanel() {
		north_panel.setBackground(white_color);

		left_button = new JButton() {
			protected void paintComponent(Graphics g) {
				Image image = new ImageIcon(buttonImg_str[0]).getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				revalidate();
				repaint();
			}
		};

		right_button = new JButton() {
			protected void paintComponent(Graphics g) {
				Image image = new ImageIcon(buttonImg_str[1]).getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				revalidate();
				repaint();
			}
		};
		north_label = new JLabel(year + "년 " + month + "월", JLabel.CENTER);
		north_label.setFont(new Font("나눔고딕", Font.BOLD, 30));
		north_child.setLayout(new BorderLayout(20, 0));
		north_child.setBackground(white_color);
		north_child.add("West", left_button);
		north_child.add("Center", north_label);
		north_child.add("East", right_button);
		north_panel.add(north_child);
		left_button.addActionListener(this);
		right_button.addActionListener(this);

	}

	private void setCenterPanel() {
		center_title.setLayout(new GridLayout(1, 7, 0, 0));
		center_title.setBackground(white_color);
		for (int i = 0; i < 7; i++) {
			JLabel label = new JLabel(day_str[i], JLabel.CENTER);
			label.setFont(new Font("나눔고딕", Font.BOLD, 20));
			center_title.add(label);
		}
		calendar_func();

		center_panel.setLayout(new BorderLayout(10, 0));
		center_bind.setLayout(new BorderLayout(0, 5));
		center_bind.add("North", center_title);
		center_bind.add("Center", center_main);
		center_panel.add(center_bind);
		center_bind.setBackground(white_color);
		center_panel.setBackground(white_color);
	}

	// 버그 발생 구역
	private void calendar_func() {
		boolean duplicate = false;
		int pp = 0;
		center_main.setLayout(new GridLayout(6, 7, 0, 5));
		center_main.setBackground(white_color);
		calendar.set(year, month - 1, 1);
		first = calendar.get(Calendar.DAY_OF_WEEK);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/* 이전 달 구하기 */
		int another_year = Integer.parseInt(north_label.getText().substring(0, 4));
		int another_month = Integer.parseInt(north_label.getText().substring(6, north_label.getText().lastIndexOf('월')))
				- 1;
		if (another_month <= 0) {
			another_month = 12;
			another_year--;
		}
		previous_calendar.set(another_year, another_month - 1, 1);
		int previous_num = previous_calendar.getActualMaximum(Calendar.DATE);
		for (int i = previous_num - first + 2; i <= previous_num; i++) {
			JPanel space_panel = new CalendarPanelBigList(i, first, 1).getBig_panel();
			center_main.add(space_panel);

		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		for (pp = 0; pp < eventlist.size(); pp++) {
			int event_year, event_month;
			if (eventlist.size() == 0)
				break;
			event_year = eventlist.get(pp).getYear();
			event_month = eventlist.get(pp).getMonth();
			if (event_year == year && event_month == month) {
				duplicate = true;
				break;
			}
		}
		if (duplicate) {
			big_panel = eventlist.get(pp).getPanel();
			for (int i = 0; i < big_panel.length; i++) {
				center_main.add(big_panel[i]);
			}
		} else {
			/* 이번 달 구하기 */
			int maximum_size = calendar.getActualMaximum(Calendar.DATE);
			big_panel = new JPanel[maximum_size];
			int what_day = first;
			for (int i = 1; i <= maximum_size; i++) {
				if (what_day > 7)
					what_day = 1;
				CalendarPanelBigList big = new CalendarPanelBigList(i, what_day);
				big_panel[i - 1] = new JPanel();
				big_panel[i - 1] = big.getBig_panel();
				big_panel[i - 1].addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent e) {
						for (int i = 0; i < big_panel.length; i++) {
							if (e.getSource() == big_panel[i]) {
								if (big_panel[i].getBackground() == Color.LIGHT_GRAY) {
									big_panel[i].setBackground(white_color);
									big_panel[i].getComponent(0).setBackground(white_color);
								} else {
									big_panel[i].setBackground(Color.LIGHT_GRAY);
									big_panel[i].getComponent(0).setBackground(Color.LIGHT_GRAY);
								}

								if (e.getClickCount() == 2) {
									if(use_func==true) {
										container.remove(func_panel);
									}
									for (int j = 0; j < big_panel.length; j++) {
										big_panel[j].setBackground(white_color);
										big_panel[j].getComponent(0).setBackground(white_color);
									}
									use_func = true;
									calendar_panel.setBounds(288, 0, 790, 830);
									create_funcPanel(year, month, i+1);
								}
							}

						}

					}
				});
				what_day++;
				center_main.add(big.getBig_panel());

			}
			eventlist.add(new EventStruct(year, month, big_panel));
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/* 다음 달 구하기 */
		another_year = Integer.parseInt(north_label.getText().substring(0, 4));
		another_month = Integer.parseInt(north_label.getText().substring(6, north_label.getText().lastIndexOf('월')))
				+ 1;

		if (another_month > 12) {
			another_month = 1;
			another_year++;
		}
		next_calendar.set(another_year, another_month - 1, 1);
		int k = 42 - center_main.getComponentCount();
		for (int i = 1; i <= k; i++) {
			JPanel space_panel = new CalendarPanelBigList(i, first, 1).getBig_panel();
			center_main.add(space_panel);
		}
		
		for(int i=0; i<big_panel.length; i++) {
			if(big_panel[i].getComponentCount() >=2) {
				int pan_count = big_panel[i].getComponentCount();
				for(int j=1; j<pan_count; j++) {
					big_panel[i].remove(1);
				}
				
			}
		}
		
		loading_calendar_event();
		thread = new Thread(this);
		thread.start();
		thread_list.add(thread);
		
		// HolidayThread holiday = new HolidayThread(year, month, center_main);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	
	//브레이크포인트
	private void loading_calendar_event() {
		SharedEvent se = new SharedEvent(year, month);
		se.selectEvent(year, month);
		
		if(se.getResult().equals("") || se.getResult()==null) {
			return ;
		}
		String[] eveArr = se.getResult().split("\n");
		for(int i=0; i<eveArr.length; i++) {
			EventPanel ep = new EventPanel(eveArr[i]);
			String[] event_sd = ep.getStart_date().split("-");
			String[] event_ed = ep.getEnd_date().split("-");
			int event_startDate = Integer.parseInt(event_sd[2].trim());
			int event_endDate =Integer.parseInt(event_ed[2].trim());
			
			if((event_sd[0].trim()).equals(event_ed[0].trim()) && (event_sd[1].trim().equals(event_ed[1].trim()))) {
				for(int k=event_startDate; k<=event_endDate; k++) {
					big_panel[k-1].add(ep.getEvent_panel());
					ep = new EventPanel(eveArr[i], true);
				}
			}
			
			else if(!(event_sd[0].trim().equals(event_ed[0])) || !(event_sd[1].trim().equals(event_ed[1].trim()))){
				if(month == Integer.parseInt(event_sd[1].trim())) {
					for (int j = event_startDate; j <= big_panel.length; j++) {
						big_panel[j-1].add(ep.getEvent_panel());
						ep = new EventPanel(eveArr[i], true);
					}
				}
//				else if(month == Integer.parseInt(event_ed[1].trim())) {
//					System.out.println("sfsaf");
//					ep = new EventPanel(eveArr[i]);
//					for (int j = 1; j <= event_endDate; j++) {
//						big_panel[j-1].add(ep.getEvent_panel());
//						ep = new EventPanel(eveArr[i]);
//					}
//				}
				
				
			}
		}
		
		
		
	}
	
	private void create_calendar_eventPanel(String event) {
		EventPanel ep = new EventPanel(event);
		String[] event_sd = ep.getStart_date().split("-");
		String[] event_ed = ep.getEnd_date().split("-");
		int[] event_startDate = new int[event_sd.length];
		int[] event_endDate = new int[event_ed.length];
		JPanel[] event_sjp = {};
		int sjp_count = -1;
		JPanel[] event_ejp = {};
		int ejp_count = -1;
		// 0번 : 년도 , 1번 : 월, 2번 : 일
		for (int i = 0; i < event_sd.length; i++) {
			event_startDate[i] = Integer.parseInt(event_sd[i].trim());
			event_endDate[i] = Integer.parseInt(event_ed[i].trim());
		}

		for (int i = 0; i < eventlist.size(); i++) {
			if (event_startDate[0] == eventlist.get(i).getYear() && event_startDate[1] == eventlist.get(i).getMonth()) {
				event_sjp = eventlist.get(i).getPanel();
				sjp_count = i;
			}

			if (event_endDate[0] == eventlist.get(i).getYear() && event_endDate[1] == eventlist.get(i).getMonth()) {
				event_ejp = eventlist.get(i).getPanel();
				ejp_count = i;
			}
		}

		//년도와 월이 같으면
		if (event_sjp == event_ejp) {
			for (int j = event_startDate[2]; j <= event_endDate[2]; j++) {
				eventlist.get(sjp_count).getPanel()[j - 1].add(ep.getEvent_panel());
				ep = new EventPanel(event, true);
			}
		} 
		//년도와 월이 다르면
		else {
			Calendar c = Calendar.getInstance();
			c.set(event_startDate[0], event_startDate[1] - 1, 1);
			for (int j = event_startDate[2]; j <= c.getActualMaximum(Calendar.DATE); j++) {
				eventlist.get(sjp_count).getPanel()[j - 1].add(ep.getEvent_panel());
				ep = new EventPanel(event, true);
			}
			ep = new EventPanel(event);
			for (int j = 1; j <= event_endDate[2]; j++) {
				eventlist.get(ejp_count).getPanel()[j - 1].add(ep.getEvent_panel());
				ep = new EventPanel(event, true);
			}
		}

		// 브레이크포인트

//				System.out.println(event_jp.length);
//				for(int j=0; j<event_jp.length; j++) {
//					System.out.println(event_startDate[2]);
//					if(event_jp[j].getComponentCount()==1) {
//						event_jp[j].add();
//					}
//				}

//		System.out.println(eventlist.size());
//		System.out.println(eventlist.get(0).getPanel().length);
//		
//		for(int i=0; i<eventlist.get(0).getPanel().length; i++) {
//			ddd[i].add(new JLabel("gg", JLabel.CENTER), 1);
//			revalidate();
//			repaint();
//		}
	}

	public void calDate(int num) {
		month += num;
		if (month <= 0) {
			month = 12;
			year--;
		} else if (month >= 13) {
			month = 1;
			year++;
		}
	}

	private void func() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void create_funcPanel(int year, int month, int i) {
		ui = new UI(year, month, memberDTO.getId());
		func_panel = ui.getMom();
		check_panel = ui.getCheck();
		back_panel = ui.getBack();
		func_panel.setLayout(null);
		
		back_panel.addMouseListener(this);
		check_panel.addMouseListener(this);
		container.add(func_panel);
		
		func_panel.setBounds(1100, 0, 440, 830);
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == right_button) {
			calDate(1);
			north_label.setText(year + "년 " + month + "월");
			center_main.removeAll();
			calendar_func();

		} else if (e.getSource() == left_button) {
			calDate(-1);
			north_label.setText(year + "년 " + month + "월");
			center_main.removeAll();
			calendar_func();
		}
		remove_thread(thread_list.get(0));

		revalidate();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == menu_button[0]) {
			// 브레이크포인트
		} else if (e.getSource() == menu_button[1]) {
			if (container.getComponentCount() <= 2 && use_func == false) {
				if (container.getComponent(1) == calendar_panel) {
					return;
				} else if (container.getComponent(1) == seoul_panel) {
					container.remove(seoul_panel);
					container.add(calendar_panel);
					calendar_panel.setBounds(288, 0, 1216, 830);
				}
			} else if (use_func == true) {
				for (int i = 0; i < container.getComponentCount(); i++) {
					if (container.getComponent(i) == calendar_panel) {
						return;
					} else if (container.getComponent(i) == seoul_panel) {

						container.remove(seoul_panel);
						container.add(calendar_panel);
						calendar_panel.setBounds(288, 0, 790, 830);
					}
				}

			}

		} else if (e.getSource() == menu_button[2]) {
			if (container.getComponentCount() <= 2 && use_func == false) {
				if (container.getComponent(1) == seoul_panel) {
					return;
				} else if (container.getComponent(1) == calendar_panel) {
					if(seoul_panel.getComponentCount()==0) {
						seoul_panel = new Seoul().getPanel();
					}
					container.remove(calendar_panel);
					container.add(seoul_panel);
					seoul_panel.setBounds(288, 0, 1200, 900);
				}

			}else if (use_func == true) {
				for (int i = 0; i < container.getComponentCount(); i++) {
					if (container.getComponent(i) == calendar_panel) {
						container.remove(calendar_panel);
						container.add(seoul_panel);
						seoul_panel.setBounds(288, 0, 790, 830);
						seoul_panel.removeAll();
					} else if (container.getComponent(i) == seoul_panel) {
						return;
					}
				}
			}


		}
		
		else if (e.getSource() == back_panel || e.getSource()==check_panel) {
			for(int i=0; i<container.getComponentCount(); i++) {
				if(container.getComponent(i)==calendar_panel) {
					container.remove(func_panel);
					container.add(calendar_panel);
					calendar_panel.setBounds(288, 0, 1216, 830);
					use_func = false;
				}else if(container.getComponent(i)==seoul_panel) {
					container.remove(func_panel);
					container.add(seoul_panel);
					seoul_panel.setBounds(288, 0, 1200, 900);
					use_func = false;
				}
			}
			
			if(e.getSource()==check_panel) {
				DTO dto = ui.getDto();
				String event = dto.toString();
				create_calendar_eventPanel(event);
			}
			
		}
		revalidate();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == menu_button[0]) {
			menuButton_panel[0].setBackground(new Color(63, 93, 152));
			menuButton_panel[0].setLayout(null);
			member_name = new JLabel(memberDTO.getName(), JLabel.CENTER);
			menuButton_panel[0].add(member_name);
			member_name.setFont(new Font("나눔고딕", Font.BOLD, 20));
			member_name.setForeground(white_color);
			member_name.setBounds(10,210,250,100);
			
		} else if (e.getSource() == menu_button[1]) {
			menuButton_panel[1].setBackground(new Color(63, 93, 152));
		} else if (e.getSource() == menu_button[2]) {
			menuButton_panel[2].setBackground(new Color(63, 93, 152));
		}
		revalidate();
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==menu_button[0]) {
			member_name.setVisible(false);
		}
		menuButton_panel[0].setBackground(new Color(115, 139, 197));
		menuButton_panel[1].setBackground(new Color(115, 139, 197));
		menuButton_panel[2].setBackground(new Color(115, 139, 197));
		revalidate();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	public synchronized void add_thread(Thread thread) {
		thread_list.add(thread);
	}

	public synchronized void remove_thread(Thread thread) {
		thread_list.remove(thread);
	}

	public void run() {
		JPanel temporary_panel;
		JLabel temporary_label;
		String[] child_holiday;
		Holiday holiday = new Holiday(year, month);
		holiday.selectArticle();
		if (holiday.isHoliday() == false) {
			holiday.selectArticle2();
		}

		if (holiday.isHoliday() == true) {
			String[] total_holiday = holiday.getResult().split("\n");
			for (int i = 0; i < total_holiday.length; i++) {
				child_holiday = total_holiday[i].split("\t");
				temporary_panel = (JPanel) big_panel[Integer.parseInt(child_holiday[1]) - 1].getComponent(0);
				temporary_label = (JLabel) temporary_panel.getComponent(0);
				temporary_label.setForeground(Color.red);
				if (!(child_holiday[2].equals("null"))) {
					temporary_label.setText(child_holiday[2]);
				}
			}

			for (int i = 0; i < total_holiday.length; i++) {
				child_holiday = total_holiday[i].split("\t");
				temporary_panel = (JPanel) big_panel[Integer.parseInt(child_holiday[1]) - 1].getComponent(0);
				temporary_label = (JLabel) temporary_panel.getComponent(0);
				temporary_label.setForeground(Color.red);
				if (!(child_holiday[2].equals("null")) && !(child_holiday[2].equals("대체공휴일"))) {
					int count = 2;
					temporary_label.setText(child_holiday[2]);
					int xx_size = child_holiday[2].length();
					while (count > 0) {
						try {
							Thread.sleep(600);
							for (int xx = 1; xx <= xx_size; xx++) {
								Thread.sleep(200);
								temporary_label.setText(child_holiday[2].substring(0, xx));
							}
							count--;

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else {
			return;
		}
	}

}