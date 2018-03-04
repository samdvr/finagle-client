# Finagle Client Wrapper


# Usage

```Scala
import com.dragon._

val client = HttpClient("localhost:8080")
client.get("/hi")
// res0: com.twitter.util.Future[com.twitter.finagle.http.Response] = Promise@2116358064(state=Transforming(WaitQueue(size=0),Future@172928771(depth=2,parent=Promise@

val payload: String = ???
client.post("ping", payload)
// res1: com.twitter.util.Future[com.twitter.finagle.http.Response] = Promise@2045134898(state=Transforming(WaitQueue(size=0),Future@708131124(depth=2,parent=Promise@81223238(sta

```
