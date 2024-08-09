#include <stdio.h>
#include <string.h>

int main() {
    // 여기에 코드를 작성해주세요.
    for(int t = 0; t < 2; t++) {
        char arr_chr[100];
        scanf(" %[^\n]", arr_chr);
        int len = strlen(arr_chr);

        for(int i = 0; i < len; i++) {
            if(arr_chr[i] == ' ') {
                continue;
            }

            printf("%c", arr_chr[i]);
        }
    }
    
    return 0;
}