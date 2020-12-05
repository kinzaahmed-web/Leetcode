# memoization approach
# O(N) Time Each number, starting at 2 up to and including N, is visited,
# computed and then stored for O(1) access later on.
# O(N) Space The size of the stack in memory is proportionate to N.
# Memoization is a technique for improving the performance of recursive algorithms
# It involves rewriting the recursive algorithm so that as answers to problems are found,
# they are stored in an array.
# Recursive calls can look up results in the array rather than having to recalculate them
# Memoization improves performance because partial results are never calculated twice
# check n <= 1 if it is, return n
# call and return memoize(N)
# if n exists in the map, return the cached value for N
# otherwise set the value of N in our mapping to the value of
# memoize(N-1) + memoize(N-2)
def fib(N: int) -> int:
    if N <= 1:
        return N

    return memoize(N);

def memoize(N: int) -> {}:
    cache = {
        0:0,
        1:1,
    }

    for i in range(2, N+1):
        cache[i] = cache[i-1] + cache[i-2]

    return cache[N]

#Traditional recursive approach
# O(2^n) Time This is the slowest way to solve the Fibonacci Sequence because it
# takes exponential time. The amount of operations needed,
# for each level of recursion, grows exponentially as the depth approaches N.
# O(N) space We need space proportionate to N to account for the max size of the stack,
# in memory. This stack keeps track of the function calls to fib(N). This has the potential to be
# bad in cases that there isn't enough physical
# memory to handle the increasingly growing stack, leading to a StackOverflowError
def fib_rec(N:int) -> int:
    if N == 0 or N == 1:
        return N;

    return fib_rec(N - 1) + fib_rec(N - 2)

if __name__ == "__main__":
    print(fib(2))
