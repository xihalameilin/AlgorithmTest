package socket.tcp;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
    private final static int port = 10004;
    public static void main(String[] args)throws Exception {
        receive();
    }

    private static void receive() throws Exception{
        System.out.println("TCPServer start...");
        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            final Socket socket = serverSocket.accept();
            new Thread(()->{
                try {
                    InputStream is = socket.getInputStream();

                    byte[] bytes = new byte[1024];
                    int len = is.read(bytes);
                    System.out.println(new String(bytes, 0, len));

                    OutputStream os = socket.getOutputStream();
                    os.write(new String(bytes, 0, len).getBytes());
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            ).start();

        }
    }
}
