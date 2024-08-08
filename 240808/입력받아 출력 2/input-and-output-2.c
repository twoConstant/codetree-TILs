#include <stdio.h>

int main() {
    // 6자리, 7자리
    char str_f[6 + 1], str_b[7 + 1];
    if(scanf("%6s-%7s", str_f, str_b) != 2) {
        printf("scanf problem");
    }

    printf("%s%s", str_f, str_b);

    return 0;
}