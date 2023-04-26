package persona;

import java.io.Serializable;

/**
 *
 * @author bernardi.nicola
 */
public class Persona implements Serializable {
    private String cognome;
    private String nome;
    private char sesso;
    private byte eta;
    private boolean maggiorenne;

    public Persona(String cognome, String nome, char sesso, byte eta) {
        this.cognome = cognome;
        this.nome = nome;
        this.sesso = sesso;
        this.eta = eta;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public char getSesso() {
        return sesso;
    }

    public byte getEta() {
        return eta;
    }

    public boolean isMaggiorenne() {
        return maggiorenne;
    }

    public void setMaggiorenne(boolean maggiorenne) {
        this.maggiorenne = maggiorenne;
    }
}
