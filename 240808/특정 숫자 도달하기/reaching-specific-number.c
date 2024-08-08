#include <stdio.h>

int main() {
    // 여기에 코드를 작성해주세요.
    // 250이하인 애들의 수를 세는 cnt, 들어온지 판단하는 flag
    int cnt = 0;
    int num_cur = 0;
    int sum = 0;
    
    // 배열 입력받기
    for(int i = 0; i < 10; i++) {
        if(scanf("%d", &num_cur) != 1){
            printf("scanf error");
        }
        if(num_cur >= 250) {
            break;
        }

        // 250이하인 경우
        sum += num_cur;
        cnt++;
    }

    // 평균 계산하기
    double avg = (double) sum / cnt;

    printf("%d %.1lf", sum, avg);


    

    return 0;
}