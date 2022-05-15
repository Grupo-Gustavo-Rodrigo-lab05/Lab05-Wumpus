package pt.c40task.l05wumpus;

public class Sala {
    int x, y;
    private Componente compSala;
    private Boolean revelada, fedor, brisa;

    public Sala(int x, int y) {
        this.x = x;
        this.y = y;
        this.compSala = null;
        this.revelada = false;
        this.fedor = false;
        this.brisa = false;
    }

    public Componente getCompSala() {
        return compSala;
    }

    public void adicionaBrisa() {
        this.brisa = true;
    }

    public void adicionaFedor() {
        this.fedor = true;
    }

    public void conectaComponente(Componente compSala) {
        this.compSala = compSala;
    }
}
