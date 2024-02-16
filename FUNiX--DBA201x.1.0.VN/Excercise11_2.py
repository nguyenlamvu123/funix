def factorSum(n):
    daysonguyento: list = list()
    if n > 5:
        for songuyento in range(2, n + 1):
            for i in range(2, int(songuyento/2) + 1):
                if songuyento % i == 0:
                    break
            else:
                daysonguyento.append(songuyento)
        tong = n
        while tong not in daysonguyento:
            nn = tong
            tong = 0
            while nn != 1:
                for songuyento in daysonguyento:
                    if nn % songuyento == 0:
                        nn /= songuyento
                        tong += songuyento
                        break
    else:
        tong = n
    return tong
