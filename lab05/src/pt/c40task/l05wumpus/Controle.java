package pt.c40task.l05wumpus;

public class Controle {
    private Componente heroi;

    public void conectaHeroi(Componente heroi) {
        this.heroi = heroi;
    }

    public void acao(char acao) {
        int xDestino = heroi.coordenadaX;
        int yDestino = heroi.coordenadaY;
        if (acao == 'w')
            yDestino--;
        else if (acao == 's')
            yDestino++;
        else if (acao == 'd')
            xDestino++;
        else if (acao == 'a')
            xDestino--;
        if (xDestino <= 3 && xDestino >= 0 && yDestino <= 3 && yDestino >= 0)
            heroi.caverna.movimentaHeroi(xDestino, yDestino, heroi);
    }
}
