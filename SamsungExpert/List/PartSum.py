import sys
import time

sys.stdin = open("./sample_input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    array_size, part = map(int, input().split())
    num_array = list(map(int, input().split()))
    max = 0
    min = 0

    for k in range(array_size - part):
        sum = 0
        print("test case %d"%(test_case))
        for i in range(part):
            print(str(k+i))
            sum += num_array[k + i]

        print(sum)
