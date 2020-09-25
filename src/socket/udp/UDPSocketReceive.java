package socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSocketReceive {
    public static void main(String[] args)throws Exception {
        System.out.println("Receiver start...");
        DatagramSocket ds = new DatagramSocket(6666);

        byte[] bytes = new byte[1024];

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        ds.receive(dp);

        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        String content = new String(dp.getData(),0,dp.getLength());
        System.out.println("address :"+address+" port: "+ port +" content: " + content);
        ds.close();
    }
}
