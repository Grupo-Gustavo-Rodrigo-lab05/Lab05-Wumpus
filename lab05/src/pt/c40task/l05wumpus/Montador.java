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
            int x = Integer.parseInt(cave[i][0]) - 1;
            int y = Integer.parseInt(cave[i][1]) - 1;
            String tipoComp = cave[i][2];
            Componente comp_atual;
            if(!tipoComp.equals("_")) {
                if (tipoComp.equals("W"))
                    comp_atual = new Wumpus(x, y, 'W');
                else if (tipoComp.equals("B"))
                    comp_atual = new Buraco(x, y, 'B');
                else if (tipoComp.equals("O"))
                    comp_atual = new Ouro(x, y, 'O');
                else
                    comp_atual = new Heroi(x, y, 'H');
                comp_atual.conectaCaverna(caverna);
                comp_atual.solicitaSala();
                if (tipoComp.equals("W"))
                    comp_atual.geraEfeito();
                else if (tipoComp.equals("B"))
                    comp_atual.geraEfeito();
            }
        }
    }
}
