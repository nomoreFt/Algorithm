# Algorithm
Practice Algorithm Code 
.
백준 
## Hash

# map - 
-.entrySet (Key와 Value를 다 가져와서 사용한다. map.get(key)는 다시 search를 해서 찾아오기 때문에 느리다.)
   ```java
 for(Map.Entry<String, Integer> entry : map.entrySet()) {
        	if(entry.getValue() != 0) answer = entry.getKey();
        }
        map.entrySet().forEach(entry -> System.out.println(entry.getKey()));
       ```
-.map.getOrDefault(key, 0) (찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.)  
    ```java
  for(String playerName : participant) {
        	map.put(playerName, map.getOrDefault(playerName, 0) + 1);
        } //키값이 있으면 키 값을 반환하고 없으면 0 반환. (중복 키값일 시 개수만큼 +1, 아니면 1이 들어감)
```
-computeIfAbsent() VS putIfAbsent()
computeIfAbsent() 는 만일 키가 없으면 값을 얻기 위하여 호출하는 매핑된 함수를 가지는 반면, putIfAbsent() 는 value를 바로 가진다. 
그러므로 key의 value는 메소드 호출에서 오고 만일 메소드가 비싸다면(계산이 비용이 많이든다면) putIfAbsent() 는 무조건 계산을 하지만
computeIfAbsent() 는 key를 찾을 수 없지 않는 한 계산을 하지 않는다.


* 기존 배열에서 숫자 개수를 세고 특정 방식으로 정렬 후, entrySet 사용하는 예시

```java
HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nowRow; i++) {
                if (graph[i][j] != 0) {
                    ****map.put(graph[i][j],map.getOrDefault(graph[i][j],0) + 1);****
                    graph[i][j] = 0;
                }
            }
```            


```java
            ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list,(o1,o2) -> {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                } else{
                    return o1.getValue() - o2.getValue();
                }
            });
```

```java
            for (Map.Entry<Integer, Integer> m : list) {
                if (idx < 100) {
                    graph[idx][j] = m.getKey();
                    idx += 1;
                    graph[idx][j] = m.getValue();
                    idx++;
                }

```


  ```java
var theKey = "Fish";        

// key가 존재하여도 callExpensiveMethodToFindValue()가 호출된다.
productPriceMap.putIfAbsent(theKey, callExpensiveMethodToFindValue(theKey)); 

// key가 존재한다면 callExpensiveMethodToFindValue()가 결코 호출되지 않는다. 
productPriceMap.computeIfAbsent(theKey, key -> callExpensiveMethodToFindValue(key));

//ex
public void read(String text) {
  for (String word : text.split(" ")) {
    map.computeIfPresent(word, (String key, Integer value) -> ++value);
  }
}

```



# Collection

배열을 오른쪽, 왼쪽으로 한칸씩 옮길 때 사용.
int[][]배열은 작동하지 않으니 Integer[][] 배열로 

```
    static void go(Integer[][] a, int x, int d, int k) {
        if (d == 0) {
            Collections.rotate(Arrays.asList(a[x]), k);
        } else {
            Collections.rotate(Arrays.asList(a[x]), (a[x].length-k));
        }
    }
```


# 객체배열 deepCopy

자바 객체배열은 clone말고 new 생성을 해줘야 deepCopy가 가능하다.

```java
 private static Fish[][] copyFishBoard(Fish[][] origin) {
        
        Fish[][] copy = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copy[i][j] = new Fish(origin[i][j].idx, origin[i][j].dir);
            }
        }
        return copy;
    }
```

# deepCopy 재귀 

객체 이차원 배열로 재귀 상황 발생시 진행 (특정한 경우의 수들을 선택, 선택하지 않을 경우 각각 파생되는 경우의 수 처리)

```java
 private static void solution(Fish[][] fishBoard, Shark now, int cur){
        int nX = now.x + dx[now.dir];
        int nY = now.y + dy[now.dir];
        while(0 <= nX && nX < 4 && 0 <= nY && nY < 4){
            //fishBoard의 idx가 0이면 빈칸
            if (fishBoard[nX][nY].idx != 0) {
                //앞서 조건이 변경될 경우의 처리 진행 ex) nX,nY좌표의 공백 처리
                Fish temp = fishBoard[nX][nY];
                int value = cur +temp.idx;
                fishBoard[nX][nY] = new Fish(0,0);
                max = Math.max(max, value);

                //Fish[][] deepCopy, 옮긴 상어위치,  상황별로 개별 작동시키기 위해 현재까지 섭취한 값
                solution(copyFishBoard(fishBoard), new Shark(nX,nY,temp.dir), value);
                
                //상황 종료 후 원상복구
                fishBoard[nX][nY] = temp;
            }
            nX += dx[now.dir];
            nY += dy[now.dir];
        }
    }
```


# Sort

무언가 정렬할 경우, 보통 primitive type(int, char 등) 으로 받는다.
그럴 경우 boxed 해서 Collection으로 만들자. sorting 하기 편하다.

```java
List<Long> collect = Arrays.stream(A).boxed().collect(Collectors.toList());
```

## Comparator 구현

Collection으로 변경했으면, 원하는대로 Sorting을 하자

아래 예시는 3을 많이 가지고 있는 경우 (3^n 3으로 나눠서 0이 몇번 나오는지) 내림차순, 같다면 오름차순이다.

Comparator 구현의 꿀팁은
- compare 메소드가 반환하는 값이 음수일 경우, 첫 번째 인자가 두 번째 인자보다 작다는 것을 의미합니다.
- compare 메소드가 반환하는 값이 양수일 경우, 첫 번째 인자가 두 번째 인자보다 크다는 것을 의미합니다.
- compare 메소드가 반환하는 값이 0일 경우, 첫 번째 인자와 두 번째 인자가 같다는 것을 의미합니다.

```java
 collect.sort(new Comparator<Long>(){

            @Override
            public int compare(Long o1, Long o2) {
                int o1Cnt = countDivisibleBy3(o1);
                int o2Cnt = countDivisibleBy3(o2);

                if(o1Cnt <o2Cnt) {
                    return 1;
                }else if(o1Cnt > o2Cnt) {
                    return -1;
                }else {
                    return o1.compareTo(o2);
                }
            }
        });
```


