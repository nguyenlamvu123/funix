def primeSum(n):
    daysonguyento: list = list()
    for songuyento in range(2, n + 1):
        for i in range(2, int(songuyento / 2) + 1):
            if songuyento % i == 0:
                break
        else:
            daysonguyento.append(songuyento)
    return sum(daysonguyento)
