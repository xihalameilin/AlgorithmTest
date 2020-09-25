package socket.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSocket {
    public static void main (String[] args) throws Exception{
        System.out.println("Sender start...");
        DatagramSocket ds = new DatagramSocket();
        String str = "Did you recite words today";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("172.19.126.153");

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,6666);

        ds.send(dp);
        ds.close();
    }
}
