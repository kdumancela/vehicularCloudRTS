import java.io.BufferedReader; 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

public class CCServer {

	static ServerSocket serverSocket;
	static Socket ServerSocket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;
	
	public static int requestFrame()
	{
		JFrame frame = new JFrame();
		frame.setSize(1, 1);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		int result = JOptionPane.showConfirmDialog(frame,"Accept new request?", "Incoming request",JOptionPane.YES_NO_OPTION);
		frame.dispose();
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket (4999);
		boolean running = false;
		
		while(true) {
			ServerSocket = ss.accept();
			
			System.out.println("Client connected");
			InputStreamReader inreader = new InputStreamReader(ServerSocket.getInputStream());
			BufferedReader br = new BufferedReader(inreader);
			
			String tempStr = br.readLine();
			
			PrintWriter ccwriter = new PrintWriter(ServerSocket.getOutputStream());
			
			if (tempStr != null){
				int result = requestFrame();
				if (result == 0) {
					tempStr = "yes";
					if (!running)
					{
						new HomePage().new CloudControllerHome().getCcHome();
						running = true;
					}
					ccwriter.println(tempStr);
				}
				else if (result == 1){
					tempStr = "no";
					ccwriter.println(tempStr);
				}
			}
			else {
				System.out.println("Server malfunction");
			}
			
			System.out.println("Client: "+tempStr);
			
			ccwriter.flush();
		}
	}
	
}
