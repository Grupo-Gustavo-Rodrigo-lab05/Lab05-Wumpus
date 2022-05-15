package pt.c40task.l05wumpus;

public class Montador {
    private String cave[][];
    private Caverna caverna;
    private Controle controle;
    public Montador(String cave[][]) {
        this.cave = cave;
        this.caverna = new Caverna();
        this.controle = new Controle();
    }

    public Caverna getCaverna() {
        return caverna;
    }

    public Controle getControle() {
        return controle;
    }

    public void criaCaverna() {
        for(int i = 0; i < cave.length; i++){
            int y = Integer.parseInt(cave[i][0]) - 1;
            int x = Integer.parseInt(cave[i][1]) - 1;
            String tipoComp = cave[i][2];

            Componente comp_atual;
            if(!tipoComp.equals("_")) {
                if (tipoComp.equals("W"))
                    comp_atual = new Wumpus(x, y, 'W');
                else if (tipoComp.equals("B"))
                    comp_atual = new Buraco(x, y, 'B');
                else if (tipoComp.equals("O"))
                    comp_atual = new Ouro(x, y, 'O');
                else {
                    comp_atual = new Heroi(x, y, 'P');
                    controle.conectaHeroi(comp_atual);
                }

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
