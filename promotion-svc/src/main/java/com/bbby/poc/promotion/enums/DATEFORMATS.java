package com.bbby.poc.promotion.enums;

public enum DATEFORMATS {
	ddMMyyyyhhmmss("ddMMyyyyhhmmss"), yyyyMMddhhmmssSSS("yyyyMMddhhmmssSSS"), ddMMyy(
			"ddMMyy"), ssSSS("ssSSS"), SSS("SSS"), bookingDashboard(
			"yyyy-MM-dd HH:mm:ss"), bookingDashboardSecond("dd-MMM-yyyy"), MMddyyyy(
			"MM/dd/yyyy"), MMMddyyyy("MMM dd, yyyy"),dd_MM_yyyy("dd/MM/yyyy");
	private String formatString;

	DATEFORMATS(String formatString) {
		this.setFormatString(formatString);
	}

	/**
	 * @return the formatString
	 */
	public String getFormatString() {
		return formatString;
	}

	/**
	 * @param formatString
	 *            the formatString to set
	 */
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
}
