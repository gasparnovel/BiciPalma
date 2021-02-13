package edu.ping.bicipalma.domain.estacion;

import edu.ping.bicipalma.domain.bicicleta.Movil;
import edu.ping.bicipalma.domain.estacion.*;
import edu.ping.bicipalma.domain.tarjetausuario.*;

public class Estacion {

    /*
     * Inicializamos parametros id= int es el identificador de la estacion,
     * direccion= String y indica la direccion de la estacion, anclajes= Objeto
     * "Anclajes", un array estatico que contiene objetos "Anclaje" que indican el
     * numero de anclajes para moviles de la estacion.
     */

    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    // Constructor de clase "Estacion"
    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    // Getter de "id"
    public int getId() {
        return id;
    }

    // Getter de "direccion"
    public String getDireccion() {
        return direccion;
    }

    // Override del metodo toString() para adaptarlo a nuestras necesidades, en este
    // caso obtener los parametros de Estacion
    @Override
    public String toString() {
        return "id: " + getId() + '\n' + "direccion: " + getDireccion() + '\n' + "numeroAnclajes: " + numAnclajes();
    }

    // Acceso a Anclajes

    private Anclaje[] anclajes() {
        return this.anclajes.anclajes();
    }

    public int numAnclajes() {
        return this.anclajes.numAnclajes();
    }

    // Metodo encargado de printear todos los parametros del objeto "Estacion"
    public void consultarEstacion() {
        System.out.println(this);
    }

    // Metodo encargado de recorrer el array de objetos Anclaje, indicando los que
    // se encuentran "libres"
    public int anclajesLibres() {

        int anclajesLibres = 0;
        for (Anclaje anclaje : anclajes()) {
            if (anclaje.isOcupado() == false) {
                anclajesLibres += 1;
            }
        }
        return anclajesLibres;
    }

    // Metodo encargado de recorrer el array de objetos Anclaje, comprobando y
    // indicando si estos estan libres o no, indicando la bici y su estado
    public void consultarAnclajes() {
        int posicion = 0;
        int numeroAnclaje = 0;

        for (Anclaje anclaje : anclajes()) {
            numeroAnclaje = posicion + 1; // Ya que los array empiezan en posicion 0, y el numero de anclaje en 1
            if (anclaje.isOcupado()) {
                System.out.println("Anclaje" + numeroAnclaje + " " + anclaje.getBici().getId()); // Si es true
            } else {
                System.out.println("Anclaje" + numeroAnclaje + " " + "libre"); // Si es false
            }
            posicion++;
        }
    }

    //Metodo encargado de devolver la información del id de la bicicleta y el anclaje donde se encuentra anclada, en el momento de anclar
    private void mostrarAnclaje(Movil bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta: " + bicicleta.getId() +
                " anclada en el anclaje: " + numeroAnclaje);
    }

    //Metodo encargado de devolver la informacion del id de la bicicleta y el anclaje donde se encuentra anclada, en el momento de retirar
    private void mostrarBicicleta(Movil bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta " + bicicleta.getId() + " retirada" + " del anclaje: " + numeroAnclaje);
    }

    //Metodo encargado de buscar anclajes libres, si es asi, anclar la bicicleta al anclaje libre
    public void anclarBicicleta(Movil bici) {
        int posicion = 0;
        int numeroAnclaje = posicion + 1;

        for (Anclaje anclaje : anclajes()) {
            if (!anclaje.isOcupado()) { //Si el anclaje is not ocupado entonces:
                anclajes.ocuparAnclaje(posicion, bici); //Anclamos la bici
                mostrarAnclaje(bici, numeroAnclaje); //Mostramos la info
                break;
            } else {
                posicion++;
            }
            numeroAnclaje++;
        }
    }

    //Metodo encargado de localizar una posicion de anclaje ocupada para retirar una bicicleta
    public void retirarBicicleta(Autenticacion tarjetausuario) {
        if (leertarjetausuario((tarjetausuario))) {
            boolean biciRetirada = false;   //booleano para
            while (!biciRetirada) {
                int posicion = anclajes.seleccionarAnclaje();
                int numeroAnclaje = posicion + 1;
                if (anclajes.isAnclajeOcupado(posicion)) {
                    mostrarBicicleta(anclajes.getBiciAt(posicion), numeroAnclaje);
                    anclajes.liberarAnclaje(posicion);
                    biciRetirada = true;
                }
            }
        } else {
            System.out.println("\n" + "Tarjeta de usuario inactiva no puedes retirar una bicicleta" + "\n" + "ID de tarjeta: " + tarjetausuario.toString() + "\n"); //Contemplacion para el caso de no tener la tarjeta activa.(activada == false)
        }
    }

    //
    public boolean leertarjetausuario(Autenticacion tarjetausuario) {
        return tarjetausuario.isActivada();
    }

}