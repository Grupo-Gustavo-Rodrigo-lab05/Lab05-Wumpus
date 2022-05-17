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
    public void solicitaSala() {
        caverna.conectaCompSala(coordenadaX, coordenadaY, this, tipo);
    }

    //passar pro wumpus e buraco depois//


}
