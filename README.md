# Algorithm
Practice Algorithm Code


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
