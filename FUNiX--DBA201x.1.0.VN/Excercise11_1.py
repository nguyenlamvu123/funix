def isPrime(n):
    if n < 1:
        return False
    if n > 4:
        for i in range(2, int(n/2)):
            if n % i == 0:
                return False
    else:
        if n == 4:
            return False
    return True
