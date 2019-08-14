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

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import sun.applet.Main;

class Server extends Thread {
	private static int server_port = 6678;
	private static ServerSocket serverSocket =null;
	private static int count_client = 0;
	 
	// �ŧiClientInfo�}�C�H�����q�D�{���ǨӪ��Ȥ��ư}�C
	ArrayList<ClientInfo> clientInfos = new ArrayList<ClientInfo>();
	ArrayList<AssignResult> assignResults = new ArrayList<AssignResult>();
	public Server() {
	}
	// ��l�Ʈɨ��o�Ȥ��ư}�C�A�ǳƩ�䤤�W�[�����s�u���Ȥ���
	public Server(ArrayList<ClientInfo> clientInfos, ArrayList<AssignResult> assignResults) {
		this.clientInfos= clientInfos;
		this.assignResults = assignResults;
	}
	
	public void run(){
        System.out.println("Hello World in MyThread");
        // Server server = new Server();
		listening();
    }
	
	public void listening() {
		// ���ǳƫإ߳s�u�i�ӫ᪺�����
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		
		try {			
			serverSocket = new ServerSocket(server_port);
			System.out.println("���ݳs�u��..."); 
			// �}�l���� android �s�u
			while(true) {
				Socket socket = serverSocket.accept();
				// ���s�u�i�ӫh�}�ҷs�� thread �÷ǳư������B�z
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
                	System.out.println("���F?");
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
			// TODO �۰ʲ��ͪ��غc�l Stub
			this.clientSocket = clientSocket;
		}
		
		
		@Override
		public void run() {
			// TODO �۰ʲ��ͪ���k Stub
			System.out.printf("�q%s���s�u�i��!\n", clientSocket.getRemoteSocketAddress() );
			DataOutputStream output = null;
            DataInputStream input = null;
            try {
            	/// ��J
            	input = new DataInputStream(this.clientSocket.getInputStream());
            	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            	String response ="";
                String line ="";

                while ((line = bufferedReader.readLine()) != null){
                    response = response + line;
                }
                this.clientSocket.isInputShutdown();
                // System.out.println(response);
                JSONObject jsonResponse = new JSONObject(response);
                System.out.println(jsonResponse);
                
                ClientInfo clientRequest = new ClientInfo(jsonResponse.getInt("request_No"));
                if (clientRequest.getRequestNo() == 0) {
                	clientRequest.setContainerSpec(
                			jsonResponse.getInt("price"), 
                			jsonResponse.getInt("size"), 
                			jsonResponse.getDouble("weight"), 
                			jsonResponse.getString("cargo_content"));
                	clientRequest.setLatLng(
                			jsonResponse.getDouble("sender_lng"), 
                			jsonResponse.getDouble("sender_lat"), 
                			jsonResponse.getDouble("receiver_lng"), 
                			jsonResponse.getDouble("receiver_lat"));
                	clientRequest.setSenderId(jsonResponse.getString("sender_id"));
                	clientRequest.setReceiverId(jsonResponse.getString("receiver_id"));
                	clientRequest.setTimeArrived(jsonResponse.getInt("time_arrived"));
                	clientRequest.setContainerNo(jsonResponse.getString("container_id"));
                }
                // �|������
                else if (clientRequest.getRequestNo() == 1) {
                	clientRequest.setContainerSpec(
                			jsonResponse.getInt("price"), 
                			jsonResponse.getInt("size"), 
                			jsonResponse.getDouble("weight"), 
                			jsonResponse.getString("cargo_content"));
                	clientRequest.setLatLng(
                			jsonResponse.getDouble("sender_lng"), 
                			jsonResponse.getDouble("sender_lat"), 
                			jsonResponse.getDouble("receiver_lng"), 
                			jsonResponse.getDouble("receiver_lat"));
                	clientRequest.setSenderId(jsonResponse.getString("sender_id"));
                	clientRequest.setReceiverId(jsonResponse.getString("receiver_id"));
                	clientRequest.setTimeArrived(jsonResponse.getInt("time_arrived"));
                	clientRequest.setContainerNo(jsonResponse.getString("container_id"));
                	
                	clientRequest.setTruckNo(jsonResponse.getString("truck_id"));
                	clientRequest.setOrderNo(jsonResponse.getString("order_No"));
                }
                clientInfos.add(clientRequest);
                AssignResult assignResult = new AssignResult();
                assignResults.add(assignResult);
                
                /// ��X
                output = new DataOutputStream(this.clientSocket.getOutputStream());
                
                System.out.println(assignResult.getResult());
                //Thread.sleep(3000);
                synchronized(assignResult) {
                	 assignResult.wait();
                }        
                int assign_condition = assignResult.getResult();
                System.out.println(assign_condition);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
            	bufferedWriter.write(Integer.toString(assign_condition));
                //bufferedWriter.write(assign_condition);
            	bufferedWriter.flush();
            	bufferedWriter.close();
            	input.close();
            	output.close();
            	this.clientSocket.close();
          
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
