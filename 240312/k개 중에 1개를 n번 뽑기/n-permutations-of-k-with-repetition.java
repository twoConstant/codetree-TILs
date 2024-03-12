import java.util.*;
import java.io.*;

public class Main {
    private static int K;
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        perm(0);
    }
    public static void perm(int curdeep) {
        // 탈출
        if(curdeep == N) {
            for(int i = 0; i < N; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            // 1부터 K - N 까지 수중에 뽑기
            for(int i = 1; i <= K; i++) {
                // 뽑고
                arr[curdeep] = i;
                // 다음으로
                perm(curdeep + 1);
            }
        }
    }
}