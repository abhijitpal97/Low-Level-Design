package com.example.pojo;

public class Message {
	private int sender;
	private String msg;

	public Message(int sender, String msg) {
		super();
		this.sender = sender;
		this.msg = msg;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", msg=" + msg + "]";
	}




}
