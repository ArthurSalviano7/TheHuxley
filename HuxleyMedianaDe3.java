import java.util.Scanner;

public class HuxleyMedianaDe3 {
    
    public static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) {
        String linha;

        linha = leitor.nextLine();

        String splitLinha[] = linha.split(" ");
        int A[] = new int[splitLinha.length];

        for(int i = 0; i < splitLinha.length; i++){
            A[i] = Integer.parseInt(splitLinha[i]);
        }

        MedianaDe3(A, 0, (A.length - 1)/2, A.length - 1);
    }

    public static void MedianaDe3(int A[], int p, int q, int r){
        int pivo, aux;
        int indexPivo = 0;
        boolean troca = true;

        int vetor[] = {A[p], A[q], A[r]};

        while(troca){
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++){
                if(vetor[i] > vetor[i+1]){
                    aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;

                    troca = true;
                }
            }
        }
        pivo = vetor[1];
        //System.out.print(vetor[0] + " " + vetor[1] + " " + vetor[2] + "\n");

        System.out.println(pivo);

        //Recuperar o index do pivo
        if(A[q] == pivo){
            indexPivo = q;
        }
        if(A[p] == pivo){
            indexPivo = p;
        }
        if(A[r] == pivo){
            indexPivo = r;
        }
        
        Partition(A, 0, A.length - 1, indexPivo);

        //Imprimir
        for (int i = 0; i < A.length; i++){
            if (i == A.length - 1){
                System.out.println(A[i]);
            }
            else{
                System.out.print(A[i] + " ");
            }
        }
        
    }

    public static int Partition(int A[], int inicio, int fim, int indexPivo){
        troca(A, indexPivo, A.length - 1); //Coloca o pivo na ultima posicão
        
        int pivo = A[fim];
        int i = inicio - 1;

        for(int j = inicio; j <= fim - 1; j++){
            if(A[j] <= pivo){
                i++;
                troca(A, i, j);
            }
        }
        troca(A, i + 1, fim);

        return i+1;
    }

    public static void troca(int[] A, int i, int j){
        int aux = A[i];
        A[i] = A[j];
        A[j] = aux;
    }    
}
