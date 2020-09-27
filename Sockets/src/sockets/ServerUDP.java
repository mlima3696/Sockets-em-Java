/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author ACER
 */
public class ServerUDP {
    public static void main(String[] args) {
        
        try {
            DatagramSocket server = new DatagramSocket(12345);
            byte[] receptor = new byte[1024];
            
            DatagramPacket bufferRecebimento = new DatagramPacket(receptor, receptor.length);
            server.receive(bufferRecebimento);
            
            String msg = new String(bufferRecebimento.getData());
            System.out.println(msg);
            
            DatagramPacket bufferEnvio = new DatagramPacket(receptor, receptor.length, bufferRecebimento.getAddress(), bufferRecebimento.getPort());
            server.send(bufferEnvio);

            server.close();
            
        } catch (Exception e) {
        }
        
    }
}
