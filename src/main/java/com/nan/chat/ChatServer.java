package com.nan.chat;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.HandshakeResponse;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.nan.pojo.Groupuser;
import com.nan.service.groupuser.GroupuserServiceImpl;
import com.nan.service.groupuser.IgroupuserService;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.server.ServerEndpointConfig;
/**
 * 
 * @author nan
 *
 */


@ServerEndpoint(value = "/websocket") 
public class ChatServer{
	@Resource
	private static AtomicInteger onlineCount = new AtomicInteger(0);
	private HttpSession httpSession;
	private static Map<String,Session> routetab = new ConcurrentHashMap<String,Session>();
	
	@Autowired
	private IgroupuserService groupServer;
	
	
	
	//implemet set get method of GroupServer
	//implemet  method of GroupServer:
	//String[] users getMembersByGroupId(String groupid);
	 
	
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		String id=session.getQueryString();
		String userid = id.substring(id.indexOf("=")+1);
		
		if(userid ==null || "".equals(userid)) {
			// notity this session ,Illegal login
			try {
				session.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {return;}
		}
		synchronized(ChatServer.class) {
			if(routetab.containsKey(userid)) {
				// notity other session close. bei ding hao le。
				try {
					routetab.get(userid).close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				ChatServer.onlineCount.decrementAndGet();
			}
	    	routetab.put(userid, session);
	    	ChatServer.onlineCount.incrementAndGet();
		}
	}
	@OnMessage
	public void onMessage(String message, Session session) {
		// message format :    toUserId:message
		System.out.println(message);
		session.getAsyncRemote().sendText(message);
		broadcast(message);
	}
	@OnError
	public void onError(Throwable e) {
		e.printStackTrace();
	}
	@OnClose
	public void onClose(Session session) { 
		String id=session.getQueryString();
		String userid = id.substring(id.indexOf("=")+1);
		if(userid ==null || "".equals(userid)) {
			// notity this session ,Illegal login
			return;
		}
		routetab.remove(userid);
		ChatServer.onlineCount.decrementAndGet();
	}
	public void broadcast(String message) {
		JSONObject object=JSONObject.parseObject(message);
		System.out.println(object.get("to"));
		Session session = ChatServer.routetab.get(object.get("to"));
		if(session!=null && session.isOpen()) {
			session.getAsyncRemote().sendText(message);
		}

//		String[] users = groupServer.getMembersByGroupId(object.get("to"));
		String to=(String) object.get("to");
//		String[] users=groupServer.getGroupuserById(to);
		List<Groupuser> users = groupServer.getGroupuserById(to);
		if(users==null)return;
		for(Object user: users){
			Session session1 = ChatServer.routetab.get(object.get(user));
			if(session1!=null && session1.isOpen()) {
				session1.getAsyncRemote().sendText(message); 
			}
		}			
	}
	
}


