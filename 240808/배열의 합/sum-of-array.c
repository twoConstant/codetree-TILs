#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    int N = 4;
    int M = 4;
    int map[N][M];

    // 배열 받기
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            scanf("%d", &map[i][j]);
        }
    }

    // 열 합구해서 출력하기
    for(int i = 0; i < N; i++) {
        int sum_row = 0;
        for(int j = 0; j < M; j++) {
            sum_row += map[i][j];
        }
        printf("%d\n", sum_row);
    }

    return 0;
}