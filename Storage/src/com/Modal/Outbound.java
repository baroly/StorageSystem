package com.Modal;

public class Outbound {
	private String type;
	private String serialNum;
	private String fillingName;
	private String fillingDate;
	private String client;

	public Outbound(String type, String serialNum, String fillingName, String client) {
		super();
		this.type = type;
		this.serialNum = serialNum;
		this.fillingName = fillingName;
		this.client = client;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getFillingName() {
		return fillingName;
	}

	public void setFillingName(String fillingName) {
		this.fillingName = fillingName;
	}

	public String getFillingDate() {
		return fillingDate;
	}

	public void setFillingDate(String fillingDate) {
		this.fillingDate = fillingDate;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
