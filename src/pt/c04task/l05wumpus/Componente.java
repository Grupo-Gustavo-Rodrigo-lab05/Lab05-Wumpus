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
        if(!caverna.conectaCompSala(coordenadaX, coordenadaY, this)){
            return false;
        }
        return true;
    }

    //Métodos referentes ao Heroi
    public boolean equipaFlecha(){
        return false;
    }
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

    //Métodos referentes ao Wumpus e ao Buraco
    public void geraEfeito(){}

}
