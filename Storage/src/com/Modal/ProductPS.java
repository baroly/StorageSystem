package com.Modal;

import java.util.Date;

public class ProductPS {
	private String companyOrderNum;
	private String shipmentVendorName;
	private String invoiceNo;
	private String printBarcodeDate;
	private String fillingDate;
	private Double exchangeRate;
	private String processingStatus;
	private String trackingNum;
	private String orderNum;
	private String offshoreDate;
	private String arrivalDate;
	private String storageTime;
	private int serialNum;
	private String spare1;
	private String spare2;
	private String spare3;
	private String spare4;

	public ProductPS(String companyOrderNum, String shipmentVendorName, String fillingDate) {
		super();
		this.companyOrderNum = companyOrderNum;
		this.shipmentVendorName = shipmentVendorName;
		this.fillingDate = fillingDate;
	}

	public ProductPS(String companyOrderNum, String shipmentVendorName, String invoiceNo, String trackingNum,
			String orderNum, String offshoreDate, String arrivalDate, String storageTime) {
		super();
		this.companyOrderNum = companyOrderNum;
		this.shipmentVendorName = shipmentVendorName;
		this.invoiceNo = invoiceNo;
		this.trackingNum = trackingNum;
		this.orderNum = orderNum;
		this.offshoreDate = offshoreDate;
		this.arrivalDate = arrivalDate;
		this.storageTime = storageTime;
	}

	public ProductPS(String companyOrderNum, String shipmentVendorName, String invoiceNo, Double exchangeRate,
			String trackingNum, String orderNum, String offshoreDate, String arrivalDate) {
		super();
		this.companyOrderNum = companyOrderNum;
		this.shipmentVendorName = shipmentVendorName;
		this.invoiceNo = invoiceNo;
		this.exchangeRate = exchangeRate;
		this.trackingNum = trackingNum;
		this.orderNum = orderNum;
		this.offshoreDate = offshoreDate;
		this.arrivalDate = arrivalDate;
	}

	public ProductPS(String fillingDate, String shipmentVendorName, String companyOrderNum, String trackingNum,
			String invoiceNo, String orderNum, Double exchangeRate, String offshoreDate, String arrivalDate,
			String storageTime) {
		super();
		this.companyOrderNum = companyOrderNum;
		this.shipmentVendorName = shipmentVendorName;
		this.invoiceNo = invoiceNo;
		this.fillingDate = fillingDate;
		this.exchangeRate = exchangeRate;
		this.trackingNum = trackingNum;
		this.orderNum = orderNum;
		this.offshoreDate = offshoreDate;
		this.arrivalDate = arrivalDate;
		this.storageTime = storageTime;
	}

	public ProductPS(String companyOrderNum, String shipmentVendorName, String invoiceNo, String printBarcodeDate,
			String fillingDate, String modifyDate, Double exchangeRate, String processingStatus, String trackingNum,
			String orderNum, String offshoreDate, String arrivalDate, String storageTime, int serialNum) {
		super();
		this.companyOrderNum = companyOrderNum;
		this.shipmentVendorName = shipmentVendorName;
		this.invoiceNo = invoiceNo;
		this.printBarcodeDate = printBarcodeDate;
		this.fillingDate = fillingDate;
		this.exchangeRate = exchangeRate;
		this.processingStatus = processingStatus;
		this.trackingNum = trackingNum;
		this.orderNum = orderNum;
		this.offshoreDate = offshoreDate;
		this.arrivalDate = arrivalDate;
		this.storageTime = storageTime;
		this.serialNum = serialNum;

	}

	public String getCompanyOrderNum() {
		return companyOrderNum;
	}

	public void setCompanyOrderNum(String companyOrderNum) {
		this.companyOrderNum = companyOrderNum;
	}

	public String getShipmentVendorName() {
		return shipmentVendorName;
	}

	public void setShipmentVendorName(String shipmentVendorName) {
		this.shipmentVendorName = shipmentVendorName;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getPrintBarcodeDate() {
		return printBarcodeDate;
	}

	public void setPrintBarcodeDate(String printBarcodeDate) {
		this.printBarcodeDate = printBarcodeDate;
	}

	public String getFillingDate() {
		return fillingDate;
	}

	public void setFillingDate(String fillingDate) {
		this.fillingDate = fillingDate;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getProcessingStatus() {
		return processingStatus;
	}

	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

	public String getTrackingNum() {
		return trackingNum;
	}

	public void setTrackingNum(String trackingNum) {
		this.trackingNum = trackingNum;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOffshoreDate() {
		return offshoreDate;
	}

	public void setOffshoreDate(String offshoreDate) {
		this.offshoreDate = offshoreDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getStorageTime() {
		return storageTime;
	}

	public void setStorageTime(String storageTime) {
		this.storageTime = storageTime;
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

}
