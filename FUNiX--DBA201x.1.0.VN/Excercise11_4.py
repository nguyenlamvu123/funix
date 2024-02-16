def maxFraction(numerators,denominators):
    fra = 0
    ret = 0
    for i, (tu, mau) in enumerate(zip(numerators,denominators)):
        if tu/mau > fra:
            fra = tu/mau
            ret = i
    return ret
