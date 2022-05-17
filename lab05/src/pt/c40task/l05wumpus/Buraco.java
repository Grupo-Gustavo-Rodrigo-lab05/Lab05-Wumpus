package pt.c40task.l05wumpus;

public class Buraco extends Componente {

    public Buraco(int coordenadaX, int coordenadaY, char tipo) {
        super(coordenadaX, coordenadaY, tipo);
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
