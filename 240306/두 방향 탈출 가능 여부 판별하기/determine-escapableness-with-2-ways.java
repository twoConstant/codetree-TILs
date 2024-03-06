import java.util.*;
import java.io.*;

public class Main {
    private static int[] di = {1, 0};
    private static int[] dj = {0, 1};
    private static int N;
    private static int M;
    private static int[][] arr;
    private static boolean flag; // Boolean 대신 기본형 boolean 사용

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0); // 시작 위치를 파라미터로 전달

        System.out.println(flag ? 1 : 0);
    }

    public static void dfs(int i, int j) {
        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[N][M];
        flag = false;
        stack.push(new int[]{i, j});
        visited[i][j] = true;

        while(!stack.isEmpty()){
            int[] cn = stack.pop();
            if (cn[0] == N - 1 && cn[1] == M - 1){
                flag = true;
                break; // 목적지에 도달하면 더 이상 탐색 중단
            }
            for(int k = 0; k < 2; k++) {
                int ni = cn[0] + di[k];
                int nj = cn[1] + dj[k];
                if (isCanPush(ni, nj, visited)){
                    stack.push(new int[]{ni, nj});
                }
            }
        }
    }

    public static boolean isCanPush(int i, int j, boolean[][] visited) {
        if (i >= 0 && i < N && j >= 0 && j < M && !visited[i][j] && arr[i][j] != 0) {
            visited[i][j] = true; // 방문 표시를 여기서 해야 중복 방문을 방지할 수 있음
            return true;
        }
        return false;
    }
}