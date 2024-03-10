import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int K;
    private static int M;
    private static int[][] arr;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        putBlock();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }        

    }
    
    public static void putBlock() {
        for(int i = 0; i < N; i++){
            for(int j = K; j < K + M; j++){
                if(arr[i][j] == 1){
                    for(int k = K; k < K + M; k++ ){
                        arr[i - 1][k] = 1;
                    }
                    return;
                }
            }
        }
        for(int k = K; k < K + M; k++ ){
            arr[N - 1][k] = 1;
        }
    }

}