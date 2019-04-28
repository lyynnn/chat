package com.nan.chat;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;

@ServerEndpoint("/websocket")	//websocket的端点
public class ChatServer {
/*
 * 用户接入
 */
@OnOpen	
public void onOpen(Session session){
	System.out.println("hhhhhhhhhhhhhhhh");
}

/*
 * 接受来自用户的信息
 */
@OnMessage
public void onMessage(String message,Session session){
	System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
	System.out.println(message);
	session.getAsyncRemote().sendText("我是服务器");
}
/*
 * 发生异常
 */
@OnError
public void onError(Throwable e){
	System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKK");
}
}
