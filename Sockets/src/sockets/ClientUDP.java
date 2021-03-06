/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author ACER
 */
public class ClientUDP {
    public static void main(String[] args) {
        
        String mensagem = "Solicito o ip do servidor";
        byte[] data = mensagem.getBytes();
        int porta = 12345;
        String ip = "255.255.255.255";
        
        try {
            DatagramSocket client = new DatagramSocket();
            InetAddress ina = InetAddress.getByName(ip);
            DatagramPacket enviando = new DatagramPacket(data, data.length, ina, porta);
            client.send(enviando);
            
            byte[] receive = new byte[1024];
            DatagramPacket recebendo = new DatagramPacket(receive,receive.length,ina, porta);
            client.receive(recebendo);
            
            String ipServidor = recebendo.getAddress().toString();
            System.out.println("ip do servidor: " + ipServidor);
            client.close();
            
        } catch (Exception e) {
        }
        
    }
}
