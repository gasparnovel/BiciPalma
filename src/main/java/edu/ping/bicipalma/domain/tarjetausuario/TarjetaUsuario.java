package edu.ping.bicipalma.domain.tarjetausuario;


public class TarjetaUsuario implements Autenticacion {

    private final String id;
    private boolean activada = false;

    public TarjetaUsuario(String id, boolean activada) {
        this.id = id;
        this.activada = activada;
    }

    @Override
    public boolean isActivada() {
        return this.activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id;
    }
}