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

    public boolean brisa(int x, int y) {
        return salas[y][x].getBrisa();
    }

    public boolean fedor(int x, int y) {
        return salas[y][x].getFedor();
    }
    public boolean conectaCompSala(int x, int y, Componente comp_atual) {
        if(!salas[y][x].adicionaComponente(comp_atual)){
            return false;
        }
        return true;
    }

    public void adicionaEfeito(int x, int y, char tipo) {
        if(tipo == 'W')
            salas[y][x].adicionaFedor();
        else
            salas[y][x].adicionaBrisa();
    }

    public void movimentaHeroi(int xDestino, int yDestino, Componente heroi) {
        removeDaSala(heroi.coordenadaX, heroi.coordenadaY, 'P');
        salas[yDestino][xDestino].revelaSala();
        salas[yDestino][xDestino].adicionaComponente(heroi);
        heroi.coordenadaX = xDestino;
        heroi.coordenadaY = yDestino;
    }

    public void removeDaSala(int x, int y, char tipo) {
        salas[y][x].removeComponente(tipo);
    }

    public char getComponenteSala(int x, int y) {
        return salas[y][x].getCompSala().tipo;
    }

    public char[][] getMatriz() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                if (salas[i][j].getCompSala() == null && !salas[i][j].getRevelada())
                    cave[i][j] = '_';
                else if(salas[i][j].getCompSala() == null && salas[i][j].getRevelada()) {
                    if(salas[i][j].getFedor())
                        cave[i][j] = 'f';
                    else if ( salas[i][j].getBrisa())
                        cave[i][j] = 'b';
                    else
                        cave[i][j] = '#';
                }
                else if(!salas[i][j].getRevelada()){
                    cave[i][j] = '_';
                }
                else
                    cave[i][j] = salas[i][j].getCompSala().tipo;
            }
        return cave;
    }
}
