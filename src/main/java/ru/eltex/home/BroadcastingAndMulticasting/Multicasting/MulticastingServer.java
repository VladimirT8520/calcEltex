package ru.eltex.home.BroadcastingAndMulticasting.Multicasting;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Multicasting extends Thread {
    protected MulticastSocket socket = null;
    protected byte[]buf = new byte[256];
    protected InetAddress group = null;

    public Multicasting() throws IOException {
        socket = new MulticastSocket(4446);
        socket.setReuseAddress(true);
        group = InetAddress.getByName("230.0.0.0");
        socket.joinGroup(group);
    }
    public void run() {
        try {


            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(
                        packet.getData(), 0, packet.getLength());
                if ("end".equals(received)) {
                    break;
                }
            }
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}