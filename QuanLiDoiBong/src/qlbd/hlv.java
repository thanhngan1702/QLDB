package qlbd;

import java.io.Serializable;

public class hlv implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final long serialVersion=1L;
	private String tenhlv,ngaysinhhlv,ngaygianhaphlv;
	private double tienluonghlv;
	public hlv(String tenhlv, String ngaysinhhlv,String ngaygianhaphlv,double tienluonghlv) {
		this.tenhlv=tenhlv;
		this.ngaysinhhlv=ngaysinhhlv;
		this.ngaygianhaphlv=ngaygianhaphlv;
		this.tienluonghlv=tienluonghlv;
	}
	public hlv() {
		
	}
	public String gettenhlv() {
		return tenhlv;
	}
	public void settenhlv(String tenhlv) {
		this.tenhlv = tenhlv;
	}
	public String getngaysinhhlv() {
		return ngaysinhhlv;
	}
	public void setngaysinhhlv(String ngaysinhhlv) {
		this.ngaysinhhlv = ngaysinhhlv;
	}
	public String getngaygianhaphlv() {
		return ngaygianhaphlv;
	}
	public void setngaygianhaphlv(String ngaygianhaphlv) {
		this.ngaygianhaphlv = ngaygianhaphlv;
	}
	public double gettienluonghlv() {
		return tienluonghlv;
	}
	public void settienluong(double tienluonghlv) {
		this.tienluonghlv = tienluonghlv;
	}
	public static long getSerialversion() {
		return serialVersion;
	}

}
