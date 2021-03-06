package jp.tattyamm.finagle.sample.service

import com.twitter.finagle.Service
import org.jboss.netty.handler.codec.http.{DefaultHttpResponse, HttpResponse, HttpRequest}
import org.jboss.netty.handler.codec.http.HttpVersion._
import org.jboss.netty.handler.codec.http.HttpResponseStatus._
import org.jboss.netty.buffer.ChannelBuffers._
import org.jboss.netty.util.CharsetUtil._
import com.twitter.util.Future
import com.twitter.finagle.http.{Response, Request}

class EchoService extends Service[Request, Response] {
  def apply(request: Request) = {
    val requestMessage = request.getParam("q")

    val response = new DefaultHttpResponse(HTTP_1_1, OK)
    response.setContent(copiedBuffer(requestMessage, UTF_8))
    Future.value(Response(response))
  }
}


