/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ACER
 */
public class ServerTCP {
    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor = new ServerSocket(12345);
        
        // Recebendo
        Socket conexao = servidor.accept();
        InputStream is = conexao.getInputStream();
        System.out.println("Recebido do Cliente: " + (char)is.read());
        
        // Enviando
        OutputStream enviadoAoCliente = conexao.getOutputStream();
        DataOutputStream dos = new DataOutputStream(enviadoAoCliente);
        dos.write(66); // 66 e igual a letra B em ASC
        
        servidor.close();
        conexao.close();
    }
  
}
