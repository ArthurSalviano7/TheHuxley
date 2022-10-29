import java.util.Scanner;

public class HuxleyHeapSort {
    
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
            if(i == A.length - 1){
                System.out.println(A[i]);
            }else{
                System.out.print(A[i] + " | ");
            }
        }

        HeapSort(A);

        System.out.print("Resultado Final: ");
        for(int i = 0; i < A.length; i++){
            if(i == A.length - 1){
                System.out.println(A[i]);
            }else{
                System.out.print(A[i] + " | ");
            }
        }

    }

    public static int[] HeapSort(int[] vetor){
        int i;
        int j = vetor.length;

        buildMaxHeap(vetor);
            
        System.out.print("Estado Atual da Heap: ");
        for(int k = 0; k != j; k++){
            if(k == j-1){
                System.out.println(vetor[k]);
            }else{
                System.out.print(vetor[k] + " | ");
            }
        }

        if(j != 1){
            System.out.println("Maior elemento neste passo: " + vetor[0]);
        }
        

        for(i = vetor.length-1; i>0;i--){
            troca(vetor, 0, i);
            maxHeapify(vetor, 0, i);
            
            System.out.print("Estado Atual da Heap: ");
            for(int k = 0; k != j-1; k++){
                if(k == j-2){
                    System.out.println(vetor[k]);
                }else{
                    System.out.print(vetor[k] + " | ");
                }
            }
            j--;
            
            if(j != 1){
                System.out.println("Maior elemento neste passo: " + vetor[0]);
            }
        }

        return vetor;
    }

    public static void buildMaxHeap(int vetor[]){        
        for(int i = (vetor.length/2)-1; i >= 0; i--){
            maxHeapify(vetor, i, vetor.length);
        }
    }

    public static void printEstadoAtual(int A[]){
        System.out.print("Estado Atual da Heap: ");
        for(int i = 0; i < A.length; i++){
            if(i == A.length - 1){
                System.out.println(A[i]);
            }else{
                System.out.print(A[i] + " | ");
            }
        }
    }

    public static void maxHeapify(int[] vetor, int i, int fim){
        int esq = 2*i+1;
        int dir = 2*i+2;

        int maior;

        if(esq < fim && (vetor[esq] >= vetor[i])){
            maior = esq;
        }
        else{
            maior = i;
        }

        if(dir < fim && (vetor[dir] >= vetor[maior])){
            maior = dir;
        }
        
        if(maior != i){
            troca(vetor, maior, i);
            maxHeapify(vetor, maior, fim);
        }
    }

    public static void troca(int vetor[], int i, int j){
        int aux = vetor[i]; 
        vetor[i] = vetor[j]; 
        vetor[j] = aux; 
    }
}
