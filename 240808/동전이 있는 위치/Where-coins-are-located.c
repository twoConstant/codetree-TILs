#include <stdio.h>

int map[9][9] = {0};

int main() {
    // 여기에 코드를 작성해주세요.
    int N, M;
        if(scanf("%d%d", &N, &M) != 2){
            printf("scanf error1");
        }

    for(int t = 0; t < M; t++) {
        int i, j;
            if(scanf("%d%d", &i, &j) != 2) {
                printf("scanf error2");
            }
        
        map[i - 1][j - 1] = 1;
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            printf("%d ", map[i][j]);
        }
        printf("\n");
    }
    return 0;
}