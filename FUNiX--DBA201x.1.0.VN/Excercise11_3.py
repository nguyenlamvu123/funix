def greatestCommonPrimeDivisor(a,b):
    def timtapuoc(a_):
        uoccuaa = list()
        for i in range(2, int(a_/2) + 1):
            if a_ % i == 0:
                uoccuaa.append(i)
        return uoccuaa
    uoccuaa = timtapuoc(a)
    uoccuab = timtapuoc(b)

    n = min(a, b)
    if n > 5:
        daysonguyento = list()
        for songuyento in range(2, n + 1):
            for i in range(2, int(songuyento/2) + 1):
                if songuyento % i == 0:
                    break
            else:
                daysonguyento.append(songuyento)
    else:
        daysonguyento = [2, 3, 5, ]

    uocchung = [u for u in uoccuaa if u in uoccuab and u in daysonguyento]
    return max(uocchung) if not len(uocchung) == 0 else -1
