
import java.util.Scanner;

/**
 *
 * @author Thales Muller
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Variaveis
        int A, B;//intervalo
        int qnt = 0; // determina a quantidade numeros primos
        int qntG = 0; //determina quantidade de numeros primos gemeos
        int listaPrimos[]; //lista com os numeros primos
        int aux = 0, i, cont1, cont2, div = 0, pos1, pos2, pos3; //variaveis auxiliares
        
        //Leitura de Dados
        System.out.print("Início do Intervalo A: ");
        A = in.nextInt();
        do {
            if (aux > 0) {
                System.out.println("- O fim do intervalo tem que ser maior que "
                        + "o início (A<B) - ");
            }
            System.out.print("Fim do Intervalo B: ");
            B = in.nextInt();
            aux++;
        } while (A > B); //Verificação se B < A

        //Evitar erro com iniciador 0
        while (A == 0) {
            A++;
        }

        //Encontrar numeros primos
        for (i = A; i <= B; i++, div = 0) {
            if (i == 1) {
                continue;
            }
            cont1 = A;
            while (cont1 <= B) {
                if (i % cont1 == 0) {
                    div++;
                }
                cont1++;
            }
            if (div == 2) {
                qnt++;
                //System.out.println(i);
            }
        }

        //Carregar lista dos numeros primos
        listaPrimos = new int[qnt];
        cont2 = 0;
        for (i = A; i <= B; i++, div = 0) {
            if (i == 1) {
                continue;
            }
            cont1 = A;
            while (cont1 <= B) {

                if (i % cont1 == 0) {
                    div++;
                }
                cont1++;
            }
            if (div == 2) {
                listaPrimos[cont2] = i;
                cont2++;
                //System.out.println(i);

            }
        }
        //Encontrar a quantidade de numeros primos e gemeos
        for (i = 0; i < qnt - 1; i++) {
            pos1 = listaPrimos[i];
            pos2 = listaPrimos[i] + 1;
            pos3 = listaPrimos[i + 1];
            if ((pos1 + pos3) == (pos2 * 2)) {
                //System.out.println(listaPrimos[i]);
                qntG++;
            }
        }

        //Apresentar quantidade e quais são os numeros primos gemeos
        if (qntG > 1) {
            System.out.print(qntG + " pares de primos gêmeos (");
        } else {
            System.out.print(qntG + " par de primos gêmeos (");
        }
        for (i = 0; i < qnt - 1; i++) {

            pos1 = listaPrimos[i];
            pos2 = listaPrimos[i] + 1;
            pos3 = listaPrimos[i + 1];
            if ((pos1 + pos3) == (pos2 * 2)) {

                System.out.print(pos1 + " e " + pos3);
                qntG--;
                if (qntG == 1) {
                    System.out.print(" e ");
                } else if (qntG > 0) {
                    System.out.print(" , ");
                } else {
                    System.out.print(").");
                }
            }

        }

    }

}
