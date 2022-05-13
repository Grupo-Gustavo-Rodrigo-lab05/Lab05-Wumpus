package pt.c40task.l05wumpus;

public abstract class Componente {
    protected int coordenadaX, coordenadaY;
    protected Caverna caverna;

    public abstract void setCoordenadas(int coordenadaX, int coordenadaY);
    public abstract void conectaCaverna(Caverna caverna);
    public abstract void solicitaSala();
}
