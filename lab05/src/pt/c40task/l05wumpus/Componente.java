package pt.c40task.l05wumpus;

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

    public void geraEfeito() {
        if(coordenadaX - 1 >= 0)
            caverna.adicionaEfeito(coordenadaX - 1,  coordenadaY, tipo);
        if(coordenadaX + 1 <= 3)
            caverna.adicionaEfeito(coordenadaX + 1, coordenadaY, tipo);
        if(coordenadaY - 1 >= 0)
            caverna.adicionaEfeito(coordenadaX, coordenadaY - 1, tipo);
        if(coordenadaY + 1 <= 3)
            caverna.adicionaEfeito(coordenadaX, coordenadaY + 1, tipo);
    }
}
