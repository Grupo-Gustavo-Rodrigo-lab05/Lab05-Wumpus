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

            //Componente comp_atual = null;
            if(!tipoComp.equals("_")) {
                if (tipoComp.equals("W")) {
                    Wumpus wumpus = new Wumpus(x, y, 'W');
                    wumpus.conectaCaverna(caverna);
                    wumpus.solicitaSala();
                    wumpus.geraEfeito();
                }
                else if (tipoComp.equals("B")) {
                    Buraco buraco = new Buraco(x, y, 'B');
                    buraco.conectaCaverna(caverna);
                    buraco.solicitaSala();
                    buraco.geraEfeito();
                }
                else if (tipoComp.equals("O")) {
                    Ouro ouro = new Ouro(x, y, 'O');
                    ouro.conectaCaverna(caverna);
                    ouro.solicitaSala();
                }
                else {
                    Heroi heroi = new Heroi(x, y, 'P');
                    heroi.conectaCaverna(caverna);
                    heroi.solicitaSala();
                    controle.conectaHeroi(heroi);
                }
            }
        }
    }
}
