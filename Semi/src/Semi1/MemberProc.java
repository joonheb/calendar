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

public class MemberProc extends JFrame implements ActionListener { // �α��� ȭ��
	
	Image img = null;
	JTextField Idtf, tfName, tfAddr; // ���̵�, �̸�, �ּ�
	JTextField tfTel, tfEmail;		 // ��ȭ��ȣ, �̸���
	JPasswordField pfPwd; // ��й�ȣ
	JTextField tfBirth; // �������(�ֹξ��ڸ�+1)
	JButton btnInsert, btnCancel;// ���� ���
	JPanel panel;

	public MemberProc()  { // ���� ������
		init();				
	}// ������

	private void init() {
		
	
		setLayout(null);
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				Dimension z = (getSize());
				ImageIcon image = new ImageIcon("image\\�α��� ����\\joinpage.png");
				g.drawImage(image.getImage(), 0, 0, z.width, z.height, this);
			}
		};		
		panel.setLayout(null);
		panel.setBounds(0, 0, 499,826);
		add(panel);
		
		// ���̵�
		Idtf = new JTextField(20);
		Idtf.setSize(300, 30);
		Idtf.setLocation(100, 112);
		Idtf.setOpaque(false);
		Idtf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Idtf.setForeground(Color.white);
		Idtf.setFont(new Font("���� ���", 2, 25));
		
		panel.add(Idtf);

		// ��й�ȣ
		pfPwd = new JPasswordField(20);
		pfPwd.setSize(300,30);
		pfPwd.setLocation(100,183);
		pfPwd.setOpaque(false);
		pfPwd.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pfPwd.setForeground(Color.white);
		pfPwd.setFont(new Font("���� ���", 2, 25));
		
		panel.add(pfPwd);
		
		// �̸�
		tfName = new JTextField(20);
		tfName.setSize(300, 30);
		tfName.setLocation(100, 255);
		tfName.setOpaque(false);
		tfName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfName.setForeground(Color.white);
		tfName.setFont(new Font("���� ���", 2, 25));
		
		panel.add(tfName);
		
		

		// ��ȭ
		tfTel = new JTextField(6);
		tfTel.setOpaque(false);
		tfTel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfTel.setSize(300, 30);
		tfTel.setLocation(100, 330);
		tfTel.setOpaque(false);
		tfTel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfTel.setForeground(Color.white);
		tfTel.setFont(new Font("���� ���", 2, 25));
		
		panel.add(tfTel);		

		// �ּ�

		tfAddr = new JTextField(20);
		
		tfAddr.setSize(300, 30);
		tfAddr.setLocation(100, 398);
		tfAddr.setOpaque(false);
		tfAddr.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfAddr.setForeground(Color.white);
		tfAddr.setFont(new Font("���� ���", 2, 25));
		
		panel.add(tfAddr);

		
		// ����
		tfBirth = new JTextField(6);
		tfBirth.setOpaque(false);
		tfBirth.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfBirth.setSize(300, 30);
		tfBirth.setLocation(100, 472);
		tfBirth.setOpaque(false);
		tfBirth.setForeground(Color.white);
		tfBirth.setFont(new Font("���� ���", 2, 25));
		
		panel.add(tfBirth);

		// �̸���
		tfEmail = new JTextField(20);
		tfEmail.setSize(300, 30);
		tfEmail.setLocation(100, 543);
		tfEmail.setOpaque(false);
		tfEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tfEmail.setForeground(Color.white);
		tfEmail.setFont(new Font("���� ���", 2, 25));
		
		panel.add(tfEmail);



		// ��ư
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
//			//System.out.println("insertMember() ȣ�� ����");
//		} else if (ae.getSource() == btnCancel) {
//			panel.removeAll();
//			revalidate();
//			repaint();
//			MemberProc f = new MemberProc();
//		} 
	}// actionPreformed

	public void insertMember() {
		// ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.insertMember(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "������ ���������� ó������ �ʾҽ��ϴ�.");
			dispose();
		}
	}


	public MemberDTO getViewData() {
		//ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
        MemberDTO dto = new MemberDTO();
        String id = Idtf.getText();
        String pwd = pfPwd.getText();
        String name = tfName.getText();
        String tel = tfTel.getText();
        String addr = tfAddr.getText();
        String birth = tfBirth.getText();
  
        String email = tfEmail.getText();
       
        //dto�� ��´�.
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
