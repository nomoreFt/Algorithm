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

#20201203
PrimeNum 에라토스테네스의 채를 이용하여 소수 문제 풀기

#20201204
에라토스테네스의 채 응용하는 골드바흐문제 해결
key : 짝수 - 홀수 = 홀수   

#2020121
순열 다음 수, 이전 수 구하기
swap 무작위 전체순열
visited 순서 전체순열

#20201228
모든 순열, 다음 순열, 이전 순열, 조합 구하기 완료

#20210113
비트연산, 비트마스크 문제 풀기

[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api/badge?name=nomoreft)](https://velog.io/@nomoreft)

[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api?name=nomoreft)](https://github.com/nomoreFt/Algorithm)


NQueen
