package pt.c40task.l05wumpus;
import java.util.Random;

public class Componente {
    protected int coordenadaX, coordenadaY;
    protected char tipo;
    protected Caverna caverna;

    public Componente(int coordenadaX, int coordenadaY, char tipo) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.tipo = tipo;
    }

    public void conectaCaverna(Caverna caverna) {
        this.caverna = caverna;
    }
    public void solicitaSala() {
        caverna.conectaCompSala(coordenadaX, coordenadaY, this, tipo);
    }

    //passar pro wumpus e buraco depois//
    public void geraEfeito() {
        if(coordenadaX - 1 >= 0)
            caverna.adicionaEfeito(coordenadaX - 1,  coordenadaY, tipo);
        if(coordenadaX + 1 <= 3)
            caverna.adicionaEfeito(coordenadaX + 1, coordenadaY, tipo);
        if(coordenadaY - 1 >= 0)
            caverna.adicionaEfeito(coordenadaX, coordenadaY - 1, tipo);
        if(coordenadaY + 1 <= 3)
            caverna.adicionaEfeito(coordenadaX, coordenadaY + 1, tipo);
    }

    //Passar pro heroi depois//

    private boolean temOuro = false;
    private boolean flechaEquipada = false;
    private boolean temFlecha = true;

    public void equipaFlecha(){
        if(temFlecha){
            flechaEquipada = true;
            temFlecha = false;
        }
    }

    public boolean getTemFlecha(){
        return temFlecha;
    }

    public boolean getOuro(){
        return temOuro;
    }
    public void capturaOuro(){
        temOuro = true;
        caverna.Remove(coordenadaX, coordenadaY, 'O');
    }
    public boolean getflechaEquipada(){
        return flechaEquipada;
    }

    public boolean usaFlecha(){
        flechaEquipada = false;
        if(caverna.getComponenteSala(coordenadaX, coordenadaY) == 'W'){
            Random gerador = new Random();
            int i = gerador.nextInt(2);
            if(i == 1){
                caverna.Remove(coordenadaX, coordenadaY, 'W');
                return true;
            }
            else{

                return false;
            }
        }
        return false;
    }

}
