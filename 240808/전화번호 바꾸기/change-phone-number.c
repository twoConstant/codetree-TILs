#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    // 배열 길이 : 4, 5, 5
    char str_f[4], str_m[5], str_b[5];
    if(scanf("%3s-%4s-%4s", str_f, str_m, str_b) != 3) {
        printf("scanf error");
    };

    printf("%s-%s-%s", str_f, str_b, str_m);

    return 0;
}