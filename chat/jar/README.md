# Demo 3
Spring Boot + Web Socket + STOMP + Kafka

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
    "name": "이름",
    "content": "채팅 메시지"
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
    "name": "이름",
    "content": "채팅 메시지",
    "timestamp": "작성 시간"
}
```
- '/app/hello'로 publish된 메시지는 위와 같은 형식으로 return 된다.
- 작성 시간 format : `YYYY.MM.dd HH:mm`

<br>

## Kafka 테스트 API

```json
POST '/send'

{
  "name": "이름",
  "content": "채팅 메시지"
}
```
위와 같이 POST 요청을 통해 메시지를 publish 할 수도 있다.