package edu.ping.bicipalma.domain.bicicleta;

public class Bicicleta implements Movil {

    //Inicializamos
    private final int id;

    //Constructor
    public Bicicleta(int id) {
        this.id = id;
    }

    //Getter id
    public int getId() {
        return id;
    }

    //Override de metodo toString()
    @Override
    public String toString() {
        return Integer.toString(getId());
    }
}