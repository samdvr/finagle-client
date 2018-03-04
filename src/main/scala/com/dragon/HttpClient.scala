package com.dragon

import com.twitter.finagle.http.{Method, Response, Version}
import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.Future


class HttpClient(hosts: Seq[String]) {
  lazy val client: Service[http.Request, http.Response] = Http.newService(hosts.mkString(","))


  def get(url: String, payload: String = ""): Future[Response] = {
    makeRequest(url, payload, http.Method.Get)
  }


  def post(url: String, payload: String = ""): Future[Response] = {
    makeRequest(url, payload, http.Method.Post)
  }

  def put(url: String, payload: String = ""): Future[Response] = {
    makeRequest(url, payload, http.Method.Put)
  }

  def patch(url: String, payload: String = ""): Future[Response] = {
    makeRequest(url, payload, http.Method.Patch)
  }

  def delete(url: String, payload: String = ""): Future[Response] = {
    makeRequest(url, payload, http.Method.Delete)
  }

  def makeRequest(url: String, payload: String, method: Method) = {
    val request = http.Request(Version.Http11, method, url)
    request.setContentString(payload)
    client(request)
  }
}

object HttpClient {
  def apply(hosts: Seq[String]) = new HttpClient(hosts)

  def apply(hosts: String) = new HttpClient(Seq(hosts))
}

