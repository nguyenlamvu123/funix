def pagesNumbering(n):
    ret = 0
    for i in range(0, n + 1, 10):
        if n - i < 10:
            ret += len(list(range(i, n + 1))) * len(str(i)) -1
        else:
            ret += 10 * len(str(i))
    return ret
