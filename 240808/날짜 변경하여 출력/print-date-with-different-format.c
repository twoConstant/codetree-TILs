#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    int num_y, num_d, num_m;
    if(scanf("%d.%d.%d", &num_y, &num_m, &num_d) != 3) {
        printf("scanf error");
    }

    printf("%d-%d-%d", num_m, num_d, num_y);

    return 0;
}