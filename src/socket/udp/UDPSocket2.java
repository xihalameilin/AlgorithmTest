package socket.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSocket2 {
    public static void main(String[] args) {
        try {
            new Thread(() -> {
                try {
                    receive();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ).start();
            send();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void receive() throws Exception{
        System.out.println("UDPSocket2 Receiver start...");
        DatagramSocket ds = new DatagramSocket(7777);

        while(true) {
            byte[] bytes = new byte[1024];

            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);

            String content = new String(dp.getData(), 0, dp.getLength());
            System.out.println(" content: " + content);
        }
    }

    private static void send() throws Exception{
        System.out.println("UDPSocket2 Sender start...");
        DatagramSocket ds = new DatagramSocket();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line = br.readLine())!=null){
            byte[] bytes = line.getBytes();
            InetAddress address = InetAddress.getByName("172.19.126.153");
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,6666);

            ds.send(dp);
        }
    }
}
