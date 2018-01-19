package com.xm.test1;

public abstract class MyServlet {

	public abstract void doGet(MyRequest myRequest,MyResponse myResponse);
	public abstract void doPost(MyRequest myRequest,MyResponse myResponse);
	public void service(MyRequest myRequest,MyResponse myResponse){
		if("GET".equalsIgnoreCase(myRequest.getMethod())){
			doGet(myRequest, myResponse);
		}else if ("POST".equalsIgnoreCase(myRequest.getMethod())) {
			doPost(myRequest, myResponse);
		}
	}
}
