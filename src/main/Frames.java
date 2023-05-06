package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.SQLConnection;

public class Frames {

	private JPanel loginPanel = new JPanel();
	private JPanel registerPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	
	public void openLoginPanel(JFrame frame) {
		
        loginPanel.setBounds(0, 0, 800, 600);
        loginPanel.setBackground(Color.GRAY);
        loginPanel.setLayout(null);
        
        JLabel loginLabel = new JLabel("Giriş Yap!");
        loginLabel.setBackground(new Color(128, 128, 128));
        loginLabel.setFont(new Font("Calibri", Font.BOLD, 32));
        loginLabel.setBounds(365, 35, 138, 87);
        
        JLabel loginIcon = new JLabel("");
        loginIcon.setIcon(new ImageIcon("C:\\Users\\Mert\\Desktop\\work-space\\UserManager\\res\\regIcon.png"));
        loginIcon.setBounds(300, 24, 73, 87);
        
        JLabel nameLabel = new JLabel("Kullanıcı Adı Girin:");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        nameLabel.setBounds(242, 125, 345, 36);
        
        textField = new JTextField();
        textField.setFont(new Font("Calibri", Font.ITALIC, 28));
        textField.setBounds(242, 175, 325, 75);
        textField.setColumns(10);
        
        JLabel passwordLabel = new JLabel("Şifre Girin:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        passwordLabel.setBounds(240, 270, 208, 52);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Calibri", Font.ITALIC, 26));
        passwordField.setBounds(242, 325, 325, 75);
        
        JLabel signLabel = new JLabel("Hemen şimdi kayıt ol!");
        signLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        signLabel.setForeground(Color.blue);
        signLabel.setBounds(290, 515, 200, 30);
        
