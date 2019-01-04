import sys
import time
import numpy as np

sys.stdin = open("./sample_input.txt", "r")

'''
3
2
2 2 4 4 1
3 3 6 6 2
3
1 2 3 3 1
3 6 6 8 1
2 3 5 6 2
3
1 4 8 5 1
1 8 3 9 1
3 2 5 8 2
'''
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    colorNum = int(input())
    map_ = [[ [0,0] for i in range(10)]for i in range(10)]
    colorArray = []
    count = 0;


    for i in range(colorNum):
        colorArray.append(list(map(int, input().split())))

    for colorInfo in colorArray:
        # X 좌표
        for x in range(colorInfo[0], colorInfo[2]+1):
            # Y좌표
            for y in range(colorInfo[1], colorInfo[3]+1):
                map_[x][y][colorInfo[4] - 1] = 1


    #print(np.array(map_))

    for x in map_:
        for y in x:
            if y[0] and y[1]:
                count += 1
    print("#%d %d"%(test_case, count))
