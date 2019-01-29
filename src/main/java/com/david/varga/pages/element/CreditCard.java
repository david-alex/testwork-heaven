package com.david.varga.pages.element;

public class CreditCard {

	private final String ccNumber;
	private final String ccName;
	private final String ccMonth;
	private final String ccYear;
	private final String ccSecurityNumber;
	private final String ccAmount;

	public static class Builder {

		private String ccNumber ="";
		private String ccName = "";
		private String ccMonth = "";
		private String ccYear ="";
		private String ccSecurityNumber ="";
		private String ccAmount = "";

		public Builder ccNumber(String number){
			this.ccNumber = String.valueOf(number);
			return this;
		}

		public Builder ccName(String name) {
			this.ccName = name;
			return this;
		}

		public Builder ccMonth(String month) {
			this.ccMonth = month;
			return this;
		}

		public Builder ccYear(String year) {
			this.ccYear = year;
			return this;
		}

		public Builder ccSecurityNumber(String secNumber) {
			this.ccSecurityNumber = secNumber;
			return this;
		}

		public Builder ccAmount(double amount) {
			this.ccAmount = String.valueOf(amount);
			return this;
		}

		public CreditCard build() {
			return new CreditCard(this);
		}

	}

	private CreditCard(Builder builder) {
		this.ccNumber = builder.ccNumber;
		this.ccName = builder.ccName;
		this.ccMonth = builder.ccMonth;
		this.ccYear = builder.ccYear;
		this.ccSecurityNumber = builder.ccSecurityNumber;
		this.ccAmount = builder.ccAmount;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public String getCcName() {
		return ccName;
	}

	public String getCcMonth() {
		return ccMonth;
	}

	public String getCcYear() {
		return ccYear;
	}

	public String getCcSecurityNumber() {
		return ccSecurityNumber;
	}

	public String getCcAmount() {
		return ccAmount;
	}
}
