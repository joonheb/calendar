package First;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Line.Info;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.common.base.Stopwatch;

import Semi1.MainUI;
import Semi1.MemberProc;

public class Starter extends JFrame implements Runnable {
	final static int file_num = 115;
	Container container = getContentPane();
	JPanel first_panel;
	String[] strarr = new String[file_num];
	String str;
	List<Thread> list = new ArrayList<Thread>();
	Thread thread;
	MainUI mainUI = new MainUI();
	MemberProc memberProc = new MemberProc();
	JPanel panel = memberProc.getPanel();
	JPanel p1 = mainUI.getP1();
	JPanel p2 = mainUI.getP2();
	boolean b = false;
	int count = 0, count2=0;
	int finally_count = 10;

	public Starter() {
		setTitle("SEMI-PROJECT Login Manager");
		setBounds(192, 108, 1536, 864);
		init();
		setVisible(true);
	}
	

	private void init() {
		for (int i = 0; i < file_num; i++) {
			String path = "image\\first\\logo\\";
			if (i <= 9) {
				str = "logo_0000" + String.valueOf(i);
			} else if (i <= 99) {
				str = "logo_000" + String.valueOf(i);
			} else if (i <= 115) {
				str = "logo_00" + String.valueOf(i);
			}
			path = path + str + ".png";
			strarr[i] = path;
		}

		first_panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Image image = new ImageIcon(strarr[0]).getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
			}
		};
		first_panel.setBorder(new LineBorder(Color.red));
		container.add(first_panel);
		first_panel.setVisible(true);
		thread = new Thread(this);
		
		list.add(thread);
		thread.start();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		
		while (count < file_num-1) {
			try {
				if(count>=file_num-1) {
					thread.interrupt();
				}
				Thread.sleep(10);
				first_panel = new JPanel() {
					@Override
					protected void paintComponent(Graphics g) {
						Image image = new ImageIcon(strarr[count]).getImage();
						g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
					}
				};
				container.removeAll();
				container.add(first_panel);
				revalidate();
				repaint();
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		list.remove(0);
		if(list.size()==0) {
			container.removeAll();
			container.setLayout(null);
			container.add(p1);
			container.add(p2);
			
			p1.setBounds(0, 0, 1030, 826);
			p2.setBounds(1030, 0, 499, 826);
			revalidate();
			repaint();
			
		}
		
	}
	public synchronized void add_thread(Thread thread) {
		list.add(thread);
	}

	public synchronized void remove_thread(Thread thread) {
		list.remove(thread);
	}
	
	public JPanel getFirst_panel() {
		return first_panel;
	}

	public void setFirst_panel(JPanel first_panel) {
		this.first_panel = first_panel;
	}
	public static void main(String[] args) {
		new Starter();
	}

}

