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

    public boolean criaCaverna() {
        int n_buracos = 0;
        int n_wumpus = 0;
        int n_heroi = 0;
        int n_ouro = 0;
        for(int i = 0; i < cave.length; i++){
            int y = Integer.parseInt(cave[i][0]) - 1;
            int x = Integer.parseInt(cave[i][1]) - 1;
            String tipoComp = cave[i][2];

            Componente comp_atual = null;
            if(!tipoComp.equals("_")) {
                if (tipoComp.equals("W")) {
                    n_wumpus++;
                    comp_atual = new Wumpus(x, y, 'W');
                }
                else if (tipoComp.equals("B")) {
                    n_buracos++;
                    comp_atual = new Buraco(x, y, 'B');
                }
                else if (tipoComp.equals("O")) {
                    n_ouro++;
                    comp_atual = new Ouro(x, y, 'O');
                }
                else {
                    n_heroi++;
                    if(x != 0 || y != 0){
                        System.out.println("Caverna invalida");
                        System.exit(0);
                    }
                    comp_atual = new Heroi(x, y, 'P');
                    controle.conectaHeroi(comp_atual);
                }
                comp_atual.conectaCaverna(caverna);
                comp_atual.solicitaSala();
                comp_atual.geraEfeito();
            }
        }
        if(n_wumpus > 1|| n_wumpus < 1 || n_buracos > 3 || n_buracos < 2 || n_ouro > 1 || n_ouro < 1 || n_heroi > 2 || n_heroi < 1){
            System.out.println("Caverna invalida");
            return false;
        }
        return true;
    }
}
