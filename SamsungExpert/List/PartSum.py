import sys
import time

sys.stdin = open("./sample_input.txt", "r")
'''
10 3
1 2 3 4 5 6 7 8 9 10
'''
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    array_size, part = map(int, input().split())
    num_array = list(map(int, input().split()))

    lastNum = array_size - part

    for i in range(lastNum + 1):
        sum = 0

        for j in range(part):
            sum += num_array[j + i]

        if i == 0:
            min, max = sum, sum

        min = min if min < sum else sum
        max = max if max > sum else sum


    print("#%d %d"%(test_case, max - min))
