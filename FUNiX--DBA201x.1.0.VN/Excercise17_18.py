def songuyento(n):
    if n < 2:
        return False
    for s in range(2, int(n**(1/2)) + 1):
        if n % s == 0:
            return False
    return True

def sieunguyento(n):
    while n > 0:
        if not songuyento(n):
            return False
        n = n // 10
    return True

n = input()
for i in range(2, int(n)):
    if sieunguyento(i):
        print(i, end = " ")
