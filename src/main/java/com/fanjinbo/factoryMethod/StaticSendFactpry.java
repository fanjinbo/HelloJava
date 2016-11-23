package com.fanjinbo.factoryMethod;

/**
 * 静态公共方法模式，与多个工厂方法模式相比的区别为将构建方法变成了静态的，可以直接调用
 * @since 2016年11月22日00:31:24
 * @author fanjinbo
 *
 */
public class StaticSendFactpry {
	public static Sender emailProduce(){
		return new SendEmail();
	}
	
	public static Sender smsProduce(){
		return new SendSms();
	}
}
