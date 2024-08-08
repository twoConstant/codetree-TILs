#include <stdio.h>

int map_num[10][10] = {0,};

int main() {
    // 여기에 코드를 작성해주세요.
    int N, M;
        scanf("%d%d", &N, &M);
    
    for(int t = 0; t < M; t++) {
        int i, j;
            scanf("%d%d", &i, &j);
        map_num[i - 1][j - 1] = i * j;
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            printf("%d ", map_num[i][j]);
        }
        printf("\n");
    }
    return 0;
}