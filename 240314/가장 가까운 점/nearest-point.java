import java.util.*;
import java.io.*;

public class Main {
    public static class Node implements Comparable<Node>{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node node) {
            // 오름차순 this - node
            if((this.x + this.y) == (node.x + node.y)) {
                if (this.x == node.x) {
                    return this.y - node.y;
                }
                return this.x - node.x;
            }
            return (this.x + this.y) - (node.x + node.y);
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
                ));
        }

        for(int i = 0; i < m; i++) {
            // 빼고
            Node node = pq.poll();
            // 2 더하고
            node.x += 2;
            node.y += 2;
            // 다시 넣고
            pq.add(node);
        }

        Node node = pq.poll();
        System.out.println(node.x + " " + node.y);

        // for(int i = 0; i < n; i++){
        //     Node node = pq.poll();
        //     System.out.printf("(%d, %d)", node.x, node.y);
        // }

    }
}