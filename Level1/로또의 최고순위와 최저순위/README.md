
# 해결 방법

## win_num과 lottos를 먼저 비교해서 몇개 맞았는지 알아야 하고 lottos에 있는 0의 개수를 파악해서 최대/최소 순위를 알 수 있다.
1. 입력된 int 배열을 ArrayList로 변환
2. ArrayList 클래스의 frequency 메소드를 통해 0의 개수를 구함
3. win_num과 lottos의 ArrayList를 통해 당첨 개수를 구함
4. 당첨 개수를 key를 입력하면 해당 당첨 순위 value를 가져올 수 있는 HashMap을 통해 최대/최소 순위를 구함