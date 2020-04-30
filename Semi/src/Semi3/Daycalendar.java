package Semi3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Daycalendar extends JFrame {
	Container container = getContentPane();
	Hcalendar hcalendar = new Hcalendar();
	String str = hcalendar.thistime(); // �󺧿� ����ð� ����
	private String return_str = "";
	// ���
	JPanel dialogcalendar = new JPanel() {
		protected void paintComponent(Graphics g) {
			ImageIcon iconbg = new ImageIcon(DTO.timepage);
			Dimension d = getSize();
			g.drawImage(iconbg.getImage(), 0, 0, d.width, d.height, null);
		};
	};

	// year
	JPanel buttondayyearup = new JPanel();
	JPanel buttondayyeardown = new JPanel();
	// month
	JPanel buttondaymonthup = new JPanel();
	JPanel buttondaymonthdown = new JPanel();
	// day
	JPanel buttondayup = new JPanel();
	JPanel buttondaydown = new JPanel();
	// hour
	JPanel buttondayhourup = new JPanel();
	JPanel buttondayhourdown = new JPanel();
	// minute
	JPanel buttondayminuterup = new JPanel();
	JPanel buttondayminutedown = new JPanel();
	// Ȯ��, ���
	JPanel buttonexe = new JPanel();
	JPanel buttoncheck = new JPanel();

	// ������
	public Daycalendar(JLabel label1) {
		label();
		timelabel();
		init();
		start(label1);
		setBounds(0, 0, 420, 320);
		setVisible(true);
	}

	private void init() {
		// ��Ʈ
		Font fontBold = new Font("������� ExtraBold", Font.BOLD, 23);
		Color blackgray = new Color(181, 180, 185);

		container.setLayout(new BorderLayout());
		container.add(dialogcalendar);

		dialogcalendar.setLayout(null);
		dialogcalendar.setBounds(0, 0, 420, 320);

		// ��
		for (int i = 0; i < label.length; i++) {
			dialogcalendar.add(label[i]);
			label[i].setSize(300, 50);
			label[i].setOpaque(false);
			label[i].setFont(fontBold);
			label[i].setForeground(blackgray);
			label[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		// �� ��ġ ����
		label[0].setLocation(35, 78);
		label[1].setLocation(156, 78);
		label[2].setLocation(220, 78);
		label[3].setLocation(288, 78);
		label[4].setLocation(353, 78);
		// �� ��ư
		dialogcalendar.add(buttondayyearup);
		buttondayyearup.setBounds(0, 0, 135, 70);
		buttondayyearup.setBackground(Color.red);
		buttondayyearup.setOpaque(false);
		dialogcalendar.add(buttondaymonthup);
		buttondaymonthup.setBounds(135, 0, 70, 70);
		buttondaymonthup.setBackground(Color.red);
		buttondaymonthup.setOpaque(false);
		dialogcalendar.add(buttondayup);
		buttondayup.setBounds(205, 0, 66, 70);
		buttondayup.setBackground(Color.red);
		buttondayup.setOpaque(false);
		dialogcalendar.add(buttondayhourup);
		buttondayhourup.setBounds(271, 0, 68, 70);
		buttondayhourup.setBackground(Color.red);
		buttondayhourup.setOpaque(false);
		dialogcalendar.add(buttondayminuterup);
		buttondayminuterup.setBounds(339, 0, 68, 70);
		buttondayminuterup.setBackground(Color.red);
		buttondayminuterup.setOpaque(false);
		// �Ʒ� ��ư
		dialogcalendar.add(buttondayyeardown);
		buttondayyeardown.setBounds(0, 140, 135, 70);
		buttondayyeardown.setBackground(Color.red);
		buttondayyeardown.setOpaque(false);
		dialogcalendar.add(buttondaymonthdown);
		buttondaymonthdown.setBounds(135, 140, 70, 70);
		buttondaymonthdown.setBackground(Color.red);
		buttondaymonthdown.setOpaque(false);
		dialogcalendar.add(buttondaydown);
		buttondaydown.setBounds(205, 140, 66, 70);
		buttondaydown.setBackground(Color.red);
		buttondaydown.setOpaque(false);
		dialogcalendar.add(buttondayhourdown);
		buttondayhourdown.setBounds(271, 140, 68, 70);
		buttondayhourdown.setBackground(Color.red);
		buttondayhourdown.setOpaque(false);
		dialogcalendar.add(buttondayminutedown);
		buttondayminutedown.setBounds(339, 140, 68, 70);
		buttondayminutedown.setBackground(Color.red);
		buttondayminutedown.setOpaque(false);
		// Ȯ�� ����
		dialogcalendar.add(buttonexe);
		buttonexe.setBounds(0, 210, 205, 73);
		buttonexe.setBackground(Color.red);
		buttonexe.setOpaque(false);
		dialogcalendar.add(buttoncheck);
		buttoncheck.setBounds(205, 210, 205, 73);
		buttoncheck.setBackground(Color.red);
		buttoncheck.setOpaque(false);

	}// init ��

	// ��(��,��,��,��,��)
	JLabel[] label = new JLabel[5];

	// �� 5�� ����
	public void label() {

		for (int i = 0; i < 5; i++) {
			label[i] = new JLabel();
		}
	}

	// �󺧹迭�� ��¥ �־��� / ����â �󺧿� ���� �־���
	public void timelabel() {
		// �󺧹迭�� ��¥ �־���
		String[] data = str.split("-");
		for (int i = 0; i < data.length; i++) {
			label[i].setText(data[i]);
		}
	}// timelabel ��

	private void start(JLabel label1) {
		//â �ݱ�
		setDefaultCloseOperation(HIDE_ON_CLOSE);	//����
		
		// Ȯ�ι�ư ������ ���̾Ʒα�â ����
		buttoncheck.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				return_str = label[0].getText() + "�� " + label[1].getText() + "�� " + label[2].getText() + "��";
				label1.setText(return_str);
				dispose();
			};

		});
		// ��ҹ�ư ������ ���̾Ʒα�â ����
		/* main ���� ���� ��¥�� ����Ǿ�� �ϴµ� �ȵ� */
		buttonexe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {//��������
				super.mousePressed(e);
				label1.setText(new Hcalendar().time());
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {//��������
				super.mouseReleased(e);
				dispose();
			}
		});
		// year up
		buttondayyearup.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				str = hcalendar.year_up();
				timelabel();
			}
		});
		// year down
		buttondayyeardown.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.year_down();
				timelabel();

			}
		});
		// month up
		buttondaymonthup.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.month_up();
				timelabel();
			}
		});
		// month down
		buttondaymonthdown.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.month_down();
				timelabel();
			}
		});
		// day up
		buttondayup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.day_up();
				timelabel();
			}
		});
		// day down
		buttondaydown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.day_down();
				timelabel();
			}
		});
		// hour up
		buttondayhourup.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.hour_up();
				timelabel();
			}
		});
		// hour down
		buttondayhourdown.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.hour_down();
				timelabel();
			}
		});
		// minue up
		buttondayminuterup.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.minue_up();
				timelabel();
			}
		});
		// minue down
		buttondayminutedown.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				str = hcalendar.minue_down();
				timelabel();
			}
		});
	}

	public String getReturn_str() {
		return return_str;
	}

}
