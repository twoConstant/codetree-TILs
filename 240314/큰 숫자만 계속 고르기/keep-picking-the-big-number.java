import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(-Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < m; i++) {
            // 빼고(-1 곱하기)
            int num = -pq.poll();
            //  - 1 하고
            num -= 1;
            // 다시 넣기(-1 곱하기)
            pq.add(-num);
        }
        System.out.println(-pq.poll());
    }
}