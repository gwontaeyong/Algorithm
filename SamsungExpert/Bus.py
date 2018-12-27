import sys

'''
input = k, n, m, m_array


k = 버스가 1회 충전시 움직일 수 있는 정거장 수
n = 버스가 가야할 버스 정거장 갯수
m = 충전이 가능한 정거장 갯수
m_array = 충전 가능한 정거장 index

3
3 10 5
1 3 5 7 9
3 10 5
1 3 7 8 9
5 20 5
4 7 9 14 17


'''
sys.stdin = open("sample_input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    k, n, m = map(int, input().split())
    m_array = list(map(int, input().split()))
    m_array.sort(reverse = True)

    count = 0
    pointer = 1

    while pointer < n :
        for busStop in m_array:

            if busStop > pointer + k:
                if busStop == m_array[-1]:
                    count = 0
                    pointer = n + 1
                    break
                else:
                    continue
            else:
                count += 1
                pointer = busStop
                break


    print(count)
