package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import service.UserService;
import service.impl.UserServiceImpl;

public class JdkProxy implements InvocationHandler {
private Object target=null;

public Object bind(Object target){
	this.target=target;
	return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this); 

}
@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	// TODO Auto-generated method stub
	Object obj = null;
	if("queryAll".equals(method.getName())) {
		obj = method.invoke(target, args);
	}else {
		System.out.println("进入"+method.getName()+"方法");
		//手动调用(放行)
		obj = method.invoke(target, args);
		System.out.println("离开"+method.getName()+"方法");
	}
	return obj;
}
	
}
