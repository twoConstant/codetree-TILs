import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static final int DELTA_SEARCH_NUM = 4;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] di = {0, 1, 0, -1};
    private static int[] dj = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // System.out.println(Arrays.deepToString(arr));

        System.out.print(bfs()? 1:0);
    }
    public static boolean bfs() {
        // 초기화
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            // deque
            int[] cn = q.poll();
            // 4방향 탐색
            for(int k = 0; k < DELTA_SEARCH_NUM; k++) {
                int ni = cn[0] + di[k];
                int nj = cn[1] + dj[k];
                // 유효성 검사, 범위안, 뱀x, 방문 x
                if(isValid(ni, nj)){
                    q.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    // printVisited();
                    if (ni == N -1 && nj == M -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isValid(int ni, int nj) {
        if(ni >= 0 && ni < N && nj >= 0 && nj < M) {
            if(arr[ni][nj] != 0) {
                if(!visited[ni][nj]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void printVisited() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                System.out.print((visited[i][j]?1:0) + " ");
            }
            System.out.println();
        }
        System.out.print("-------------------------------");
    }
}