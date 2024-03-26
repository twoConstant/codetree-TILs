n = 4
arr = [list(map(int, input().split())) for _ in range(0, 4)]

for i in range(0, n):
    print(sum(arr[i]))