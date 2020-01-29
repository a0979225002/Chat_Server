package 伺服器;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatSocket extends Thread {
	Socket socket;
	ServerListener serverListener;
	//將serverlisener的socket連到這裡,要處理socket
	ChatSocket(Socket socket){
		this.socket = socket;
	}
	
	//將資料傳出去
	public void out(String out) {
		try {
			socket.getOutputStream().write(out.getBytes());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			serverListener.server_Window.append(e.toString());
			System.out.println(e.toString());
		}
	}
	
	//將資料接收
	@Override
	public void run() {
		try {
			BufferedReader bf =new BufferedReader(
								new InputStreamReader(
									socket.getInputStream()));
			
			String line;
			while ((line = bf.readLine())!=null) {
				ChatManager.getChatManager().receive(this, line);
			}
		} catch (IOException e) {
			ChatManager.getChatManager().server_Window.append(e.toString());
			
		}
	}
	
	
}
