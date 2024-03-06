import java.util.*;
import java.io.*;

public class Main {
    private static int[] di = {1, 0};
    private static int[] dj = {0, 1};
    private static int N;
    private static int M;
    private static int[][] arr;
    private static Boolean flag;

    public static class Node{
        private int i;
        private int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // arr만들기
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Node node = new Node(0, 0);
        dfs(node);

        if(flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        boolean[][] visited = new boolean[N][M];
        flag = false;
        stack.push(node);
        visited[node.i][node.j] = true;

        while(!stack.empty()){
            Node cn = stack.pop();
            if (cn.i == N - 1 && cn.j == M - 1){
                flag = true;
            }
            for(int i = 0; i < 2; i++) {
                Node wn = new Node(cn.i + di[i], cn.j + dj[i]);
                if (isCanPush(wn, visited)){
                    stack.push(wn);
                }
            }

        }

    }
    // 노드를 받았을때 푸쉬 될 자격이 있는지 판단하기
    public static Boolean isCanPush(Node node, boolean[][] visited) {
        int i = node.i;
        int j = node.j;

        if (i >= 0 && i < N && j >= 0 && j < M && !visited[i][j] && arr[i][j] != 0) {
            return true;
        }
        return false;
    }
}