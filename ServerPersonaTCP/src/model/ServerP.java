package model;

import java.io.*;
import java.net.*;
import java.util.Set;
import persona.Persona;

/**
 *
 * @author bernardi.nicola
 */
public class ServerP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket sSocket = new ServerSocket(50000);
        while(true){
            Socket clientSocket = sSocket.accept();
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

            Persona p = (Persona)ois.readObject();
            System.out.println(p.getCognome()+" "+p.getNome()+" ("+p.getSesso()+") età: "+p.getEta());
            if(p.getEta()>=18)
                p.setMaggiorenne(true);
            else
                p.setMaggiorenne(false);
            oos.writeObject(p);
            oos.flush();
        }
    }
}
