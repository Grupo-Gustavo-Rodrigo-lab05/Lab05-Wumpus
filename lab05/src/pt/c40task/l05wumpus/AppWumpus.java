package pt.c40task.l05wumpus;
import java.util.Scanner;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
              (args.length > 0) ? args[0] : null,
              (args.length > 1) ? args[1] : null,
              (args.length > 2) ? args[2] : null);
   }

   private static void printaCaverna(char[][] caveChar, Controle controle, Toolkit tk) {
      for (int j = 0; j < 4; j++) {
         for (int k = 0; k < 4; k++)
            System.out.print(caveChar[j][k]);
         System.out.println();
      }
      System.out.println("Player:" + controle.getNomeJogador());
      System.out.println("SCORE:" + controle.getScore());
      System.out.println("Numero flechas: " + controle.getFlechas());
      if (controle.getFlechaEquipada()) {
         System.out.println("Flecha equipada: Sim");
      } else {
         System.out.println("Flecha equipada: Não");
      }
      if (controle.getStatus() == 'L') {
         System.out.println("Você perdeu =( ...");
         tk.stop();
         System.exit(0);
      } else if (controle.getStatus() == 'W') {
         System.out.println("Voce ganhou =D !!!");
         tk.stop();
         System.exit(0);
      }
   }

   public static void executaJogo(String arquivoCaverna, String arquivoSaida, String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      String cave[][] = tk.retrieveCave();

      //Criacao Montador
      Montador montador = new Montador(cave);
      montador.criaCaverna();

      //Recebe a caverna
      Caverna caverna = montador.getCaverna();

      //Recebe o controlador
      Controle controle = montador.getControle();

      Scanner keyboard = new Scanner(System.in);
      if(arquivoMovimentos == null) {
         String nome = keyboard.nextLine();
         controle.setNomeJogador(nome);
      }
      else {
         controle.setNomeJogador("Alcebiades");
      }

      char caveChar[][] = caverna.getMatriz();

      String movements = null;
      if(arquivoMovimentos != null) {
         movements = tk.retrieveMovements();
      }

      //Printa caverna inicial
      System.out.println("Caverna inicial");
      caveChar[0][0] = 'P';
      for (int j = 0; j < 4; j++) {
         for (int k = 0; k < 4; k++)
            System.out.print(caveChar[j][k]);
         System.out.println();
      }
      System.out.println("Player:" + controle.getNomeJogador());
      System.out.println("SCORE:" + controle.getScore());
      System.out.println("Numero flechas: " + controle.getFlechas());
      if (controle.getFlechaEquipada()) {
         System.out.println("Flecha equipada: Sim");
      } else {
         System.out.println("Flecha equipada: Não");
      }
      System.out.println("=====");
      tk.writeBoard(caveChar, 0, 'P');

      //Printa as etapas da movimentação
      if (arquivoMovimentos != null) {
         for (int i = 0; i < movements.length(); i++) {
            controle.acao(movements.charAt(i));
            caveChar = caverna.getMatriz();
            tk.writeBoard(caveChar, controle.getScore(), controle.getStatus());

            printaCaverna(caveChar, controle, tk);
            System.out.println("=====");
         }
      }
      else {
         String command = keyboard.nextLine();
         while (command.charAt(0) != 'q') {
            controle.acao(command.charAt(0));
            caveChar = caverna.getMatriz();
            tk.writeBoard(caveChar, controle.getScore(), controle.getStatus());

            printaCaverna(caveChar, controle, tk);
            System.out.println("=====");

            command = keyboard.nextLine();
         }
         printaCaverna(caveChar, controle, tk);
         System.out.println("Volte sempre!");
         System.out.println("=====");
      }
      tk.stop();
   }

}