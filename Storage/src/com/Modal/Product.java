package com.Modal;

public class Product {
	private String productSerialNum;
	private String productName;
	private String productSerialNumT;
	private String principal;
	private String status;
	private Integer internalContent;
	private Integer serial;

	public Product(String productSerialNum, String productName, Integer internalContent) {
		super();
		this.productSerialNum = productSerialNum;
		this.productName = productName;
		this.internalContent = internalContent;
	}

	public Product(String productSerialNum, String productName, String status, Integer internalContent,
			Integer serial) {
		super();
		this.productSerialNum = productSerialNum;
		this.productName = productName;
		this.status = status;
		this.internalContent = internalContent;
		this.serial = serial;
	}

	public Product(String productSerialNum, String productSerialNumT, String productName, String principal,
			String status, Integer internalContent) {
		super();
		this.productSerialNumT = productSerialNumT;
		this.productName = productName;
		this.productSerialNum = productSerialNum;
		this.principal = principal;
		this.status = status;
		this.internalContent = internalContent;
	}

	public Product(String productSerialNum, String productName, String principal, String status,
			Integer internalContent) {
		super();
		this.productSerialNum = productSerialNum;
		this.productName = productName;
		this.principal = principal;
		this.status = status;
		this.internalContent = internalContent;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSerialNumT() {
		return productSerialNumT;
	}

	public void setProductSerialNumT(String productSerialNumT) {
		this.productSerialNumT = productSerialNumT;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductSerialNum() {
		return productSerialNum;
	}

	public void setProductSerialNum(String productSerialNum) {
		this.productSerialNum = productSerialNum;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public Integer getInternalContent() {
		return internalContent;
	}

	public void setInternalContent(Integer internalContent) {
		this.internalContent = internalContent;
	}

}
