import java.util.*;
import java.io.*;

public class Main {

    private static class Node implements Comparable<Node>{
        int num;
        int i;
        int j;

        public Node(int num, int i, int j) {
            this.num = num;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node node) {
            // num 이 같은 경우 -> i 오름차순
            if(this.num == node.num) {
                // i가 같은 경우 -> j 오름차순
                if(this.i == node.i) {
                    return this.j - node.j;
                }
                return this.i - node.i;
            }
            return node.num - this.num;
        }
    }

    private static int N;
    private static int M;
    private static int[][] map;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    private static int[] di = {0, 1, 0, -1};
    private static int[] dj = {1, 0, -1, 0};
    private static final int DELTA_NUM = 4;
    private static Node curNode;


    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        setMap_pq(br);
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken()) - 1;
        int j = Integer.parseInt(st.nextToken()) - 1;
        Node startNode = new Node(map[i][j], i, j);
        // System.out.printf("시작node : %d (%d, %d)", startNode.num, startNode.i, startNode.j);
        // System.out.println();
        curNode = startNode;
        
        // M 번 반복하면서 죄종 노드의 번호 찍기
        getAnwser();
        System.out.printf("%d %d", curNode.i, curNode.j);
        System.out.println();
    }
    public static void getAnwser() {
        // System.out.println("come in getAnswer");
        for(int i = 0; i < M; i++) {
            if (i == 0 && !isCanGo(curNode.i, curNode.j)) {return;}
            Node nextNode = goNext();
            // System.out.printf("nextNode : %d (%d, %d)", nextNode.num, nextNode.i, nextNode.j);
            // System.out.println();
            curNode = nextNode;
        }
    }

    public static Node goNext() {
        // System.out.println("comein goNext");
        // 지금 수보다 낮은 node 를 반환
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if (curNode.num > node.num) {
                return node;
            }
        }
        // System.out.println("pq가 비어 종료합니다.");
        return curNode;
    }


    public static void setMap_pq(BufferedReader br) throws IOException{
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new Node(map[i][j], i, j));
            }
        }
        // System.out.println(Arrays.deepToString(map));
        // System.out.println();
        // while(!pq.isEmpty()) {
        //     Node node = pq.poll();
        //     // System.out.printf("%d, %d, %d", node.num, node.i, node.j);
        //     // System.out.println();
        // }
    }

    public static boolean isCanGo(int i, int j) {
        // System.out.println("comein isCanGo");
        for(int k = 0; k < DELTA_NUM; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (isInRange(ni, nj) && map[i][j] >= map[ni][nj]) {
                // System.out.println("is CanGo 참값을 반환합니다.");
                return true;
            }
        }
        // System.out.println("isCanGo false");
        return false;
    }


    public static boolean isInRange(int ni, int nj) {
        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
            return true;
        }
        return false; 
    }
}