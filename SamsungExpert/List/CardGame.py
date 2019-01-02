import sys
'''
3
5
49679
5
08271
10
7797946543

'''
sys.stdin = open("sample_input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    card_size = int(input())
    cards = input()

    checks = {}

    for i in range(0, len(cards)):
        if cards[i] in checks.keys():
            checks[cards[i]] += 1
        else:
            checks[cards[i]] = 1

    card = list(checks.keys())[0]
    max_value =  checks[list(checks.keys())[0]]
    #print(card)
    #print(max_value)

    for i in list(checks)[1:]:

        if max_value < checks[i]:
            card = i
            max_value = checks[i]
        elif max_value == checks[i]:
            if card < i:
                card = i

    print("#%d %s %s"%(test_case, card, max_value))
