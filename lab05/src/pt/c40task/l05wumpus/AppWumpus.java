package pt.c40task.l05wumpus;
import java.util.Scanner;
public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
              (args.length > 0) ? args[0] : null,
              (args.length > 1) ? args[1] : null,
              (args.length > 2) ? args[2] : null);
   }

   public static void executaJogo(String arquivoCaverna, String arquivoSaida, String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      String cave[][] = tk.retrieveCave();
      Montador montador =  new Montador(cave);
      montador.criaCaverna();
      Caverna caverna = montador.getCaverna();
      Controle controle = montador.getControle();
      Scanner keyboard = new Scanner(System.in);
      String command = keyboard.nextLine();
      controle.setNomeJogador(command);
      char caveChar[][] = caverna.getMatriz();

      tk.writeBoard(caveChar, 10, 'x');

      System.out.println("=== Caverna");
      for (int l = 0; l < cave.length; l++) {
         for (int c = 0; c < cave[l].length; c++)
            System.out.print(cave[l][c] + ((c < cave[l].length-1) ? ", " : ""));
         System.out.println();
      }

      String movements = tk.retrieveMovements();
      System.out.println("=== Movimentos");
      System.out.println(movements);

      for (int i = 0; i < movements.length(); i++) {
         controle.acao(movements.charAt(i));
         caveChar = caverna.getMatriz();
         tk.writeBoard(caveChar, controle.getScore(), controle.getStatus());

         for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++)
               System.out.print(caveChar[j][k]);
            System.out.println();
         }
         System.out.println("Player:" +   controle.getNomeJogador());
         System.out.println("SCORE:" + controle.getScore());
         System.out.println("Numero flechas: "+controle.getFlechas());
         if(controle.getFlechaEquipada()){
            System.out.println("Flecha equipada: Sim");
         }
         else{
            System.out.println("Flecha equipada: Não");
         }
         if(controle.getStatus() == 'L'){
            System.out.println("Você perdeu =( ...");
            System.exit(0);
         }
         else if(controle.getStatus() == 'W'){
            System.out.println("Voce ganhou =D !!!");
            System.exit(0);
         }
         System.out.println("=========");
      }

      tk.stop();
   }

}