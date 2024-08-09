#include <stdio.h>
#include <string.h>


int main() {
    // 여기에 코드를 작성해주세요.
    char arr1_chr[100], arr2_chr[100];
        scanf("%s%s", arr1_chr, arr2_chr);
    
    printf("%d\n", strlen(arr1_chr) + strlen(arr2_chr));
    return 0;
}