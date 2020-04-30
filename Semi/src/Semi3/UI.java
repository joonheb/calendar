package Semi3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class UI extends JFrame {
	Hcalendar hcalendar = new Hcalendar();

	DTO dto = new DTO(); // 정보 담고 있는 DTO 호출
	JPanel panelmom = new JPanel() { // 배경 패널

		protected void paintComponent(Graphics g) {
			Image iconbg = new ImageIcon(dto.getMainpage()).getImage();
			Dimension d = getSize();
			g.drawImage(iconbg, 0, 0, d.width, d.height, null);
			//setOpaque(false);
		};

	};

	// 패널
	JPanel back = new JPanel();// 뒤로 가기 버튼
	JPanel check = new JPanel(); // 체크 버튼

	JPanel dayright = new JPanel();// 날짜 오른쪽
	JPanel dayleft = new JPanel(); // 날짜 왼쪽
	JPanel buttoncolornext = new JPanel();// 색상 오른쪽
	JPanel memo = new JPanel();// 메모

	// 라벨
	JLabel timeup= new JLabel(hcalendar.time(), Label.LEFT);
	JLabel timedown = new JLabel(hcalendar.time(), Label.LEFT);
	// color
	Color textareaBGcolor = new Color(248, 249, 241);
	Color gray = new Color(241, 244, 251);
	Color blackgray = new Color(181, 180, 185);
	Color jenbo = new Color(63, 93, 152);
	Color bo = new Color(115, 139, 197);
	Color yellow = new Color(245, 217, 127);
	Color pink = new Color(245, 187, 209);
	Color green = new Color(172, 219, 218);

	JTextField title = new JTextField(20); // 제목 텍스트
	
	// 메모아이콘을 클릭하면 메모장이 나오는 변수명 모음
	JPanel panelmemo = new JPanel(); // JScrollPane를 담고 있는 패널
	JPanel panelmemoscroll = new JPanel();
	JTextArea textAreamemo = new JTextArea();
	JScrollPane scrollPanememo = new JScrollPane(textAreamemo);

	// 폰트
	Font fontBold = new Font("나눔고딕 ExtraBold", Font.BOLD, 33);
	Font fontRegular = new Font("나눔고딕", 0, 17);
			
	public UI(int year, int month, String id) {
		
		init(year,month,id);
		start(year, month, id);
	}

	public void init(int year, int month, String id) {

		// mom에 panelmom추가
//		mom.setLayout(new BorderLayout());
//		mom.add(panelmom);

		panelmom.setLayout(null);
		// 제목라벨
		panelmom.add(title);
		title.setSize(300, 40);
		title.setLocation(60, 102);
		title.setOpaque(false);
		title.setFont(fontBold);
		title.setText("제목");
		title.setForeground(blackgray);
		title.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		
		// 뒤로가기 아이콘
		panelmom.add(back);
		back.setBounds(22, 18, 50, 50);
		back.setBackground(blackgray);
		back.setOpaque(false);
		// 체크버튼 아이콘
		panelmom.add(check);
		check.setBounds(344, 18, 50, 50);
		check.setBackground(blackgray);
		check.setOpaque(false);
		
		// 컬러 next칸
		panelmom.add(buttoncolornext);
		buttoncolornext.setBounds(0, 279, 420, 69);
		buttoncolornext.setBackground(blackgray);
		buttoncolornext.setOpaque(false);
		
		// 날짜 위 패널
		panelmom.add(dayright);
		dayright.setBounds(0, 178, 420, 40);
		dayright.setBackground(blackgray);
		dayright.setOpaque(false);
		
		// 날짜 나오는칸 위(라벨
		
		panelmom.add(timeup);
		timeup.setFont(fontRegular);
		timeup.setForeground(blackgray);
		timeup.setBounds(160, 178, 260, 40);
				
		// 날짜 아래 패널
		panelmom.add(dayleft);
		dayleft.setBounds(0, 222, 420, 40);
		dayleft.setBackground(blackgray);
		dayleft.setOpaque(false);
		
		// 날짜나오는 칸 아래(라벨)
		
		panelmom.add(timedown);
		timedown.setFont(fontRegular);
		timedown.setForeground(blackgray);
		timedown.setBounds(160, 222, 260, 40);
		
		
		// 메모버튼
		panelmom.add(memo);
		memo.setBounds(23, 360, 50, 50);
		memo.setBackground(blackgray);
		memo.setOpaque(false);
		
		
		
		//테스트용 임시 (브레이크포인트)    //최종에 지울것
//		memo.setBorder(new LineBorder(Color.red));
//		dayleft.setBorder(new LineBorder(Color.red));
//		dayright.setBorder(new LineBorder(Color.red));
//		buttoncolornext.setBorder(new LineBorder(Color.red));
//		check.setBorder(new LineBorder(Color.red));
//		timedown.setBorder(new LineBorder(Color.red));
//		timeup.setBorder(new LineBorder(Color.red));
//		check.setBorder(new LineBorder(Color.red));
//		back.setBorder(new LineBorder(Color.red));
//		title.setBorder(new LineBorder(Color.red));
	}// init() 끝

	public void start(int year, int month, String id) {
		// 뒤로가기 버튼 이벤트(패널 없애기)
		back.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//브레이크포인트

			}

		});
		// 체크버튼 이벤트 (페널없애기 및 데이터 전송)
		check.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//DTO에 정보 저장
				
				
				dto.setId(id);
				dto.setTitle(title.getText());
				dto.setMemo(textAreamemo.getText());
				dto.setTime1((timeup.getText().replace("년", "-").replace("월", "-").replace("일", "")));
				dto.setTime2((timedown.getText().replace("년", "-").replace("월", "-").replace("일", "")));
				
