/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class ClientTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte[] data = null;
        
        try {
            
            Socket client = new Socket("127.0.0.1",12345);
            
            // Enviando
            OutputStream enviaAoSevidor=client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(enviaAoSevidor);
            dos.write(65); // 65 igual a A em ASC
            
            // Recebendo
            InputStream is = client.getInputStream();
            System.out.println("Recebido do Servidor: " + (char)is.read());
            
            client.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            System.out.println(e);
        }
    }
    
}
