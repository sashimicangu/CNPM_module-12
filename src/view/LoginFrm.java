package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import model.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField usernameTf;
	private JLabel passwordLabel;
	private JTextField passwordTf;
	private JButton submitBtn;

	/**
	 * Create the frame.
	 */
	public LoginFrm() {
		setTitle("Chương trình quản lý sân bóng mini");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginTitleLabel = new JLabel("Đăng nhập");
		loginTitleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		loginTitleLabel.setBounds(187, 16, 85, 32);
		contentPane.add(loginTitleLabel);
		
		usernameTf = new JTextField();
		usernameTf.setBounds(133, 84, 187, 29);
		contentPane.add(usernameTf);
		usernameTf.setColumns(10);
		
		submitBtn = new JButton("Đăng nhập");
		submitBtn.setBounds(163, 196, 131, 40);
		contentPane.add(submitBtn);
		
		JLabel usernameLabel = new JLabel("Tên đăng nhập");
		usernameLabel.setBounds(136, 65, 93, 16);
		contentPane.add(usernameLabel);
		
		passwordLabel = new JLabel("Mật khẩu");
		passwordLabel.setBounds(137, 125, 58, 16);
		contentPane.add(passwordLabel);
		
		passwordTf = new JPasswordField();
		passwordTf.setBounds(133, 141, 187, 29);
		contentPane.add(passwordTf);
		
//		// Action listener
		submitBtn.addActionListener(this);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() instanceof JButton) && (((JButton)e.getSource()).equals(submitBtn))) {
			User aUser = new User();
			aUser.setUsername(usernameTf.getText());
			aUser.setPassword(passwordTf.getText());
			
			UserDAO ud = new UserDAO();
			if (ud.checkLogin(aUser)) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Đăng nhập thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
