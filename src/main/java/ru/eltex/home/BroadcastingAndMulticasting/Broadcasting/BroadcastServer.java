package ru.eltex.home.BroadcastingAndMulticasting.Broadcasting;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadcastServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(4445);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
        while (true) {
         try{
            datagramSocket.receive(datagramPacket);
            System.out.println("Received from:"+datagramPacket.getAddress()+":"+datagramPacket.getPort());
        }catch (IOException error){
             error.getMessage();
         }
        }
    }
}
