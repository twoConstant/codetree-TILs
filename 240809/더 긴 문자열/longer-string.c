#include <stdio.h>
#include <string.h>

int main() {
    // 여기에 코드를 작성해주세요.
    char arr1_chr[20], arr2_chr[20];
        if(scanf("%s%s", arr1_chr, arr2_chr) != 2) {
            printf("scanf error");
        };
    int num_len1, num_len2;
    num_len1 = strlen(arr1_chr);
    num_len2 = strlen(arr2_chr);

    if(num_len1 > num_len2) {
        printf("%s %d", arr1_chr, num_len1);
    } else if(num_len1 == num_len2) {
        printf("same\n");
    } else {
        printf("%s %d", arr2_chr, num_len2);
    }
    return 0;
}