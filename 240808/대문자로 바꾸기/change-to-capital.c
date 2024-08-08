#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    int gap = 'a' - 'A';
    int N, M;
        N = 5;
        M = 3;
    char map_chr[N][M];
    
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            scanf("%c ", &map_chr[i][j]);
            map_chr[i][j] -= gap;
        }
        
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            printf("%c ", map_chr[i][j]);
        }
        printf("\n");
    }

    return 0;
}