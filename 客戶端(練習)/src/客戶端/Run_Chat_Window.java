package 客戶端;

import java.awt.EventQueue;

public class Run_Chat_Window {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat_Window frame = new Chat_Window();
					frame.setVisible(true);
					ChatManager.getChatManager().getwindow(frame);//目的讓ChatManager的文字能添加到圖形介面的txt內
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
