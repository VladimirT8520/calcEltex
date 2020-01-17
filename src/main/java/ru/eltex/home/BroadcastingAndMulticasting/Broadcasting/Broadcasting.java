package ru.eltex.home.BroadcastingandMulticasting.Broadcasting;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Broadcasting {
    private static DatagramSocket socket = null;

    public static void main(String[] args) throws IOException {
        broadcast("Hello", InetAddress.getByName("localhost"));
    }

    public static void broadcast(
            String broadcastMessage, InetAddress address) throws IOException {
        socket = new DatagramSocket();
        socket.setBroadcast(true);

        byte[] buffer = broadcastMessage.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4445);
        socket.send(packet);
        socket.close();
    }
}