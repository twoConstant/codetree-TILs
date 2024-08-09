#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    char arr_chr[100];
    scanf("%[^\n]", arr_chr);

    for(int i = 2; i < 10; i++) {
        printf("%c", arr_chr[i]);
    }
    return 0;
}