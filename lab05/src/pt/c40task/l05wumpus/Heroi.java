package pt.c40task.l05wumpus;

import java.util.Random;

public class Heroi extends Componente {
    private boolean temOuro = false;
    private boolean flechaEquipada = false;
    private boolean temFlecha = true;

    public Heroi(int coordenadaX, int coordenadaY, char tipo) {
        super(coordenadaX, coordenadaY, tipo);
    }

    public void equipaFlecha() {
        if(temFlecha){
            flechaEquipada = true;
            temFlecha = false;
        }
    }

    public boolean getTemFlecha() {
        return temFlecha;
    }

    public boolean getOuro() {
        return temOuro;
    }

    public void capturaOuro() {
        temOuro = true;
        caverna.Remove(coordenadaX, coordenadaY, 'O');
    }

    public boolean getflechaEquipada() {
        return flechaEquipada;
    }

    public boolean usaFlecha() {
        flechaEquipada = false;
        if(caverna.getComponenteSala(coordenadaX, coordenadaY) == 'W'){
            Random gerador = new Random();
            int i = gerador.nextInt(2);
            if(i == 1){
                caverna.Remove(coordenadaX, coordenadaY, 'W');
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
