import sys

sys.stdin = open("sample_input.txt", "r")


T = int(input())
A = [i for i in range(1, 13)]
result = []
print(sum(A))

for test_case in range(T):
    N, k = map(int, input().split())
    K = allsubsets(A);
