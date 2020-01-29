package 客戶端;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Chat_Window extends JFrame {

	private JPanel contentPane;
	private JTextField ip;
	private JTextField port;
	private JTextField name;
	private JTextField txtsend;
	private JTextArea txt;

	public Chat_Window() {
		super("客戶端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txt = new JTextArea();
		txt.setFont(new Font("楷体", Font.PLAIN, 16));
		JScrollPane js = new JScrollPane(txt);
		
		JLabel lblNewLabel = new JLabel("IP:");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 24));
		
		ip = new JTextField();
		ip.setFont(new Font("楷体", Font.PLAIN, 14));
		ip.setText("127.0.0.1");
		ip.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Port:");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 24));
		
		port = new JTextField();
		port.setFont(new Font("楷体", Font.PLAIN, 14));
		port.setText("5000");
		port.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("姓名:");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 24));
		
		name = new JTextField();
		name.setFont(new Font("楷体", Font.PLAIN, 14));
		name.setText("匿名");
		name.setColumns(10);
		
		JButton connect = new JButton("連線伺服器");
		connect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ChatManager.getChatManager().connect(ip.getText(), port.getText());
			}
		});
		connect.setFont(new Font("楷体", Font.PLAIN, 24));
		
		txtsend = new JTextField();
		txtsend.setFont(new Font("楷体", Font.PLAIN, 16));
		txtsend.setColumns(10);
		
		JButton send = new JButton("發送");
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ChatManager.getChatManager().send(name.getText()+":"+txtsend.getText());
				txt.append(name.getText()+":"+txtsend.getText()+"\n");
				txtsend.setText("");
			}
		});
		send.setFont(new Font("楷体", Font.PLAIN, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(js, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ip, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(port, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(connect))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtsend, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(send, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(port, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(connect))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(js, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(send, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtsend, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//讓ChatManager的文字能添加到txt內
	public void txt(String in) {
		txt.append(in+"\n");
	}
}
