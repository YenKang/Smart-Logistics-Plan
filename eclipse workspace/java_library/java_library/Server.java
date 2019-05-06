import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

class Server extends Thread {
	private static int server_port = 6678;
	private static ServerSocket serverSocket =null;
	private static int count_client = 0;
	 
	// 宣告ClientInfo陣列以接收從主程式傳來的客戶資料陣列
	ArrayList<ClientInfo> clientInfos = new ArrayList<ClientInfo>();
	
	// 初始化時取得客戶資料陣列
	public Server(ArrayList<ClientInfo> clientInfos) {
		this.clientInfos= clientInfos;
	}
	
	public void run(){
        System.out.println("Hello World in MyThread");
        //Server server = new Server();
		listening();
    }
	
	public void listening() {
		// 先準備建立連線進來後的執行緒
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		
		try {			
			serverSocket = new ServerSocket(server_port);
			System.out.println("等待連線中..."); 
			while(true) {
				Socket socket = serverSocket.accept();
				threadExecutor.execute(new RequestThread(socket));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if ( threadExecutor != null )
                threadExecutor.shutdown();
            if ( serverSocket != null ) {
                try{
                	System.out.println("關了?");
                    serverSocket.close();
                }
                catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
		}
	}
	
	class RequestThread implements Runnable {
		
		private Socket clientSocket;
		
		public  RequestThread (Socket clientSocket) {
			// TODO 自動產生的建構子 Stub
			this.clientSocket = clientSocket;
		}
		
		
		@Override
		public void run() {
			// TODO 自動產生的方法 Stub
			System.out.printf("從%s有連線進來!\n", clientSocket.getRemoteSocketAddress() );
			DataOutputStream output = null;
            DataInputStream input = null;
            try {
            	/// 輸入
            	input = new DataInputStream(this.clientSocket.getInputStream());
            	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            	String response ="";
                String line ="";

                while ((line = bufferedReader.readLine()) != null){
                    response = response + line;
                }
                this.clientSocket.isInputShutdown();
                System.out.println(response);
                JSONObject jsonResponse = new JSONObject(response);
                System.out.println(jsonResponse.get("sender_lng"));
                System.out.println(jsonResponse.get("sender_lat"));
                
                
                ClientInfo a = new ClientInfo((double)jsonResponse.get("sender_lng"),
                		(double)jsonResponse.get("sender_lat"),
                		(double)jsonResponse.get("sender_lng"),
                		(double)jsonResponse.get("sender_lat"));
                clientInfos.add(a);
    			
    			
                /// 輸出
                output = new DataOutputStream(this.clientSocket.getOutputStream());
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
               
            	bufferedWriter.write("YOYOYOYo"+"\n");
            	bufferedWriter.flush();
            	bufferedWriter.close();
          
                /*JSONObject jsonResponse = new JSONObject(responseFromSocket);
            	System.out.println(jsonResponse.get("FFW"));*/
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
            finally 
            {
                try
                {
                    if ( input != null )
                        input.close();
                    if ( output != null )
                        output.close();
                    if ( this.clientSocket != null && !this.clientSocket.isClosed() )
                        this.clientSocket.close();
                }
                catch ( IOException e )
                {
                	System.out.println(999999);
                    e.printStackTrace();
                }
            }
		}
	}
}
