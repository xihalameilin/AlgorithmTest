package socket.tcp;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
    private final static String localAddress = "172.31.16.128";
    public static void main(String[] args) throws Exception {
        Socket client = new Socket();
        InetSocketAddress address = new InetSocketAddress(localAddress,10001);
        client.connect(address);
        OutputStream outputStream= client.getOutputStream();
        outputStream.write("hello server".getBytes());
        client.close();
    }
}
