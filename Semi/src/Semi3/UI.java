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

	DTO dto = new DTO(); // ���� ��� �ִ� DTO ȣ��
	JPanel panelmom = new JPanel() { // ��� �г�

		protected void paintComponent(Graphics g) {
			Image iconbg = new ImageIcon(dto.getMainpage()).getImage();
			Dimension d = getSize();
			g.drawImage(iconbg, 0, 0, d.width, d.height, null);
			//setOpaque(false);
		};

	};

	// �г�
	JPanel back = new JPanel();// �ڷ� ���� ��ư
	JPanel check = new JPanel(); // üũ ��ư

	JPanel dayright = new JPanel();// ��¥ ������
	JPanel dayleft = new JPanel(); // ��¥ ����
	JPanel buttoncolornext = new JPanel();// ���� ������
	JPanel memo = new JPanel();// �޸�

	// ��
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

	JTextField title = new JTextField(20); // ���� �ؽ�Ʈ
	
	// �޸�������� Ŭ���ϸ� �޸����� ������ ������ ����
	JPanel panelmemo = new JPanel(); // JScrollPane�� ��� �ִ� �г�
	JPanel panelmemoscroll = new JPanel();
	JTextArea textAreamemo = new JTextArea();
	JScrollPane scrollPanememo = new JScrollPane(textAreamemo);

	// ��Ʈ
	Font fontBold = new Font("������� ExtraBold", Font.BOLD, 33);
	Font fontRegular = new Font("�������", 0, 17);
			
	public UI(int year, int month, String id) {
		
		init(year,month,id);
		start(year, month, id);
	}

	public void init(int year, int month, String id) {

		// mom�� panelmom�߰�
//		mom.setLayout(new BorderLayout());
//		mom.add(panelmom);

		panelmom.setLayout(null);
		// �����
		panelmom.add(title);
		title.setSize(300, 40);
		title.setLocation(60, 102);
		title.setOpaque(false);
		title.setFont(fontBold);
		title.setText("����");
		title.setForeground(blackgray);
		title.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		
		// �ڷΰ��� ������
		panelmom.add(back);
		back.setBounds(22, 18, 50, 50);
		back.setBackground(blackgray);
		back.setOpaque(false);
		// üũ��ư ������
		panelmom.add(check);
		check.setBounds(344, 18, 50, 50);
		check.setBackground(blackgray);
		check.setOpaque(false);
		
		// �÷� nextĭ
		panelmom.add(buttoncolornext);
		buttoncolornext.setBounds(0, 279, 420, 69);
		buttoncolornext.setBackground(blackgray);
		buttoncolornext.setOpaque(false);
		
		// ��¥ �� �г�
		panelmom.add(dayright);
		dayright.setBounds(0, 178, 420, 40);
		dayright.setBackground(blackgray);
		dayright.setOpaque(false);
		
		// ��¥ ������ĭ ��(��
		
		panelmom.add(timeup);
		timeup.setFont(fontRegular);
		timeup.setForeground(blackgray);
		timeup.setBounds(160, 178, 260, 40);
				
		// ��¥ �Ʒ� �г�
		panelmom.add(dayleft);
		dayleft.setBounds(0, 222, 420, 40);
		dayleft.setBackground(blackgray);
		dayleft.setOpaque(false);
		
		// ��¥������ ĭ �Ʒ�(��)
		
		panelmom.add(timedown);
		timedown.setFont(fontRegular);
		timedown.setForeground(blackgray);
		timedown.setBounds(160, 222, 260, 40);
		
		
		// �޸��ư
		panelmom.add(memo);
		memo.setBounds(23, 360, 50, 50);
		memo.setBackground(blackgray);
		memo.setOpaque(false);
		
		
		
		//�׽�Ʈ�� �ӽ� (�극��ũ����Ʈ)    //������ �����
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
	}// init() ��

	public void start(int year, int month, String id) {
		// �ڷΰ��� ��ư �̺�Ʈ(�г� ���ֱ�)
		back.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//�극��ũ����Ʈ

			}

		});
		// üũ��ư �̺�Ʈ (��ξ��ֱ� �� ������ ����)
		check.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//DTO�� ���� ����
				
				
				dto.setId(id);
				dto.setTitle(title.getText());
				dto.setMemo(textAreamemo.getText());
				dto.setTime1((timeup.getText().replace("��", "-").replace("��", "-").replace("��", "")));
				dto.setTime2((timedown.getText().replace("��", "-").replace("��", "-").replace("��", "")));
				
//				System.out.println(title.getText());;
//				System.out.println(dto.getTime1());
//				System.out.println(dto.getTime2());
//				System.out.println(dto.getColor());
//				System.out.println(textAreamemo.getText());
				
				DAO dao=new DAO();		//<-������ �޼ҵ� ����
				dao.insert(dto, year, month);  	 	//<- ������ ����
				//�극��ũ����Ʈ

			}

		});

		// �������ϴ� ��ư Ŭ��
		buttoncolornext.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new DialogColor(dto); 	//�� ���ϴ� â�� ���.
				revalidate();
				repaint();
			}

		});
		// ��¥ up �г� ���� ���̾Ʒα�
		timeup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Daycalendar dc = new Daycalendar(timeup);
				timeup.setText(dc.getReturn_str()); 	//��¥ �����ϴ� â�� ��� (1)
			}
		});
		// ��¥ down �г� ���� ���̾Ʒα�
		timedown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Daycalendar dc = new Daycalendar(timedown);
				timedown.setText(dc.getReturn_str()); 	//��¥ �����ϴ� â�� ��� (1)
			}
		});

		// �޸� ��ư Ŭ�� �̺�Ʈ (scrollPanememo ����)
		memo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(e.getClickCount()==1) {
					//scrollPanememo�� ����ִ� �г��� panelmom�� �߰�
					panelmom.add(panelmemoscroll);
					panelmemoscroll.setLayout(new BorderLayout());
					panelmemoscroll.setBorder(new LineBorder(Color.red));
					panelmemoscroll.setBounds(85, 360, 303, 440);
					panelmemoscroll.add(scrollPanememo);
					panelmemoscroll.setOpaque(false);
					//textAreamemo.setOpaque(false);
					
					
					textAreamemo.setText("�޸�");
					textAreamemo.setFont(fontRegular);
					textAreamemo.setForeground(blackgray);
					Border lineBorder = BorderFactory.createLineBorder(blackgray, 3);
					Border emptyBorder = BorderFactory.createEmptyBorder(2, 5, 5, 5);
					textAreamemo.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
					
					//panelmemoscroll : ���� ������°�
					panelmemoscroll.setBorder(null);
					
				} else if(e.getClickCount()==2) {	/*2��Ŭ���� �޸��� ������°� �ȵ�*/
					dto.setMemo(textAreamemo.getText());
					panelmom.remove(panelmemoscroll);
					panelmom.revalidate();
					panelmom.repaint();
				}
				
			}
		});
		// textAreamemo �޸� ������°�
		textAreamemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//���콺 Ŭ���� "�޸�"�϶��� ���ڰ� �����
				if(textAreamemo.getText().equals("�޸�")) textAreamemo.setText("");

			}
		});
		// textFieldtitle ���� ������°�
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//���콺 Ŭ���� "����"�϶��� ���ڰ� �����
				if(title.getText().equals("����")) title.setText("");
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
