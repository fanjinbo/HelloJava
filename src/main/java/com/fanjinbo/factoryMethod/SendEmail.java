package com.fanjinbo.factoryMethod;

/**
 * 发送邮件的实现方法
 * @since 2016年11月22日00:20:04
 * @author fanjino
 *
 */
public class SendEmail implements Sender{
	public void send(){
		System.out.println("这是邮件发送方法");
	}
}
