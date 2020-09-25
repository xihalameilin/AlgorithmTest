package socket.tcp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception{
        //创建服务端Socket并明确端口号
        ServerSocket serverSocket = new ServerSocket(10000);
        //获取客户端的Socket
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        socket.close();
        serverSocket.close();
    }
}
