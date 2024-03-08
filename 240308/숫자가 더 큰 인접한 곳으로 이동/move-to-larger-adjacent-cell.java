import java.util.*;
import java.io.*;


public class Main {
    private static int[][] map;
    private static int N;
    private static int[][] arr;
    private static int[] cn;
    private static int[] wn;
    private static int[] di = {-1, 1, 0, 0};
    private static int[] dj = {0, 0, -1, 1};
    private static final int DELTA_NUM = 4;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cn = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        wn = new int[2];
        wn[0] = cn[0];
        wn[1] = cn[1];
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            cn[0] = wn[0];
            cn[1] = wn[1];

            move(cn);
            System.out.print(map[cn[0]][cn[1]] + " ");
            if (isSame(cn, wn)){break;}
        }

    }

    public static void move(int[] cn){
        int i = cn[0];
        int j = cn[1];

        int maxValue = 0;
        int decision = -1;
        for(int k = 0; k < DELTA_NUM; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (isInRange(ni, nj) && map[ni][nj] > map[i][j]){
                // if(maxValue < map[ni][nj]) {
                //     maxValue = map[ni][nj];
                //     decision = k;
                // }
                decision = k;
                break;
            }
        }
        if (decision == -1){return;}
        wn[0] = cn[0] + di[decision];
        wn[1] = cn[1] + dj[decision];
        
    }

    public static boolean isSame(int[] cn, int[] wn){
        if(cn[0] == wn[0] && cn[1] == wn[1]){
            return true;
        }
        return false;
    }

    public static boolean isInRange(int ni, int nj){
        if(ni >= 0 && ni < N && nj >= 0 && nj < N) {
            return true;
        }
        return false;
        
    }
}