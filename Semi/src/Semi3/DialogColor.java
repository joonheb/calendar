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
	
	JPanel bg = new JPanel() { // 배경패널
		ImageIcon iconbg = new ImageIcon("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\colorsen.png");

		protected void paintComponent(Graphics g) {
			Dimension d = getSize();
			g.drawImage(iconbg.getImage(), 0, 0, d.width, d.height, null);
		};
	};
	// 패널
	JPanel check = new JPanel();// 확인버튼
	JPanel panelgreen = new JPanel();// 초록색
	JPanel panelpink = new JPanel();// 핑크색
	JPanel panelyellow = new JPanel();// 노랑색
	JPanel panelpuple = new JPanel();// 보라색
	// 라디오버튼
	JButton buttoncolorred = new JButton(); // 라디오버튼 초기화(컨테이너에 포함 x)
	ButtonGroup buttonGroupcolor = new ButtonGroup();
	JRadioButton green = new JRadioButton();
	JRadioButton pink = new JRadioButton();
	JRadioButton yellow = new JRadioButton();
	JRadioButton puple = new JRadioButton();

	// 생성자
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
		// 초록
		bg.add(panelgreen);
		panelgreen.setBounds(0, 78, 420, 52);
		panelgreen.setBackground(Color.red);
		panelgreen.setOpaque(false);
		bg.add(green);
		green.setBounds(374, 88, 30, 30);
		green.setOpaque(false);
		// 분홍
		bg.add(panelpink);
		panelpink.setBounds(0, 129, 420, 52);
		panelpink.setBackground(Color.red);
		panelpink.setOpaque(false);
		bg.add(pink);
		pink.setBounds(374, 140, 30, 30);
		pink.setOpaque(false);
		// 노랑
		bg.add(panelyellow);
		panelyellow.setBounds(0, 180, 420, 52);
		panelyellow.setBackground(Color.red);
		panelyellow.setOpaque(false);
		bg.add(yellow);
		yellow.setBounds(374, 192, 30, 30);
		yellow.setOpaque(false);
		// 보라
		bg.add(panelpuple);
		panelpuple.setBounds(0, 231, 420, 52);
		panelpuple.setBackground(Color.red);
		panelpuple.setOpaque(false);
		bg.add(puple);
		puple.setBounds(374, 243, 30, 30);
		puple.setOpaque(false);
		// 확인
		bg.add(check);
		check.setBounds(0, 284, 420, 75);
		check.setBackground(Color.red);
		check.setOpaque(false);
	}//init()끝

	private void start(DTO dto) {
		// 창닫는 버튼
		setDefaultCloseOperation(HIDE_ON_CLOSE);	//숨겨준다
		dto.setColor("115,139,197");				// 디폴트 색상 처리(보라색)
		//확인버튼 클릭시 창 닫기
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				dispose();
			}

		});
		// 초록색 선택
		panelgreen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				green.setSelected(true);	//그린라디오버튼 클릭
				//DTO에 정보를 담는다.
				dto.setMainpage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\memo\\green.png");
				dto.setTimepage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\time\\green.png");
				dto.setColor("172,219,218");

			}
		});
		// 핑크색 선택
		panelpink.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				pink.setSelected(true);
				dto.setMainpage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\memo\\pink.png");
				dto.setTimepage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\time\\pink.png");
				dto.setColor("245, 187, 209");
			}
		});
		// 노란색 선택
		panelyellow.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				yellow.setSelected(true);
				dto.setMainpage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\memo\\yellow.png");
				dto.setTimepage("C:\\Users\\CJB\\eclipse-workspace\\Semi\\image\\timememo\\time\\yellow.png");
				dto.setColor("245,217,127");

			}
		});
		// 보라색 선택
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
