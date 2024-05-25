a = int(input())
que = list()
for _ in range(a):
    que.append(input())
k = int(input())
for _ in range(k):
    phantudautien = que.pop(0)
    que.append(phantudautien)
print(' '.join(que))
