import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        int n = sc.nextInt();

        for(int i = 1; i < n + 1;i++) {
            deque.addLast(i);
        }

        for(int i = 0; i < deque.size() - 1; i++){
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }
        System.out.println(deque.peekLast());

    }
}