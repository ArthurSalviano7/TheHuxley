import java.util.Scanner;

public class HuxleyQuickSort{

    public static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) {
        String linha;

        linha = leitor.nextLine();

        String splitLinha[] = linha.split(" ");
        int A[] = new int[splitLinha.length];

        for(int i = 0; i < splitLinha.length; i++){
            A[i] = Integer.parseInt(splitLinha[i]);
        }
        
        System.out.print("Estado inicial: ");
        for(int i = 0; i < A.length; i++){
            if(i == A.length-1){
                System.out.println(A[i]);
            }else{
                System.out.print(A[i] + " | ");
            }  
        }
        System.out.println();
    
        QuickSort(A, 0, A.length - 1);

        System.out.print("Resultado Final: ");
        for(int i = 0; i < A.length; i++){
            if(i == A.length-1){
                System.out.println(A[i]);
            }else{
                System.out.print(A[i] + " | ");
            }  
        }
    }
    
    public static void QuickSort(int A[], int inicio, int fim){
        int pivo;

        if(inicio < fim){
            pivo = Partition(A, inicio, fim);

            QuickSort(A, inicio, pivo - 1);
            QuickSort(A, pivo + 1, fim);
        }


    }

    public static int Partition(int A[], int inicio, int fim){        
        int pivo = A[fim];
        int i = inicio - 1;

        for(int j = inicio; j <= fim - 1; j++){
            if(A[j] <= pivo){
                i++;
                troca(A, i, j);
            }
        }
        troca(A, i + 1, fim);

        System.out.print("Pivot: " + pivo + "\n");
        System.out.print("Partition(A," + (inicio + 1) + "," + (fim + 1 ) + "): ");
        for(int k = inicio; k < fim + 1; k++){
            if(A[k] < pivo){
                System.out.print(A[k] + " ");
            }
        }
        System.out.print("<= " + pivo + " < ");
        for(int k = inicio; k < fim + 1; k++){
            if(A[k] > pivo){
                System.out.print(A[k] + " ");
            }
        }
        System.out.println();
        printEstadoAtual(A);
        System.out.println();

        return i+1;
    }

    public static void troca(int[] A, int i, int j){
        int aux = A[i];
        A[i] = A[j];
        A[j] = aux;
    }

    public static void printEstadoAtual(int vetor[]){
        System.out.print("Estado atual de A: ");
        
        for(int i = 0; i < vetor.length; i++){
            if(i == vetor.length-1){
                System.out.println(vetor[i]);
            }else{
                System.out.print(vetor[i] + " | ");
            }  
        }
    }
}