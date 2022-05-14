package pt.c40task.l05wumpus;

public class Caverna {

    private char cave[][] = {{'-', '-', '-', '-'},
                            {'-', '-', '-', '-'},
                            {'-', '-', '-', '-'},
                            {'-', '-', '-', '-'}};
    private Sala[][] salas = new Sala[4][4] ;

    public Caverna(){
        for(int i = 0; i < 4; i++){
            for(int n = 0; n < 4; n++){
                salas[i][n] = new Sala(i, n);
            }
        }
    }
    public void conectaCompSala(int x, int y, Componente comp_atual, char tipo){
        salas[x][y].conectaComponente(comp_atual);
        cave[x][y] = tipo;
    }

    public void adicionaEfeito(int x, int y, char tipo){
        if(tipo == 'W')
            salas[x][y].adicionaFedor();
        else
            salas[x][y].adicionaBrisa();
    }

    public char[][] printaCaverna(){
        return cave;
    }
}
