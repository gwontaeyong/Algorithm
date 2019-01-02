import sys

#sys.stdin = open("input.txt", 'r')

T = int(input())

for test_case in range(1, T + 1):
    list_size = int(input())
    list_ = list(map(int, input().split()))

    Min = min(list_)
    Max = max(list_)

    print("#%d %d"%(test_case, Max - Min))
