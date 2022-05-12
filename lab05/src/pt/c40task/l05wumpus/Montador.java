package pt.c40task.l05wumpus;

public class Montador {
        private String cave[][];
        public Caverna caverna = new Caverna();
        Montador(String cave[][]){
            this.cave = cave;
            this.criarCaverna();
        }
        private void criarCaverna(){
            for(int i = 0; i < 16; i++){
                String tipo = cave[i][2];
                if(tipo.equals("W")){
                    Componente comp_atual = new Wullumpus();
                }
                else if(tipo.equals("B")){
                    Componente comp_atual = new Buraco();
                }
                else if(tipo.equals("O")){
                    Componente comp_atual = new Ouro();
                }
                else{
                    Componente comp_atual = new Heroi();
                }

        }

}}
