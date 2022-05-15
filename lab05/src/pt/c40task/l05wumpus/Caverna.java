package pt.c40task.l05wumpus;

public class Caverna {

    private char cave[][] = {{'-', '-', '-', '-'},
                            {'-', '-', '-', '-'},
                            {'-', '-', '-', '-'},
                            {'-', '-', '-', '-'}};
    private Sala[][] salas;

    public Caverna() {
        salas = new Sala[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                salas[i][j] = new Sala(i, j);
            }
        }
    }
    public void conectaCompSala(int x, int y, Componente comp_atual, char tipo) {
        salas[y][x].conectaComponente(comp_atual);
    }

    public void adicionaEfeito(int x, int y, char tipo) {
        if(tipo == 'W')
            salas[y][x].adicionaFedor();
        else
            salas[y][x].adicionaBrisa();
    }

    public void movimentaHeroi(int xDestino, int yDestino, Componente heroi) {
        salas[heroi.coordenadaY][heroi.coordenadaX].conectaComponente(null);
        salas[yDestino][xDestino].conectaComponente(heroi);
        heroi.coordenadaX = xDestino;
        heroi.coordenadaY = yDestino;
    }

    public char[][] getMatriz() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                if (salas[i][j].getCompSala() == null)
                    cave[i][j] = '_';
                else
                    cave[i][j] = salas[i][j].getCompSala().tipo;
            }
        return cave;
    }
}
