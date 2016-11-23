package com.fanjinbo.factoryMethod;

/**
 * 多个工厂方法模式，与普通工厂模式相比，从传递参数构造对象变成了
 * 直接通过方法来构造对象，避免了传递对象过程中的参数错误的问题
 * @author fanjinbo
 * @since 2016年11月22日00:29:14
 *
 */
public class MutiSendFactpry {
	
	public Sender emailProduce(){
		return new SendEmail();
	}
	
	public Sender smsProduce(){
		return new SendSms();
	}
}
