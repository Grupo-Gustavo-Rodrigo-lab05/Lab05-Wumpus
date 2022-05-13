package pt.c40task.l05wumpus;

public class Montador {
    private String cave[][];
    public Caverna caverna = new Caverna();
    Montador(String cave[][]) {
        this.cave = cave;
        this.criaCaverna();
    }
    private void criaCaverna() {
        for(int i = 0; i < cave.length; i++){
            String tipoComp = cave[i][2];
            Componente comp_atual;
            if(tipoComp.equals("W")) {
                comp_atual = new Wullumpus();
            }
            else if(tipoComp.equals("B")) {
                comp_atual = new Buraco();
            }
            else if(tipoComp.equals("O")) {
                comp_atual = new Ouro();
            }
            else {
                comp_atual = new Heroi();
            }
            comp_atual.setCoordenadas(Integer.parseInt(cave[i][0]), Integer.parseInt(cave[i][1]));
            comp_atual.conectaCaverna(caverna);
            comp_atual.solicitaSala();
        }
    }
}