        signLabel.addMouseListener(new MouseAdapter() {
        	
        	@Override
            public void mouseClicked(MouseEvent e) {
        		if(e.getButton() == MouseEvent.BUTTON1) {
        			frame.getContentPane().remove(loginPanel);
        			openRegisterPanel(Main.getFrame());
        			frame.revalidate();
        	        frame.repaint();
        		}
            }
        	
        	@Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == signLabel) {
                	signLabel.setForeground(Color.RED);
                }
            }
        	
            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == signLabel) {
                    signLabel.setForeground(Color.BLUE);
                }
            }
        	
		});
        
        
        JButton confirmRegButton = new JButton("Giriş");
        confirmRegButton.setIcon(new ImageIcon("C:\\Users\\Mert\\Desktop\\work-space\\UserManager\\res\\buttonIcon.png"));
        confirmRegButton.setBackground(Color.WHITE);
        confirmRegButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        confirmRegButton.setBounds(290, 430, 208, 72);
        confirmRegButton.setFocusable(false);
        
        confirmRegButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent action) {
        		
        		
        		String userName = textField.getText();
        		char[] passwordCharacters = passwordField.getPassword();
        		String password = new String(passwordCharacters);
        		
        		if(password.contains(" ") || userName.contains(" ")) {
                    JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre yanlış!", "Hata", JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        		
        		try {
                    String query = "SELECT * FROM users WHERE USER_NAME = '" + userName + "' AND PASSWORD = '" + password + "'";
        			Statement stmt = SQLConnection.getConnection().createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Giriş başarılı!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                        passwordField.setText("");
                        textField.setText("");
                        userName = null;
                        password = null;
                    } else {
                        JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre yanlış!", "Hata", JOptionPane.ERROR_MESSAGE);
                    }

        		} catch(SQLException ex) {
        			ex.printStackTrace();
        		}
        		
        	}
        });
        
        loginPanel.add(signLabel);
        loginPanel.add(confirmRegButton);
        loginPanel.add(loginLabel);
        loginPanel.add(loginIcon);
        loginPanel.add(nameLabel);
        loginPanel.add(textField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        
        frame.add(loginPanel);
        
	}
	
	public void openRegisterPanel(JFrame frame) {
		JLabel regLabel = new JLabel("Kayıt Ol!");
        regLabel.setBackground(new Color(128, 128, 128));
        regLabel.setFont(new Font("Calibri", Font.BOLD, 32));
        regLabel.setBounds(365, 11, 138, 87);
        
        JLabel regIcon = new JLabel("");
        regIcon.setIcon(new ImageIcon("C:\\Users\\Mert\\Desktop\\work-space\\UserManager\\res\\regIcon.png"));
        regIcon.setBounds(300, 0, 73, 87);
        
        JLabel lblNewLabel = new JLabel("Kullanıcı Adı Oluşturun:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(242, 83, 345, 36);
        
        textField = new JTextField();
        textField.setFont(new Font("Calibri", Font.ITALIC, 28));
        textField.setBounds(242, 119, 325, 75);
        textField.setColumns(10);
        
        JLabel passwordLabel = new JLabel("Şifre Oluşturun:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        passwordLabel.setBounds(242, 203, 208, 52);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Calibri", Font.ITALIC, 26));
        passwordField.setBounds(242, 247, 325, 75);
        
        JLabel confirmPasswordLabel = new JLabel("Şifrenizi Onaylayın:");
        confirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        confirmPasswordLabel.setBounds(242, 332, 325, 52);
        
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Calibri", Font.ITALIC, 26));
        confirmPasswordField.setBounds(242, 381, 325, 75);
        
        JLabel signLabel = new JLabel("Hemen şimdi giriş yap!");
        signLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        signLabel.setForeground(Color.blue);
        signLabel.setBounds(40, -20, 250, 75);
        
        signLabel.addMouseListener(new MouseAdapter() {
        	
        	@Override
            public void mouseClicked(MouseEvent e) {
        		if(e.getButton() == MouseEvent.BUTTON1) {
        			frame.getContentPane().remove(registerPanel);
        		    openLoginPanel(Main.getFrame());
        		    frame.revalidate();
        	        frame.repaint();
        		}
            }
        	
        	@Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == signLabel) {
                	signLabel.setForeground(Color.RED);
                }
            }
        	
            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == signLabel) {
                    signLabel.setForeground(Color.BLUE);
                }
            }
        	
		});
        
        JButton confirmRegButton = new JButton("Onayla");
        confirmRegButton.setIcon(new ImageIcon("C:\\Users\\Mert\\Desktop\\work-space\\UserManager\\res\\buttonIcon.png"));
        confirmRegButton.setBackground(Color.WHITE);
        confirmRegButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        confirmRegButton.setBounds(300, 467, 208, 72);
        confirmRegButton.setFocusable(false);
        
        confirmRegButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String userName = textField.getText();
				char[] password = passwordField.getPassword();
				LocalDate currentDate = LocalDate.now();
				
				char[] confirmPassword = confirmPasswordField.getPassword();
				
				String password1 = String.valueOf(passwordField.getPassword());
				String password2 = String.valueOf(confirmPasswordField.getPassword());
				
				if(password1.contains(" ") || password2.contains(" ") || (password1.contains(" ") && password2.contains(" "))) {
					JOptionPane.showMessageDialog(null, "Şifren boşluk içermemeli!", "Hata", JOptionPane.ERROR_MESSAGE);

					return;
				}
				
				if(password.length < 6 || (confirmPassword.length < 6 && password.length < 6)) {
					JOptionPane.showMessageDialog(null, "Şifre 6 karakterden uzun olmalı!", "Hata", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(password == null || confirmPassword == null) {
					JOptionPane.showMessageDialog(null, "Şifre kutusu boş olmamalı!", "Hata", JOptionPane.ERROR_MESSAGE);

					return;
				}
				
				if(!Arrays.equals(password, confirmPassword)) {
					JOptionPane.showMessageDialog(null, "Şifre Hatalı!", "Hata", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					Statement stmt = SQLConnection.getConnection().createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE USER_NAME = '" + userName + "'");
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Böyle bir kullanıcı adı zaten bulunuyor!", "Hata", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String query = "INSERT INTO users (USER_NAME, PASSWORD, DATE) VALUES ('" + userName + "', '" + password1 + "', '" + currentDate + "')";
					stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Başarıyla kayıt oldun!", "Tebrikler!", JOptionPane.INFORMATION_MESSAGE);
				    userName = null;
				    password = null;
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
        
        
        registerPanel.setBounds(0, 0, 800, 600);
        registerPanel.setBackground(Color.GRAY);
        registerPanel.setLayout(null);
        
        registerPanel.add(signLabel);
        registerPanel.add(regIcon);
        registerPanel.add(regLabel);
        registerPanel.add(lblNewLabel);
        registerPanel.add(textField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(confirmPasswordLabel);
        registerPanel.add(confirmPasswordField);
        registerPanel.add(confirmRegButton);
        
        frame.add(registerPanel);
	}

}
