#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    double num_input_ft;
    double num_cm;
    const double ft_to_cm = 30.48;
    scanf("%lf", &num_input_ft);
    num_cm = num_input_ft * ft_to_cm;
    printf("%.1lf", num_cm);
    return 0;
}