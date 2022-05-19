package pt.c40task.l05wumpus;

public class Controle {
    private Componente heroi;
    int score;
    String nomeJogador;
    char status;

    public Controle() {
        this.score = 0;
        this.status = 'P';
    }

    public void conectaHeroi(Componente heroi) {
        this.heroi = heroi;
    }

    public void acao(char acao) {
        int xDestino = heroi.coordenadaX;
        int yDestino = heroi.coordenadaY;
        if (acao == 'w') {
            yDestino--;
            movimenta(xDestino, yDestino);
        } else if (acao == 's') {
            yDestino++;
            movimenta(xDestino, yDestino);
        } else if (acao == 'd') {
            xDestino++;
            movimenta(xDestino, yDestino);
        } else if (acao == 'a') {
            xDestino--;
            movimenta(xDestino, yDestino);
        } else if (acao == 'k') {
            if(heroi.equipaFlecha())
                System.out.println("Você equipou sua flecha, boa sorte!!");
            else
                System.out.println("Você nã possui mais flechas!!");
        } else if (acao == 'c') {
            if (heroi.caverna.getComponenteSala(xDestino, yDestino) == 'O') {
                System.out.println("Parabéns aventureiro, você recolheu o ouro. Agora fuja desta caverna!!");
                heroi.capturaOuro();
            }
            else
                System.out.println("Não há ouro nessa sala!!");
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

    public char getStatus(){
        return status;
    }

    public boolean getFlechaEquipada(){
        return heroi.getflechaEquipada();
    }

    public void alteraPontuacao(int valor) {
        score = score + valor;
    }

    private void movimenta(int xDestino, int yDestino) {
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
                    System.out.println("Incrível aventureiro, você matou o monstro Wumpus!!");

                } else {
                    alteraPontuacao(-1000);
                    status = 'L';
                }
            }
            else if(heroi.caverna.getComponenteSala(xDestino, yDestino) == 'B'){
                alteraPontuacao(-1000);
                status = 'L';
            }
            if(heroi.caverna.brisa(xDestino, yDestino)){
                System.out.println("Você sente uma brisa nesta sala!!");
            }
            if(heroi.caverna.fedor(xDestino, yDestino)){
                System.out.println("Você sente um fedor nesta sala!!");
            }
            if(xDestino == 0 && yDestino == 0 && heroi.getOuro()){
                alteraPontuacao(1000);
                status = 'W';
            }
            if(heroi.getflechaEquipada()){
                heroi.usaFlecha();
                alteraPontuacao(-100);
            }
        }
        else {
            System.out.println("Não há uma sala nessa direção!!");
        }
    }
}

