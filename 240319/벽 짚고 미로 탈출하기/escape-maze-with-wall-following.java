import java.util.*;
import java.io.*;

public class Main {

    private static class Ball {
        private int[] position = new int[2];
        private DirectionNode directionNode = new DirectionNode(0, 1);

        public Ball(int i, int j) {
            this.position[0] = i;
            this.position[1] = j;
        }

        public void go() {
            this.position[0] += this.directionNode.di;
            this.position[1] += this.directionNode.dj;
        }

        public void turnClock() {
            DirectionNode directionNode = getClock.get(this.directionNode);
            this.directionNode.di = directionNode.di;
            this.directionNode.dj = directionNode.dj;
        }

        public void turnAntiClock() {
            DirectionNode directionNode = getAntiClock.get(this.directionNode);
            this.directionNode.di = directionNode.di;
            this.directionNode.dj = directionNode.dj;
        }

        public boolean checkRight() {
            DirectionNode directionNode = getClock.get(this.directionNode);
            int for_i = this.position[0] + directionNode.di;
            int for_j = this.position[1] + directionNode.dj;
            if (arr[for_i][for_j] == '#' || !isInRange(for_i, for_j)) {
                return true;
            }
            return false;
        }
    }

    private static class DirectionNode {
        private int di;
        private int dj;

        public DirectionNode(int di, int dj) {
            this.di = di;
            this.dj = dj;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DirectionNode that = (DirectionNode) o;
            return di == that.di && dj == that.dj;
        }

        @Override
        public int hashCode() {
            return Objects.hash(di, dj);
        }
    }

    private static char[][] arr;
    private static boolean[][] visited;
    private static int N;
    private static Ball ball;
    private static Map<DirectionNode, DirectionNode> getClock = new HashMap<>();
    private static Map<DirectionNode, DirectionNode> getAntiClock = new HashMap<>();
    private static boolean flag = false;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ball = new Ball(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        setHashMap();
        arr = new char[N][N];
        visited = new boolean[N][N];
        visited[ball.position[0]][ball.position[1]] = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }


        escape();

        if (flag) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }

    public static void escape() {
        cnt = 1;
        flag = false;
        while (ball.position[0] < N && ball.position[0] >= 0 && ball.position[1] < N && ball.position[1] >= 0) {
            int for_i = ball.position[0] + ball.directionNode.di;
            int for_j = ball.position[1] + ball.directionNode.dj;
            if (!isInRange(for_i, for_j)) {
                break; // 이전: return cnt + 1; 변경: 루프 탈출
            }

            if (arr[for_i][for_j] == '#') {
                ball.turnAntiClock();
                continue;
            } else {
                if (ball.checkRight()) {
                    ball.go();
                    cnt++;
                    if (visited[ball.position[0]][ball.position[1]]) {
                        break; // 이전: return; 변경: 루프 탈출
                    }
                    visited[ball.position[0]][ball.position[1]] = true;
                } else {
                    ball.turnClock();
                    ball.go();
                    if (visited[ball.position[0]][ball.position[1]]) {
                        break; // 이전: return; 변경: 루프 탈출
                    }
                    cnt++;
                    visited[ball.position[0]][ball.position[1]] = true;
                }
            }
        }
        flag = true;
    }

    public static void setHashMap() {
        DirectionNode directionNode1 = new DirectionNode(0, 1);
        DirectionNode directionNode2 = new DirectionNode(1, 0);
        DirectionNode directionNode3 = new DirectionNode(0, -1);
        DirectionNode directionNode4 = new DirectionNode(-1, 0);

        getClock.put(directionNode1, directionNode2);
        getClock.put(directionNode2, directionNode3);
        getClock.put(directionNode3, directionNode4);
        getClock.put(directionNode4, directionNode1);

        getAntiClock.put(directionNode1, directionNode4);
        getAntiClock.put(directionNode4, directionNode3);
        getAntiClock.put(directionNode3, directionNode2);
        getAntiClock.put(directionNode2, directionNode1);
    }

    private static boolean isInRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}