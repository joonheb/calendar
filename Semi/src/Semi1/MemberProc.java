package Semi1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemberProc extends JFrame implements ActionListener { // 로그인 화면
	
	Image img = null;
	JTextField Idtf, tfName, tfAddr; // 아이디, 이름, 주소
	JTextField tfTel, tfEmail;		 // 전화번호, 이메일
	JPasswordField pfPwd; // 비밀번호
	JTextField tfBirth; // 생년월일(주민앞자리+1)
	JButton btnInsert, btnCancel;// 가입 취소
	JPanel panel;

	public MemberProc()  { // 가입 생성자
		init();				
	}// 생성자

	private void init() {
		
	
		setLayout(null);
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				Dimension z = (getSize());
				ImageIcon image = new ImageIcon("image\\로그인 사진\\joinpage.png");
				g.drawImage(image.getImage(), 0, 0, z.width, z.height, this);
			}
		};		
		panel.setLayout(null);
		panel.setBounds(0, 0, 499,826);
		add(panel);
		
		// 아이디
		Idtf = new JTextField(20);
		Idtf.setSize(300, 30);
		Idtf.setLocation(100, 112);
		Idtf.setOpaque(false);
		Idtf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Idtf.setForeground(Color.white);
		Idtf.setFont(new Font("나눔 고딕", 2, 25));
		
		panel.add(Idtf);

		// 비밀번호
		pfPwd = new JPasswordField(20);
		pfPwd.setSize(300,30);
		pfPwd.setLocation(100,183);
		pfPwd.setOpaque(false);
		pfPwd.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pfPwd.setForeground(Color.white);
		pfPwd.setFont(new Font("나눔 고딕", 2, 25));
		
		panel.add(pfPwd);
		
		// 이름
		tfName = new JTextField(20);
		tfName.setSize(300, 30);
		tfName.setLocation(100, 255);
		tfName.setOpaque(false);
		tfName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfName.setForeground(Color.white);
		tfName.setFont(new Font("나눔 고딕", 2, 25));
		
		panel.add(tfName);
		
		

		// 전화
		tfTel = new JTextField(6);
		tfTel.setOpaque(false);
		tfTel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfTel.setSize(300, 30);
		tfTel.setLocation(100, 330);
		tfTel.setOpaque(false);
		tfTel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfTel.setForeground(Color.white);
		tfTel.setFont(new Font("나눔 고딕", 2, 25));
		
		panel.add(tfTel);		

		// 주소

		tfAddr = new JTextField(20);
		
		tfAddr.setSize(300, 30);
		tfAddr.setLocation(100, 398);
		tfAddr.setOpaque(false);
		tfAddr.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfAddr.setForeground(Color.white);
		tfAddr.setFont(new Font("나눔 고딕", 2, 25));
		
		panel.add(tfAddr);

		
		// 생일
		tfBirth = new JTextField(6);
		tfBirth.setOpaque(false);
		tfBirth.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfBirth.setSize(300, 30);
		tfBirth.setLocation(100, 472);
		tfBirth.setOpaque(false);
		tfBirth.setForeground(Color.white);
		tfBirth.setFont(new Font("나눔 고딕", 2, 25));
		
		panel.add(tfBirth);

		// 이메일
		tfEmail = new JTextField(20);
		tfEmail.setSize(300, 30);
		tfEmail.setLocation(100, 543);
		tfEmail.setOpaque(false);
		tfEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfEmail.setForeground(Color.white);
		tfEmail.setFont(new Font("나눔 고딕", 2, 25));
		
		panel.add(tfEmail);



		// 버튼
		JPanel pButton = new JPanel();
		btnInsert = new JButton("");
		btnCancel = new JButton("");
		pButton.add(btnInsert);
		pButton.add(btnCancel);
		
		btnInsert.setSize(280,40);
		btnInsert.setLocation(105, 755);
		btnInsert.setContentAreaFilled(false);
		btnInsert.setBorderPainted(false);
		
		btnCancel.setSize(80,40);
		btnCancel.setLocation(10, 20);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);

		panel.add(btnInsert);
		panel.add(btnCancel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 

	

	}// init


	@Override
	public void actionPerformed(ActionEvent ae) {
//		if (ae.getSource() == btnInsert) {
//			panel.removeAll();
//			//insertMember();
//			//System.out.println("insertMember() 호출 종료");
//		} else if (ae.getSource() == btnCancel) {
//			panel.removeAll();
//			revalidate();
//			repaint();
//			MemberProc f = new MemberProc();
//		} 
	}// actionPreformed

	public void insertMember() {
		// 화면에서 사용자가 입력한 내용을 얻는다.
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.insertMember(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
			dispose();
		}
	}


	public MemberDTO getViewData() {
		//화면에서 사용자가 입력한 내용을 얻는다.
        MemberDTO dto = new MemberDTO();
        String id = Idtf.getText();
        String pwd = pfPwd.getText();
        String name = tfName.getText();
        String tel = tfTel.getText();
        String addr = tfAddr.getText();
        String birth = tfBirth.getText();
  
        String email = tfEmail.getText();
       
        //dto에 담는다.
        dto.setId(id);
        dto.setPwd(pwd);
        dto.setName(name);
        dto.setTel(tel);
        dto.setAddr(addr);
        dto.setBirth(birth);       
        dto.setEmail(email);
       
       
        return dto;
        
    }
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JButton getBtnInsert() {
		return btnInsert;
	}

	public void setBtnInsert(JButton btnInsert) {
		this.btnInsert = btnInsert;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}
	
}
