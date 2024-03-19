import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int cnt;
    private static int[] di = {0, 1, 0, -1};
    private static int[] dj = {1, 0, -1, 0};
    private static Stack<int[]> stack = new Stack<>();
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] startNode = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        visited = new boolean[N][N];

        // 다음 실행을 위한 스택 초기화
        while(!stack.empty()) {
            stack.pop();
        }
        
        // 초기 상황 세팅
        stack.push(startNode);
        visited[startNode[0]][startNode[1]] = true;
        cnt = 1;

        // 폭발을 M 번 반복하며 생성된 폭탄 개수 카운트
        for(int t = 1; t < M + 1; t++) {
            bang(t);
        }

        System.out.println(cnt);
    }


    public static boolean isInRange(int ni, int nj) {
        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
            return true;
        }
        return false;
    } 

    public static void bang(int t) {
        // 현재 쌓여있는 stack 만큼만 반복하기
        for(int i = 0; i < stack.size(); i++) {
            // 폭탄 빼고
            int[] curBomb = stack.pop();
            // 4방향 증식
            for(int k = 0; k < 4; k++) {
                int ni = curBomb[0] + di[k] * 2^(t - 1);
                int nj = curBomb[1] + dj[k] * 2^(t - 1);
                // 유효성 검사하고
                if (isInRange(ni, nj) && !visited[ni][nj]) {
                // 스텍에 넣기
                    int[] nBomb = {ni, nj};
                    stack.push(nBomb);
                    visited[ni][nj] = true;
                    cnt++;
                }
            }
        }
    }
}