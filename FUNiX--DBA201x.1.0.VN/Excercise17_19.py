n = input()
a = list()
for _ in range(int(n)):
    aa = input()
    if aa not in a:
        a.append(aa)
tinnhanluuduoc = input()
print(' '.join(a[-int(tinnhanluuduoc):]))