//				System.out.println(title.getText());;
//				System.out.println(dto.getTime1());
//				System.out.println(dto.getTime2());
//				System.out.println(dto.getColor());
//				System.out.println(textAreamemo.getText());
				
				DAO dao=new DAO();		//<-전달할 메소드 선언
				dao.insert(dto, year, month);  	 	//<- 데이터 저장
				//브레이크포인트

			}

		});

		// 색상정하는 버튼 클릭
		buttoncolornext.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new DialogColor(dto); 	//색 정하는 창이 뜬다.
				revalidate();
				repaint();
			}

		});
		// 날짜 up 패널 선택 다이아로그
		timeup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Daycalendar dc = new Daycalendar(timeup);
				timeup.setText(dc.getReturn_str()); 	//날짜 지정하는 창이 뜬다 (1)
			}
		});
		// 날짜 down 패널 선택 다이아로그
		timedown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Daycalendar dc = new Daycalendar(timedown);
				timedown.setText(dc.getReturn_str()); 	//날짜 지정하는 창이 뜬다 (1)
			}
		});

		// 메모 버튼 클릭 이벤트 (scrollPanememo 나옴)
		memo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(e.getClickCount()==1) {
					//scrollPanememo을 담고있는 패널을 panelmom에 추가
					panelmom.add(panelmemoscroll);
					panelmemoscroll.setLayout(new BorderLayout());
					panelmemoscroll.setBorder(new LineBorder(Color.red));
					panelmemoscroll.setBounds(85, 360, 303, 440);
					panelmemoscroll.add(scrollPanememo);
					panelmemoscroll.setOpaque(false);
					//textAreamemo.setOpaque(false);
					
					
					textAreamemo.setText("메모");
					textAreamemo.setFont(fontRegular);
					textAreamemo.setForeground(blackgray);
					Border lineBorder = BorderFactory.createLineBorder(blackgray, 3);
					Border emptyBorder = BorderFactory.createEmptyBorder(2, 5, 5, 5);
					textAreamemo.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
					
					//panelmemoscroll : 라인 사라지는거
					panelmemoscroll.setBorder(null);
					
				} else if(e.getClickCount()==2) {	/*2번클릭시 메모장 사라지는거 안됨*/
					dto.setMemo(textAreamemo.getText());
					panelmom.remove(panelmemoscroll);
					panelmom.revalidate();
					panelmom.repaint();
				}
				
			}
		});
		// textAreamemo 메모 사라지는거
		textAreamemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//마우스 클릭시 "메모"일때만 글자가 사라짐
				if(textAreamemo.getText().equals("메모")) textAreamemo.setText("");

			}
		});
		// textFieldtitle 제목 사라지는거
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//마우스 클릭시 "제목"일때만 글자가 사라짐
				if(title.getText().equals("제목")) title.setText("");
			}
		});

	}

	public JPanel getMom() {
		return panelmom;
	}
	public JPanel getBack() {
		return back;
	}

	public JPanel getCheck() {
		return check;
	}
	public DTO getDto() {
		return dto;
	}	
}
