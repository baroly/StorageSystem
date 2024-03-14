package com.Modal;

public class ProductOrder {
	private String companyOrderNum;
	private String productNum;
	private String productSerialNum;
	private int amount;
	private int internalContent;
	private String fillingDate;
	private String status;

	public ProductOrder(String companyOrderNum, String productNum, String productSerialNum, int amount,
			int internalContent, String status, String fillingDate) {
		super();
		this.companyOrderNum = companyOrderNum;
		this.productNum = productNum;
		this.productSerialNum = productSerialNum;
		this.amount = amount;
		this.internalContent = internalContent;
		this.status = status;
		this.fillingDate = fillingDate;
	}

	public ProductOrder(String productNum, String productSerialNum, int amount, int internalContent, String status) {
		super();
		this.productNum = productNum;
		this.productSerialNum = productSerialNum;
		this.amount = amount;
		this.internalContent = internalContent;
		this.status = status;
	}

	public ProductOrder(String productNum, String productSerialNum, int amount) {
		super();
		this.productNum = productNum;
		this.productSerialNum = productSerialNum;
		this.amount = amount;
	}

	public String getCompanyOrderNum() {
		return companyOrderNum;
	}

	public void setCompanyOrderNum(String companyOrderNum) {
		this.companyOrderNum = companyOrderNum;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getProductSerialNum() {
		return productSerialNum;
	}

	public void setProductSerialNum(String productSerialNum) {
		this.productSerialNum = productSerialNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getInternalContent() {
		return internalContent;
	}

	public void setInternalContent(int internalContent) {
		this.internalContent = internalContent;
	}

	public String getFillingDate() {
		return fillingDate;
	}

	public void setFillingDate(String fillingDate) {
		this.fillingDate = fillingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
