package com.dragon

import com.twitter.finagle.http.{Method, Response, Version}
import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.Future

object Dragon {
  implicit class HttpClient(client: Service[http.Request, http.Response]) {

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



}

