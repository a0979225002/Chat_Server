package 伺服器;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

import javax.print.attribute.standard.Severity;

public class ServerListener extends Thread {
	int port;// 對外能夠設自己的port
	boolean turn;//要對執行序做開關,可中斷連結功能
	Server_Window server_Window;
	
	// 抓取圖形介面設置的port
	public void portText(String port) {
		this.port = Integer.valueOf(port);
		System.out.println(port);
		
	}
	//抓取window圖形介面判斷的開或關
	public void turn(boolean turn) {
		this.turn = turn;	
	}
	
	// 建立服務端
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (turn) {
				System.out.println(turn);
				Socket socket = serverSocket.accept();
				ChatManager.getChatManager().server_Window.append("客戶端連結成功");
				ChatSocket chatSocket = new ChatSocket(socket);
				chatSocket.start();
				// 得到一個擁有chatSocket的socket 要把所有連線玩家放入陣列內
				ChatManager.getChatManager().getsocket(chatSocket);
			}
			
		}
		catch (IOException e) {
			ChatManager.getChatManager().server_Window.append(e.toString());
			
		}

	}

}
