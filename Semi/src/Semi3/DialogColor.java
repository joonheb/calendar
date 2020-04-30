package Semi3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.border.LineBorder;

public class DialogColor extends JFrame {
	Container container = getContentPane();
	
	JPanel bg = new JPanel() { // ����г�
		ImageIcon iconbg = new ImageIcon("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\colorsen.png");

		protected void paintComponent(Graphics g) {
			Dimension d = getSize();
			g.drawImage(iconbg.getImage(), 0, 0, d.width, d.height, null);
		};
	};
	// �г�
	JPanel check = new JPanel();// Ȯ�ι�ư
	JPanel panelgreen = new JPanel();// �ʷϻ�
	JPanel panelpink = new JPanel();// ��ũ��
	JPanel panelyellow = new JPanel();// �����
	JPanel panelpuple = new JPanel();// �����
	// ������ư
	JButton buttoncolorred = new JButton(); // ������ư �ʱ�ȭ(�����̳ʿ� ���� x)
	ButtonGroup buttonGroupcolor = new ButtonGroup();
	JRadioButton green = new JRadioButton();
	JRadioButton pink = new JRadioButton();
	JRadioButton yellow = new JRadioButton();
	JRadioButton puple = new JRadioButton();

	// ������
	public DialogColor(DTO dto) {
		init();
		start(dto);
		setBounds(0, 0, 420, 389);
		setResizable(false);
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add(bg);
		bg.setLayout(null);
		buttonGroupcolor.add(green);
		buttonGroupcolor.add(pink);
		buttonGroupcolor.add(yellow);
		buttonGroupcolor.add(puple);
		// �ʷ�
		bg.add(panelgreen);
		panelgreen.setBounds(0, 78, 420, 52);
		panelgreen.setBackground(Color.red);
		panelgreen.setOpaque(false);
		bg.add(green);
		green.setBounds(374, 88, 30, 30);
		green.setOpaque(false);
		// ��ȫ
		bg.add(panelpink);
		panelpink.setBounds(0, 129, 420, 52);
		panelpink.setBackground(Color.red);
		panelpink.setOpaque(false);
		bg.add(pink);
		pink.setBounds(374, 140, 30, 30);
		pink.setOpaque(false);
		// ���
		bg.add(panelyellow);
		panelyellow.setBounds(0, 180, 420, 52);
		panelyellow.setBackground(Color.red);
		panelyellow.setOpaque(false);
		bg.add(yellow);
		yellow.setBounds(374, 192, 30, 30);
		yellow.setOpaque(false);
		// ����
		bg.add(panelpuple);
		panelpuple.setBounds(0, 231, 420, 52);
		panelpuple.setBackground(Color.red);
		panelpuple.setOpaque(false);
		bg.add(puple);
		puple.setBounds(374, 243, 30, 30);
		puple.setOpaque(false);
		// Ȯ��
		bg.add(check);
		check.setBounds(0, 284, 420, 75);
		check.setBackground(Color.red);
		check.setOpaque(false);
	}//init()��

	private void start(DTO dto) {
		// â�ݴ� ��ư
		setDefaultCloseOperation(HIDE_ON_CLOSE);	//�����ش�
		dto.setColor("115,139,197");				// ����Ʈ ���� ó��(�����)
		//Ȯ�ι�ư Ŭ���� â �ݱ�
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				dispose();
			}

		});
		// �ʷϻ� ����
		panelgreen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				green.setSelected(true);	//�׸�������ư Ŭ��
				//DTO�� ������ ��´�.
				dto.setMainpage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\memo\\green.png");
				dto.setTimepage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\time\\green.png");
				dto.setColor("172,219,218");

			}
		});
		// ��ũ�� ����
		panelpink.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				pink.setSelected(true);
				dto.setMainpage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\memo\\pink.png");
				dto.setTimepage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\time\\pink.png");
				dto.setColor("245, 187, 209");
			}
		});
		// ����� ����
		panelyellow.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				yellow.setSelected(true);
				dto.setMainpage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\memo\\yellow.png");
				dto.setTimepage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\time\\yellow.png");
				dto.setColor("245,217,127");

			}
		});
		// ����� ����
		panelpuple.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				puple.setSelected(true);
				dto.setMainpage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\memo\\puple.png");
				dto.setTimepage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\time\\puple.png");
				dto.setColor("115,139,197");

			}
		});
	}
}
