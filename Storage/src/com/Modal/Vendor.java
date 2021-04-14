package com.Modal;

public class Vendor {
	private String vendorName;
	private String productPrincipal;
	private String vendorID;

	public Vendor(String vendorName, String productPrincipal, String vendorID) {
		super();
		this.vendorName = vendorName;
		this.productPrincipal = productPrincipal;
		this.vendorID = vendorID;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getProductPrincipal() {
		return productPrincipal;
	}

	public void setProductPrincipal(String productPrincipal) {
		this.productPrincipal = productPrincipal;
	}

	public String getVendorID() {
		return vendorID;
	}

	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}

}
