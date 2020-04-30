package Semi1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import CalendarUI.CalendarUI;

public class MainUI extends JFrame implements ActionListener {
	
	MemberProc memberProc;
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO;
	JPanel p1, p2, p3;

	JPanel joinpanel;
	JTextField txfid = new JTextField(10);
	JPasswordField pwdfpwd = new JPasswordField();
	JButton btnlogin = new JButton("");
	JButton btnjoin = new JButton("");
	JLabel id_input = new JLabel("");
	JLabel pwd_input = new JLabel("");
	JButton btn_join, btn_cancel;
	
	String str;
	int count=0;
	
	public MainUI() {
		init();
		start();
	}

	private void init() {
	
		p1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				Dimension d = getSize();
				ImageIcon image = new ImageIcon("image\\로그인 사진\\picture.jpg");
				g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
			}
		};
		
		p2 = new JPanel(); // 로그인쪽
		p2.setLayout(null);

		p1.setBounds(0, 0, 1030, 836);
		p2.setBounds(1030, 0, 499, 836);

		btnlogin.setSize(280, 40);
		btnlogin.setLocation(105, 505);
		btnlogin.setContentAreaFilled(false);
		btnlogin.setBorderPainted(false);
		
		btnjoin.setSize(280, 40);
		btnjoin.setLocation(105, 565);
		btnjoin.setOpaque(false);
		btnjoin.setContentAreaFilled(false);
		btnjoin.setBorderPainted(false);
	

		
		txfid.setSize(150, 30);
		txfid.setLocation(170, 360);
		txfid.setOpaque(false);
		txfid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txfid.setForeground(Color.white);
		txfid.setFont(new Font("나눔 고딕", 2, 25));

		pwdfpwd.setSize(150, 30);
		pwdfpwd.setLocation(170, 420);
		pwdfpwd.setOpaque(false);
		pwdfpwd.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pwdfpwd.setForeground(Color.white);
		pwdfpwd.setFont(new Font("나눔 고딕", 2, 25));
		
		id_input.setFont(new Font("나눔 고딕", 2, 25));
		id_input.setBounds(100, 164, 200, 200);
		
		pwd_input.setFont(new Font("나눔 고딕", 2, 25));
		pwd_input.setBounds(75, 213, 200, 200);
		
		p3 = new JPanel() {
			protected void paintComponent(Graphics g) {
				Dimension e = (getSize());
				ImageIcon image = new ImageIcon("image\\로그인 사진\\login.png");
				g.drawImage(image.getImage(), 0, 0, e.width, e.height, this);
			}
		};
		p3.setLayout(null);
		
		p3.add(btnlogin);
		p3.add(btnjoin);
		p3.add(txfid);
		p3.add(pwdfpwd);
		p3.add(id_input);
		p3.add(pwd_input);

		p2.add(p3);
		p3.setBounds(0, 0, 490, 826);
		p3.setVisible(true);
	}

	private void start() {
		btnjoin.addActionListener(this);
		btnlogin.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnjoin) {
			memberProc =  new MemberProc();
			joinpanel = memberProc.getPanel();
			p2.removeAll();
			p2.add(joinpanel);
			joinpanel.setBounds(0, 0,490, 826);
			revalidate();
			repaint();

			btn_join = memberProc.getBtnInsert();
			btn_join.addActionListener(new ActionListener() {
						
				public void actionPerformed(ActionEvent e) {
						memberProc.insertMember();
						p2.removeAll();
						p2.add(p3);
						p3.setBounds(0, 0,490, 826);
						p2.revalidate();						
						p2.repaint();
				}
			});
			
			btn_cancel = memberProc.getBtnCancel();
			btn_cancel.addActionListener(new ActionListener() {
						
				public void actionPerformed(ActionEvent e) {
						p2.removeAll();
						p2.add(p3);
						p3.setBounds(0, 0,490, 826);
						p2.revalidate();						
						p2.repaint();
				}
			});
		}
		else if(e.getSource() == btnlogin) {
			String id = txfid.getText();
			String pwd = pwdfpwd.getText();
			memberDTO = memberDAO.memberLogin(id, pwd);
			
			if(memberDTO.getId() != null) {
				new CalendarUI(memberDTO);
				super.dispose();
				
			} else {
				btnlogin.setEnabled(false);
				JDialog dialog = new JDialog();
				JLabel labelLoginFalse = new JLabel("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
				JButton buttonFalseOk = new JButton("확인");
				
				dialog.setTitle("Error : 로그인실패");
				dialog.setLayout(null);
				dialog.setSize(350, 130);
				dialog.setLocation(830, 250);
				dialog.setVisible(true);
				dialog.add(labelLoginFalse);
				labelLoginFalse.setBounds(40, 0, 270, 40);
				dialog.add(buttonFalseOk);
				buttonFalseOk.setBounds(130, 40, 80, 30);
				// 확인버튼 클릯 시 다이어로그창 종료
				buttonFalseOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e2) {
						btnlogin.setEnabled(true);
						dialog.dispose();
					}
				});						
			}
		}
	}


	public JPanel getP1() {
		return p1;
	}

	public void setP1(JPanel p1) {
		this.p1 = p1;
	}

	public JPanel getP2() {
		return p2;
	}

	public void setP2(JPanel p2) {
		this.p2 = p2;
	}
	
}
