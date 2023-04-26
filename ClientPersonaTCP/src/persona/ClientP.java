package persona;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author bernardi.nicola
 */
public class ClientP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientP client = new ClientP();
        client.start();
    }
    
    public void start() throws IOException, ClassNotFoundException{
        Socket clientSocket = new Socket(InetAddress.getLocalHost(), 50000);
        Scanner sc = new Scanner(System.in);
        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        System.out.println("Inserisci il cognome della persona:");
        String cognome = sc.nextLine();
        System.out.println("Inserisci il nome della persona:");
        String nome = sc.nextLine();
        System.out.println("Inserisci il sesso: (M o F)");
        char sesso = sc.next().toUpperCase().charAt(0);
        System.out.println("Inserisci l'età: ");
        byte eta = sc.nextByte();
        oos.writeObject(new Persona(cognome, nome, sesso, eta));
        oos.flush();
        Persona p = (Persona)ois.readObject();
        System.out.println(p.getNome()+" "+p.getCognome()+" ("+p.getSesso()+") di anni "+p.getEta());
        if(!p.isMaggiorenne())
            System.out.print("Non ");
        System.out.println("è maggiorenne");
    }
}
