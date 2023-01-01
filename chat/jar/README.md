# Demo 1
Spring Boot + Web Socket + STOMP

<br>

## 소켓 연결
```
/ws
```

<br>

## 메시지 발행 (Pub)
```
/app/hello
```
<br>

### Request
```json
{
    "name": "이름"
}
```
위와 같은 형식으로 메시지를 publish 한다.

<br>

## 토픽 구독 (Sub)
```
/topic/greetings
```

<br>

### Response
```json
{
    "content": "Hello, {{name}}!"
}
```
'/app/hello'로 publish된 메시지는 위와 같은 형식으로 return 된다.