#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    char arr[11];
    int len = sizeof(arr) / sizeof(arr[0]) - 1;
    
    for(int i = 0; i < len; i++) {
        if(scanf("%c ", &arr[i]) != 1) {
            printf("scanf error");
            return 1;
        }
    }

    for(int i = 0; i < len; i++) {
        printf("%c", arr[len - i - 1]);
    }

    return 0;
}