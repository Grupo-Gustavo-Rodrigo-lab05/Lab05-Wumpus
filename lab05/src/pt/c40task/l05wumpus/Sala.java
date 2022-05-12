package pt.c40task.l05wumpus;

public class Sala {
    int x, y;
    Componente comp_sala;
    Boolean revelada = false;
    Sala(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void concetaComponente(Componente comp_sala){
        this.comp_sala = comp_sala;
    }
}
