package 伺服器;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.sound.sampled.Port;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Server_Window extends JFrame {

	private JPanel contentPane;
	private JTextField portText;
	private JTextArea txt;
	private  boolean turn = false ;
	ServerListener serverListener ;
	public Server_Window() {
		super("聊天伺服器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txt = new JTextArea();
		JScrollPane js = new JScrollPane(txt);
		portText = new JTextField();
		portText.setText("5000");
		portText.setFont(new Font("楷体", Font.PLAIN, 16));
		portText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Port:");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 24));
		
		JButton Cennct = new JButton("開啟服務端");
		Cennct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				serverListener = new ServerListener();
				serverListener.start();
				serverListener.portText(portText.getText());//抓取伺服器輸入的port
				if (turn !=true) {
					turn = true;
					serverListener.turn(turn);
					txt.append("伺服器連結成功"+"\n");
				} else{
					turn = false;
					txt.append("伺服器連線中斷"+"\n");
				} 	
			
			}
		});
		
		Cennct.setFont(new Font("楷体", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1 = new JLabel("連線狀態:");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(portText, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
					.addComponent(Cennct, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
				.addComponent(js, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(portText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(Cennct, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(13)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(js, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void append(String in) {//目的讓其他織成是可以連上txt視窗介面
		txt.append("\n"+in);
	}
}
