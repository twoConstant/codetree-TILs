N = 5
M = 3
arr = [list(input().split()) for _ in range(N)]

for i in range(0, N):
    for j in range(0, M):
        print(arr[i][j].upper(), end= " ")
    print()