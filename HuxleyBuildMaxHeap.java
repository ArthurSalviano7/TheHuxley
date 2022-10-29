import java.util.Scanner;

public class HuxleyBuildMaxHeap {
    
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

        buildMaxHeap(A);
        System.out.print("Resultado Final: ");
        for(int i = 0; i < A.length; i++){
            if(i == A.length - 1){
                System.out.println(A[i]);
            }else{
                System.out.print(A[i] + " | ");
            }
        }

    }

    public static void buildMaxHeap(int vetor[]){        
        for(int i = (vetor.length/2)-1; i >= 0; i--){
            maxHeapify(vetor, i, vetor.length);
            
            printEstadoAtual(vetor);
        }
    }

    public static void printEstadoAtual(int A[]){
        System.out.print("Estado Atual: ");
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
