
reactive server
--------------------

https://developer.okta.com/blog/2018/09/21/reactive-programming-with-spring

```bash
mvn clean package

java -jar target/chat-server-1.0-SNAPSHOT.jar
```

reactive client
------

```bash
λ curl -v localhost:8080/v2/chat
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /v2/chat HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
> 
< HTTP/1.1 200 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sun, 07 Apr 2019 01:35:42 GMT
< 
* Connection #0 to host localhost left intact
[{"message":"hi how can i help you"},{"message":"Please see stuff"},{"message":"whatever"}]
```

TODOs
- see threads usage
- add reactive client project example