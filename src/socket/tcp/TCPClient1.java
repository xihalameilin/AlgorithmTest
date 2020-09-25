package socket.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient1 {
    private final static String localAddress = "172.19.126.153";
    private final static int port = 10004;
    public static void main(String[] args) throws Exception {
        System.out.println("TCPClient1 start...");
        Socket client = new Socket();
        InetSocketAddress address = new InetSocketAddress(localAddress,port);
        client.connect(address);
        OutputStream outputStream= client.getOutputStream();
        outputStream.write("hello my name is client1".getBytes());
        client.shutdownOutput();

        InputStream is = client.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        client.close();
    }
}
