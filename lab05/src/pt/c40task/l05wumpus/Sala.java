package pt.c40task.l05wumpus;

public class Sala {
    int x, y;
    Componente comp_sala;
    Boolean revelada, fedor, brisa;

    Sala(int x, int y) {
        this.x = x;
        this.y = y;
        this.revelada = false;
        this.fedor = false;
        this.brisa = false;
    }

    public void adicionaBrisa() {
        this.brisa = true;
    }

    public void adicionaFedor() {
        this.fedor = true;
    }

    public void conectaComponente(Componente comp_sala) {
        this.comp_sala = comp_sala;
    }
}
