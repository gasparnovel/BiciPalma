package edu.ping.bicipalma.domain.estacion;

import edu.ping.bicipalma.domain.estacion.*;
import edu.ping.bicipalma.domain.bicicleta.*;
import edu.ping.bicipalma.domain.tarjetausuario.*;

import java.util.concurrent.ThreadLocalRandom;

class Anclajes {

    //Inicializamos un array que contiene objeto "Anclaje"
    private final Anclaje[] anclajes;

    //Constructor al cual le pasamos el numero de anclajes, y crea el array de objetos "Anclaje"
    public Anclajes(int numAnclajes) {
        this.anclajes = new Anclaje[numAnclajes];
        crearAnclajes();
    }

    //Metodo encargado de crear objetos "Anclaje" a partir de la longitud de anclajes
    private void crearAnclajes() {
        for (int i = 0; i < anclajes.length; i++) {
            this.anclajes[i] = new Anclaje();
        }
    }

    // anclajes() => getAnclajes() getter
    Anclaje[] anclajes() {
        return this.anclajes;
    }

    //Metodo encargado de devolver la cantidad de anclajes a partir de su longitud
    int numAnclajes() {
        return anclajes.length;
    }

    //Metodo encargado de ocupar un Anclaje pasandole la posicion y la bici implementando la interfaz Movil
    void ocuparAnclaje(int posicion, Movil bici) {
        this.anclajes[posicion].anclarBici(bici);
    }

    //Metodo encargado de generar un numero aleatoria entre 0 y el numero total de Anclajes.
    int seleccionarAnclaje() {
        return ThreadLocalRandom.current().nextInt(0, numAnclajes());
    }

    //Metodo encargado de comprobar a partir de una posicion si el anclaje esta ocupado
    boolean isAnclajeOcupado(int posicion) {
        return this.anclajes[posicion].isOcupado();
    }

    //Metodo encargado de devolver el objeto bici en la posición indicada
    Movil getBiciAt(int posicion) {
        return this.anclajes[posicion].getBici();
    }

    void liberarAnclaje(int posicion) {
        this.anclajes[posicion].liberarBici();
    }
}