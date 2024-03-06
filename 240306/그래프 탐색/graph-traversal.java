import java.util.*;
import java.io.*;


public class Main {
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 인접리스트 선언
        ArrayList<Integer>[] ajList = new ArrayList[V + 1];
        for(int i = 1; i < V + 1; i++){
            ajList[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            ajList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        // 탐색 노드
        int n = 1;

        dfs(n, V, ajList);
        System.out.println(cnt - 1);    // 자신 방문 한 경우 제외
    }

    public static void dfs(int n, int V, ArrayList<Integer>[] ajList) {
        // 스택, 방문체크 초기화
        boolean[] visitied = new boolean[V + 1];
        Stack<Integer> stack = new Stack<>();

        stack.push(n);

        // 탐색 시작
        while(!stack.empty()) {
            // pop
            int cn = stack.pop();
            // 방첵
            visitied[cn] = true;
            cnt++;
            // 탐색
            for(int w : ajList[cn]){
                if(!visitied[w]){
                    stack.push(w);
                }
            }
        }
    }
}