#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    char arr_chr[100];
    char chr;
        if(scanf("%[^\n] %c", arr_chr, &chr) != 2) {
            printf("scanf error");
        }
    // arr를 순회하면서 chr와 일치하는 개수를 구하기
    int cnt = 0;
    for(int i = 0; i < 100; i++) {
        if(arr_chr[i] == '\0'){
            break;
        }

        if(arr_chr[i] == chr) {
            cnt++;
        }
    }

    printf("%d", cnt);


    

    return 0;
}