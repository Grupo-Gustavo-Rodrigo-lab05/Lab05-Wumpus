package pt.c40task.l05wumpus;

public class Buraco extends Componente{


    @Override
    public void setCoordenadas(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    @Override
    public void conectaCaverna(Caverna caverna) {
        this.caverna = caverna;

    }

    public void SolicitaSala(){
        caverna.ConectaCompSala(coordenadaX, coordenadaY, this, 'B');
    }
}
