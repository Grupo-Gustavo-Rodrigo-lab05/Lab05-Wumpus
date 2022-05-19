package pt.c40task.l05wumpus;
import java.util.Random;

public class Componente {
    protected int coordenadaX, coordenadaY;
    protected char tipo;
    protected Caverna caverna;

    public Componente(int coordenadaX, int coordenadaY, char tipo) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.tipo = tipo;
    }
    public void conectaCaverna(Caverna caverna) {
        this.caverna = caverna;
    }
    public boolean solicitaSala() {

        if(!caverna.conectaCompSala(coordenadaX, coordenadaY, this, tipo)){
            return false;
        }
        return true;
    }

    //Heroi
    public void equipaFlecha(){}
    public boolean getTemFlecha(){
        return false;
    }
    public boolean getOuro(){
        return false;
}
    public void capturaOuro(){}
    public boolean getflechaEquipada(){
        return false;
    }
    public boolean usaFlecha(){
        return false;
    }
    //Wumpus e buraco
    public void geraEfeito(){}

}
