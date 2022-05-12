package pt.c40task.l05wumpus;

public class Caverna {

    private char cave[][] = {{'-', '-', '-', '-'},
                        {'-', '-', '-', '-'},
                        {'-', '-', '-', '-'},
                        {'-', '-', '-', '-'}};
    private Sala[][] salas = new Sala[4][4] ;

    Caverna(){
        for(int i = 0; i < 4; i++){
            for(int n = 0; n < 4; n++){
                salas[i][n] = new Sala(i, n);
            }
        }
    }
    public void ConectaCompSala(int x, int y, Componente comp_atual, char tipo){
        salas[x][y].concetaComponente(comp_atual);
        cave[x][y] = tipo;

    }

    public char[][] PrintaCaverna(){
        return cave;
    }
}
