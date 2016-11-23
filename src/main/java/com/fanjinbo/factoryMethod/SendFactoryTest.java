package com.fanjinbo.factoryMethod;

public class SendFactoryTest {
	public static void main(String[] args) {
		NormalSendFactory sendFactory = new NormalSendFactory();
		Sender email = sendFactory.produce("email");
		email.send();
		Sender smSender = sendFactory.produce("sms");
		smSender.send();
		sendFactory.produce("test");
	}
}
