## What problems do coroutines solve

- 코루틴은 오래 걸리는 일들이 메인 스레들에서 블록하는 것을 막하준다.
- suspend 함수는 메인 스래드에서 불릴 수 있다.

## Long running tasks

- 해결책
    - Callbacks
    - Rx
    - Coroutines
    
## 코루틴 철학

- 코루틴은 비동기적 코드를 동기적 코드와 유사하게 콜백 로직을 적용해서 처리한다.

## 코루틴 예약어

- suspend : 현재 코루틴 실행을 일시중지하고 모든 로컬 변수를 저장한다.
- resume : 정지된 위치부터 정지된 코루틴을 계속 실행한다.

## 예시

```kotlin
// Running on Main Thread
suspend fun fetchDocs() {
    val result = get("...")
    show(result)
}
```

```kotlin
// Running On Background Thread
suspend fun fetchDocs() {
    val result = get("...")
    withContext(Dispatchers.IO){
        show(result)
    }
}
```



