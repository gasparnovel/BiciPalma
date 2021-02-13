package edu.ping.bicipalma.domain.estacion;

import edu.ping.bicipalma.domain.estacion.*;
import edu.ping.bicipalma.domain.bicicleta.*;
import edu.ping.bicipalma.domain.tarjetausuario.*;



public class Anclaje {

    //Inicializadores, bici implementa la interfaz Movil
    private boolean ocupado = false;
    private Movil bici;

    //Constructor
    public Anclaje() {
    }

    //Constructor alternativo para poder testear los metodos siguientes(isOcupado,getBici,anclarBici)

    public Anclaje(boolean ocupado, Movil bici) {
        this.ocupado = ocupado;
        this.bici = bici;
    }


    //Getter del parametro booleano "ocupado"
    public boolean isOcupado() {
        return this.ocupado;
    }

    //Getter de bici que implementa la interfaz Movil
    public Movil getBici() {
        return this.bici;
    }

    //Metodo para anclar bici, al implementar la interfaz movil se la pasamos al metodo, ocupado queda en true
    public void anclarBici(Movil bici) {
        this.bici = bici;
        this.ocupado = true;
    }

    //Metodo para liberar la bici, al implementar la interfaz movil se la pasamos al metodo, ocupado queda en false
    public void liberarBici() {
        this.bici = null;
        this.ocupado = false;
    }

    //Overrride del metodo toString() adaptado para devolver el estado del anclaje (ocupado = true or ocupado = false )
    @Override
    public String toString() {
        return "ocupada: " + isOcupado();
    }

}