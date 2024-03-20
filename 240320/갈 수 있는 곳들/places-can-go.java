import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class CustomQueue {

        Queue<int[]> q = new LinkedList<>();

        // add
        public void add(int[] node) {
            q.add(node);
            visited[node[0]][node[1]] = true;
            cnt++;
        }

        // poll
        public int[] poll() {
            return q.poll();
        }

        // empty
        public boolean isEmpty() {
            return q.isEmpty();
        }
    }

    private static int N;
    private static int M;
    private static int cnt;
    private static boolean[][] visited;
    private static int[] di = {0, 1, 0, -1};
    private static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        visited = new boolean[N][N];

        // 초기세팅, 방첵, 시작점 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    visited[i][j] = true;
                }
            }
        }
        // printVisited(visited);

        Stack<int[]> startNodes = new Stack<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] startNode = {Integer.parseInt(st.nextToken()) - 1
                , Integer.parseInt(st.nextToken()) - 1};
            startNodes.push(startNode);
        }
        // System.out.println("startNodes size : " + startNodes.size());

        // m번 반복하며 bfs 돌기
        getAnswer(startNodes);

    }


    // startNodes와 vistited를 받아 도달 할 수 있는 방문지를 카운트 하는 메서드
    public static void getAnswer(Stack<int[]> startNodes) {
        int startNodesSize = startNodes.size();
        for (int i = 0; i < startNodesSize; i++) {
            int[] startNode = startNodes.pop();
            bfs(startNode);
        }
        System.out.println(cnt);
    }

    public static void bfs(int[] startNode) {
        // q, 방문체크 초기화 작검
        CustomQueue customQueue = new CustomQueue();
        if (!visited[startNode[0]][startNode[1]]) {
            customQueue.add(startNode);
        }

        // 탐색
        while (!customQueue.isEmpty()) {
            // 디큐
            int[] cn = customQueue.poll();
            // 탐색
            for (int k = 0; k < 4; k++) {
                int ni = cn[0] + di[k];
                int nj = cn[1] + dj[k];
                if (isInRange(ni, nj) && !visited[ni][nj]) {
                    customQueue.add(new int[]{ni, nj});
                    // printVisited(visited);
                }
            }
        }
    }

    public static void printVisited(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(visited[i][j] ? (1 + " ") : 0 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isInRange(int ni, int nj) {
        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
            return true;
        }
        return false;
    }

}