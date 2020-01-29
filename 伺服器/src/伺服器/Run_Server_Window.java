package 伺服器;

import java.awt.EventQueue;

public class Run_Server_Window {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_Window frame = new Server_Window();
					frame.setVisible(true);
					ChatManager.getChatManager().getwindow(frame);//讓ChatManager連結txt介面
				} catch (Exception e) {
					ChatManager.getChatManager().server_Window.append(e.toString());
				}
			}
		});
	}
}
