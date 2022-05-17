package pt.c40task.l05wumpus;

public class Controle {
    private Componente heroi;
    int score = 0;
    String nomeJogador;
    char status = 'x';

    public void conectaHeroi(Componente heroi) {
        this.heroi = heroi;
    }

    public void acao(char acao) {
        int xDestino = heroi.coordenadaX;
        int yDestino = heroi.coordenadaY;
        if (acao == 'w') {
            yDestino--;
            Movimenta(xDestino, yDestino);
        } else if (acao == 's') {
            yDestino++;
            Movimenta(xDestino, yDestino);
        } else if (acao == 'd') {
            xDestino++;
            Movimenta(xDestino, yDestino);
        } else if (acao == 'a') {
            xDestino--;
            Movimenta(xDestino, yDestino);
        } else if (acao == 'k') {
            heroi.equipaFlecha();
        } else if (acao == 'c') {
            if (heroi.caverna.getComponenteSala(xDestino, yDestino) == 'O') {
                heroi.capturaOuro();
            }
        } else if( acao == 'q'){
            //encerra o jogo//
        }
    }

    public void setNomeJogador(String nome){
        nomeJogador = nome;
    }

    public int getScore(){
        return score;
    }

    public String getNomeJogador(){
        return nomeJogador;
    }

    public int getFlechas(){
        if(heroi.getTemFlecha()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public boolean getFlechaEquipada(){
        return heroi.getflechaEquipada();
    }

    public void alteraPontuacao(int valor) {
        score = score + valor;
    }

    private void Movimenta(int xDestino, int yDestino) {
        if (xDestino <= 3 && xDestino >= 0 && yDestino <= 3 && yDestino >= 0) {
            heroi.caverna.movimentaHeroi(xDestino, yDestino, heroi);
            alteraPontuacao(-15);
            if (heroi.caverna.getComponenteSala(xDestino, yDestino) == 'W') {
                boolean matou = false;
                if (heroi.getflechaEquipada()) {
                     matou = heroi.usaFlecha();
                     alteraPontuacao(-100);
                }
                if (matou) {
                    alteraPontuacao(500);

                } else {
                    alteraPontuacao(-1000);
                    //tirar pontuacao e encerrar o codigo//

                }
            }
            else if(heroi.caverna.getComponenteSala(xDestino, yDestino) == 'B'){
                alteraPontuacao(-1000);
                //Encerrar codigo//
            }
            if(xDestino == 0 && yDestino == 0 && heroi.getOuro()){
                alteraPontuacao(1000);
                //finaliza o jogo com vitoria//
            }

            if(heroi.getflechaEquipada()){
                heroi.usaFlecha();
                alteraPontuacao(-100);
            }

        }

    }
}

