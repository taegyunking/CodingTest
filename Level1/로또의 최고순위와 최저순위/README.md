
# 해결 방법

## win_num과 lottos를 먼저 비교해서 몇개 맞았는지 알아야 하고 lottos에 있는 0의 개수를 파악해서 최대/최소 순위를 알 수 있다.
1. HashMap을 통해 key 값으로 lottos 값 중 0이 아닌 것만 저장. 이때 0의 갯수도 함께 구함
2. win_num과 HashMap에 저장된 key 값을 비교해서 당첨 개수를 구함
3. 당첨 개수에 다른 rank를 저장한 1차원 배열에서 최대/최소 순위 return