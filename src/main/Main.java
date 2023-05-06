package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.SQLConnection;

import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Main {
	
	public static JFrame frame = new JFrame();

	public static void main(String[] args) {
		try {
			SQLConnection db = new SQLConnection();
			Main main = new Main();
			main.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Main() {
		frame.setTitle("Kullanıcı Giriş/Çıkış");
		ImageIcon icon = new ImageIcon("img/frameIcon.png");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mert\\Desktop\\work-space\\UserManager\\res\\frameIcon.png"));
		
		frame.setResizable(false);
		frame.setSize(800,600);
		frame.getContentPane().setLayout(null);
        
        Frames frames = new Frames();
        frames.openLoginPanel(frame);
       
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
}
