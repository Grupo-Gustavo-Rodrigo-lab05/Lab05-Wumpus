package pt.c40task.l05wumpus;

public class Montador {
        String cave[][];
        Caverna caverna = new Caverna();
        Montador(String cave[][]){
            this.cave = cave;
        }
        private void criarCaverna(){
            for(int i = 0; i < 16; i++){
                    caverna.criarSala(cave[i][0], cave[i][1], cave[i][2]);
            }
        }

}
