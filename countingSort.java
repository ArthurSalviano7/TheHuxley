import java.util.Scanner;

public class countingSort {
    
    public static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) {
        String linha;

        linha = leitor.nextLine();

        String splitLinha[] = linha.split(" ");
        int A[] = new int[splitLinha.length];

        for(int i = 0; i < splitLinha.length; i++){
            A[i] = Integer.parseInt(splitLinha[i]);
        }
        
        int maior = A[0];
        for(int i = 0; i < A.length; i++){
            if (A[i] > maior){
                maior = A[i];
            }
        }

        CountingSort(A, maior);
    }

    public static void CountingSort(int A[], int k){

        int vetorCont[] = new int[k+1];

        for(int i : A){
            vetorCont[i]++;
        }

        for (int i = 0; i < vetorCont.length; i++){
            if(i == vetorCont.length - 1){
                System.out.println(vetorCont[i]);
            }
            else{
                System.out.print(vetorCont[i] + " ");
            }    
        }

        //Ordenar A[]
        int n = 0;
        for (int i = 0; i < vetorCont.length; i++){
            while(0 < vetorCont[i]){
                A[n++] = i;
                vetorCont[i]--; 
            }
        }

        //Imprimir
        for (int i = 0; i < A.length; i++){
            if(i == A.length - 1){
                System.out.println(A[i]);
            }
            else{
                System.out.print(A[i] + " ");
            }
            
        }
    }
}
