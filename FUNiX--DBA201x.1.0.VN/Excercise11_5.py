def lastDigitDiffZero(n):
    tich = 1
    for gt in range(2, n + 1):
        tich *= gt
    lastindex = -1
    while str(tich)[lastindex] == '0':
        lastindex -= 1
    return int(str(tich)[lastindex])
