#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    int n;
    scanf("%d", &n);
    double arr_grade[5] = {0};
    int len = n;
    double sum = 0;
    double avg = 0;

    // 배열 입력 받기
    for(int i = 0; i < len; i++) {
        scanf("%lf", &arr_grade[i]);
        sum += arr_grade[i];
    }

    avg = (double) sum / len;
    printf("%.1lf\n", avg);
    
    switch((int) avg / 1) {
        case 4:
            printf("Perfect");
            break;
        case 3:
            printf("Good");
            break;
        default:
            printf("Poor");
            break;
    }



    return 0;
}