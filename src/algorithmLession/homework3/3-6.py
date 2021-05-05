mod = 1000000007
d = {1: 1, 2: 1}


def fib(n):
  if n < 3:
    return d[n]

  if n in d:
    return d[n]

  if (n % 2 == 1):
    k = (n + 1) // 2
    x = (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % mod
    d[n] = x # cache

  else:
    k = n // 2
    x = (fib(k) * ((fib(k + 1) * 2) - fib(k))) % mod
    d[n] = x
  return d[n] # cache


for _ in range(int(input())):
  n = int(input())
  print(fib(n + 1))
