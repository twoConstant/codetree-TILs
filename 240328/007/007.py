class info:
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c


line = list(input().split())
# print(line)
info1 = info(line[0], line[1], line[2])
print(f"secret code : {info1.a}\nmeeting point : {info1.b}\ntime : {info1.c}")