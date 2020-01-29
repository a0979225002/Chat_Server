package 伺服器;

import java.util.Vector;

public class ChatManager {

	//目的實作單一窗口
	private static ChatManager chatManager = new ChatManager();
	public static ChatManager getChatManager() {
		return chatManager;
	}
	
	Server_Window server_Window;//目的讓全部程式可連上圖形介面的txt
	
	public void getwindow(Server_Window server_Window) {
		this.server_Window = server_Window;
	}
	
	
	//將連線的每個客戶端丟進陣列
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	//將serverlistener內實作的ChatSocket內的socket加入到這裡 為了要放入陣列
	public void getsocket(ChatSocket cs) {
		vector.add(cs);
	}
	
	//讀出陣列的資料,發布給其他客戶端
	public void receive(ChatSocket cs,String line) {
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket chat = vector.get(i);
			//如果如果客戶端是發送者的話就只有該客戶端不傳資料,其他客戶端會收到
			
			if (!cs.equals(chat)) {
				chat.out(line+"\n");
			}
		}
	}
}
