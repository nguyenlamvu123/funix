def digitsProduct(p):
    if p == 0: return 10
    for i in range(3600):
        if '0' in str(i):
            continue
        a = 1
        for j in str(i):
            a *= int(j)
        if a == p: return i
    return -1
