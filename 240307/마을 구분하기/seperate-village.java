import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] arr;
    private static boolean[][] visited;
    private static final int SEARCHING_NUM = 4;
    private static int[] di = {1, 0, -1, 0};
    private static int[] dj = {0, 1, 0, -1};
    private static Stack<int[]> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int[] node = new int[]{i, j};
                if (isNonBlocked(node)) {
                    list.add(dfs(node));
                }
            }
        }
        print(list);

    }
    public static void print(List<Integer> list) {
        System.out.println(list.size());
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static int dfs(int[] node) {
        stack.push(node);
        visited[node[0]][node[1]] = true;
        int cnt = 1;

        // 탐색
        while(!stack.empty()){
            int[] cn = stack.pop();
            for(int i = 0; i < SEARCHING_NUM; i++) {
                int ni = cn[0] + di[i];
                int nj = cn[1] + dj[i];
                if(isVaild(ni, nj)){
                    int[] wn = new int[]{ni, nj};
                    stack.push(wn);
                    visited[wn[0]][wn[1]] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public static boolean isVaild(int ni, int nj) {
        // 벽이 아니고, 방문하지 않았고, 범위 안인경우
        if(ni >= 0 && ni < N && nj >= 0 && nj < N){
            if(!visited[ni][nj] && arr[ni][nj] != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNonBlocked(int[] node) {
        // 방문 하지 않았거나 막혀있지 않은 경우
        if(arr[node[0]][node[1]] != 0 && !visited[node[0]][node[1]]){
            return true;
        }
        return false;
    }




}