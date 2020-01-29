package 客戶端;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatManager {
	private static ChatManager chatManager = new ChatManager();

	public static ChatManager getChatManager() {
		return chatManager;
	}

	Chat_Window chat_Window;

	// 將chat_Window整隻程式添加到這裡讓他能呼叫chat_Window.txt方法
	public void getwindow(Chat_Window chat_Window) {
		this.chat_Window = chat_Window;
	}

	Socket socket;
	String Ip;
	int Port;
	PrintWriter printWriter;
	BufferedReader bfReader;

	public void connect(String ip, String port) {
		this.Ip = ip;
		this.Port = Integer.valueOf(port);
	
			//連上伺服端
			new Thread() {
				@Override
				public void run() {
					
					try {
						socket = new Socket(Ip,Port);
						
						//傳出文字
						printWriter = new PrintWriter(
										new OutputStreamWriter(
												socket.getOutputStream()));
						
						//收到的文字
						bfReader = new BufferedReader(
										new InputStreamReader(
												socket.getInputStream()));
						
						String line;
						
						while ((line = bfReader.readLine())!=null) {
							
							chat_Window.txt(line);
						}
						
						printWriter.close();
						bfReader.close();
						
						printWriter = null;
						bfReader = null;
					} catch (UnknownHostException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}					
				}
			}.start();
	}
	//傳出文字判斷,當printWriter傳不出去時 就會顯示當前連線已中斷
	public void send(String out) {
		if (printWriter!=null) {
			printWriter.write(out+"\n");
			printWriter.flush();
		}else {
			chat_Window.txt("當前連線已中斷.....");
		}
	}

}
