import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int cnt;
    private static boolean[][] visited;
    private static int answerHight = 1;
    private static int[] di = {-1, 0, 1, 0};
    private static int[] dj = {0, 1, 0, -1};
    private static final int DETAL_SEARCH_NUM = 4;
    private static int[][] arr;
    private static Stack<int[]> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        int maxHeight = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > maxHeight){
                    maxHeight = arr[i][j];
                }
            }
        }
        // System.out.println("maxHeight : " + maxHeight);

        int answer = getMax(maxHeight);
        System.out.println(answerHight+ " " + answer);
    }

    public static int getMax(int maxHeight){
        // System.out.println("activate getMax Method");
        int maxValue = 0;
        
        for(int curHeight = 1; curHeight <= maxHeight; curHeight++){    // 1부터 최대건물의 높이까지 반복
            scanArr(curHeight);
            // System.out.println("curHeight : " + curHeight + "," + "cluster : " + cnt);
            if (cnt > maxValue) {
                maxValue = cnt;
                answerHight = curHeight;
                // System.out.println("최대값 갱신 : " + maxValue + " -> " + cnt);
            }
        }
        // System.out.println("deActivate getMax Method");
        return maxValue;
    }

    public static void scanArr(int curHeight) {
        // System.out.println("activate scanArr Method");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }
        cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && isHigher(i, j, curHeight)) {
                    // System.out.println("visited :" + "(" + i + j + ")" + visited[i][j]);
                    dfs(i, j, curHeight, visited);
                }
            }
        }
        // System.out.println("deactivate scanArr Method");
    }

    public static void dfs(int i, int j, int curHeight, boolean[][] visited) {
        // System.out.println("curHeight : " + curHeight + ", 탐색시작 건물높이 : " + arr[i][j] + ", 탐색 좌표: " +"(" + i + ", " + j + ")");
        stack.push(new int[]{i, j});
        visited[i][j] = true;
        cnt++;
        while(!stack.empty()){
            // pop
            int[] cn = stack.pop();
            // for
            for(int k = 0; k < DETAL_SEARCH_NUM; k++){
                // push & visited
                int ni = cn[0] + di[k];
                int nj = cn[1] + dj[k];
                if (isInRange(ni, nj) && isHigher(ni, nj, curHeight) && !visited[ni][nj]) {
                    stack.push(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    // System.out.println("visited true :" + "(" + ni + nj + ")" + visited[ni][nj]);
                }
            }
        }
    }

    public static boolean isInRange(int ni, int nj) {
        if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
            return true;
        }
        return false;
    }

    public static boolean isHigher(int ni, int nj, int curHeight) {
        if (arr[ni][nj] > curHeight) {
            return true;
        }
        return false;
    }
}