package pt.c40task.l05wumpus;

public class Sala {
    int x, y;
    private Componente[] compSala;
    private Boolean revelada, fedor, brisa;

    public Sala(int x, int y) {
        this.x = x;
        this.y = y;
        this.compSala = new Componente[2];
        compSala[0] = null;
        compSala[1] = null;
        if(x == 0 && y == 0){
            this.revelada = true;
        }
        else{
            this.revelada = false;
        }
        this.fedor = false;
        this.brisa = false;
    }

    public Componente getCompSala() {
        return compSala[0];
    }

    public void adicionaBrisa() {
        this.brisa = true;
    }

    public boolean getBrisa(){
        return brisa;
    }

    public boolean getFedor(){
        return fedor;
    }

    public void adicionaFedor() {
        this.fedor = true;
    }

    public void revelaSala(){
        revelada = true;
    }

    public Boolean getRevelada() {
        return revelada;
    }

    public boolean adicionaComponente(Componente compSala) {
        if(this.compSala[0] == null){
            this.compSala[0] = compSala;
            return true;
        }
        else if(compSala.tipo == 'P'){
            this.compSala[1] = compSala;
            return true;
        }
        return false;
    }

    public void removeComponente(char tipo){
        if(compSala[0].tipo == tipo){
            compSala[0] = null;
            if(compSala[1] != null){
                compSala[0] = compSala[1];
                compSala[1] = null;
            }
        }
        else{
            compSala[1] = null;
        }
    }
}
