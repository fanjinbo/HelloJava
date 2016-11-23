package com.fanjinbo.factoryMethod;

/**
 * 简单工厂模式，首先创建一个共同的接口
 * 接口中只有一个发送的方法
 * 然后用两个实现类分别来实现发送邮件和发送短信的功能
 * @author fanjinbo
 * @since 2016年11月21日23:57:14
 *
 */
public interface Sender {
	public void send();
}
