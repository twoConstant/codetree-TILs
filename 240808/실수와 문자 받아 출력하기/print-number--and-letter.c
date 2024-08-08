#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    char chr_input;
    double num1_input, num2_input;
    scanf("%c %lf %lf", &chr_input, &num1_input, &num2_input);
    printf("%c\n%.2lf\n%.2lf", chr_input, num1_input, num2_input);

    return 0;
}