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

      //Criacao Montador
      Montador montador = new Montador(cave);
      montador.criaCaverna();

      //Cria a cavrne
      Caverna caverna = montador.getCaverna();

      //Cria o controlador
      Controle controle = montador.getControle();

      Scanner keyboard = new Scanner(System.in);
      String command = keyboard.nextLine();
      controle.setNomeJogador(command);
      char caveChar[][] = caverna.getMatriz();

      System.out.println("=== Caverna");
      for (int l = 0; l < cave.length; l++) {
         for (int c = 0; c < cave[l].length; c++)
            System.out.print(cave[l][c] + ((c < cave[l].length - 1) ? ", " : ""));
         System.out.println();
      }

      String movements = tk.retrieveMovements();
      System.out.println("=== Movimentos");
      System.out.println(movements);

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
      tk.writeBoard(caveChar, 0, 'P');

      //printa as etapas da movimentacao
      if (movements.length() != 0) {
         for (int i = 0; i < movements.length(); i++) {
            controle.acao(movements.charAt(i));
            caveChar = caverna.getMatriz();
            tk.writeBoard(caveChar, controle.getScore(), controle.getStatus());

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
            System.out.println("=========");
         }
      } else {
         command = keyboard.nextLine();
         while (command.charAt(0) != 'q') {
            controle.acao(command.charAt(0));
            caveChar = caverna.getMatriz();
            tk.writeBoard(caveChar, controle.getScore(), controle.getStatus());

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
            System.out.println("=========");
            command = keyboard.nextLine();
         }
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
         System.out.println("Volte sempre!");

      }
      tk.stop();
   }

   public static void executaJogo(String arquivoCaverna, String arquivoSaida) {
      command = keyboard.nextLine();
      while (command.charAt(0) != 'q') {
         controle.acao(command.charAt(0));
         caveChar = caverna.getMatriz();
         tk.writeBoard(caveChar, controle.getScore(), controle.getStatus());

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
         System.out.println("=========");
         command = keyboard.nextLine();
      }
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
      System.out.println("Volte sempre!");

   }
      tk.stop();
   }
}