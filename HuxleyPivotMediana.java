import java.util.Scanner;

public class HuxleyPivotMediana {
    
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
        int menor = A[0];

        for (int i = 0; i < A.length; i++){
            if(A[i] > maior){
                maior = A[i];
            }
            if (A[i] < menor){
                menor = A[i];
            }
        }
        
        int pivo = 0;
        int indexPivo = 0;
        int m = (maior + menor) / 2;
        int diferenca = A[0] - m;

        for (int i = 0; i < A.length; i++){
            if(Math.abs(A[i] - m) < Math.abs(diferenca)){
                diferenca = Math.abs(A[i] - m);
                pivo = A[i];
                indexPivo = i;
            }
        }
        System.out.println(pivo);

        Partition(A, 0, A.length - 1, indexPivo);

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
        int aux;

        troca(A, indexPivo, A.length - 1);
        
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