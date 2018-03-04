# finatra-client
Finatra HttpClient wrapper


# Usage

```Scala

val client = HttpClient("localhost:8080")
client.get("/hi")
// res0: com.twitter.util.Future[com.twitter.finagle.http.Response] 

val payload: String = ???
client.post("ping", payload)
res1: com.twitter.util.Future[com.twitter.finagle.http.Response] 

```
