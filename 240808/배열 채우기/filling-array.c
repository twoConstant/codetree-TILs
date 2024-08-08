#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    int arr_num[10] = {0};
    int len = sizeof(arr_num) / sizeof(arr_num[0]);
    int cnt = 0;

    for(int i = 0; i < len; i++) {
        scanf("%d", &arr_num[i]);

        if(arr_num[i] == 0) break;

        cnt++;
    }

    for(int i = 0; i < cnt; i++) {
        printf("%d ", arr_num[cnt - 1 - i]);
    }

    return 0;
}