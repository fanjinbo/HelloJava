package com.fanjinbo.factoryMethod;

/**
 * 普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * 发送消息的工厂类。依靠对应的参数来生产匹配的对象。
 * 这些对象都实现了发送消息的接口
 * @since 2016年11月22日00:21:52
 * @author fanjinbo
 *
 */
public class NormalSendFactory {
	public Sender produce(String type){
		if (type.equals("email")) {
			return new SendEmail();
		}
		else if(type.equals("sms")) {
			return new SendSms();
		}
		else {
			System.out.println("请输入正确的类型");
			return null;
		}
	}
}
