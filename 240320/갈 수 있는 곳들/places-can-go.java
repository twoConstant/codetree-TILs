import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int cnt;
    private static int[] di = {0, 1, 0, -1};
    private static int[] dj = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 시작위치 별로 bfs탐색을 하면서
        // 새로 방문한 경우 카운트를 하자

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        boolean[][] visited = new boolean[N][N];

        // 초기세팅, 방첵, 시작점 받기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    visited[i][j] = true;
                }
            }
        }
        // printVisitied(visited);

        Stack<int[]> startNodes = new Stack<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] startNode = {Integer.parseInt(st.nextToken()) - 1
                                , Integer.parseInt(st.nextToken()) - 1};
            startNodes.push(startNode);
        }
        // System.out.println("startNodes size : " + startNodes.size());


        // m번 반복하며 bfs 돌기
        getAnswer(startNodes, visited);

    }


    public static void printVisitied(boolean[][] visited) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(visited[i][j]?(1 + " "):0 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    // startNodes와 vistited를 받아 도달 할 수 있는 방문지를 카운트 하는 메서드
    public static void getAnswer(Stack<int[]> startNodes, boolean[][] visited) {
        int startNodesSize = startNodes.size();
        for(int i = 0; i < startNodesSize; i++) {
            int[] startNode = startNodes.pop();
            bfs(startNode, visited);
        }
        System.out.println(cnt);
    }

    public static void bfs(int[] startNode, boolean[][] visited) {
        // q, 방문체크 초기화 작검
        Queue<int[]> q = new LinkedList<>();
        if (!visited[startNode[0]][startNode[1]]){
            q.add(startNode);
            visited[startNode[0]][startNode[1]] = true;
            cnt++;
        }

        // 탐색
        while(!q.isEmpty()) {
            // 디큐
            int[] cn = q.poll();
            // 탐색
            int i = cn[0];
            int j = cn[1];
            for(int k = 0; k < 4; k++){
                int ni = i + di[k];
                int nj = j + dj[k];
                if(isInRange(ni, nj) && !visited[ni][nj]){
                    int[] wn = {ni, nj};
                    q.add(wn);
                    visited[ni][nj] = true;
                    cnt++;
                    printVisitied(visited);
                }
                
            }
        }

    }


    public static boolean isInRange(int ni, int nj) {
        if(ni >= 0 && ni < N && nj >= 0 && nj < N) {
            return true;
        }
        return false;
    }
    
}