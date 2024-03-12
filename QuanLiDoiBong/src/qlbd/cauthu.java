package qlbd;

import java.io.Serializable;

public class cauthu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final long serialVersion=1L;
	private String ten,ngaysinh,quoctich,vitri,ngaygianhap;
	private double tienluong;
	public cauthu(String ten, String ngaysinh,String vitri,String quoctich,String ngaygianhap,double tienluong) {
		this.ten=ten;
		this.ngaysinh=ngaysinh;
		this.quoctich=quoctich;
		this.vitri=vitri;
		this.ngaygianhap=ngaygianhap;
		this.tienluong=tienluong;
	}
	public cauthu() {
		
	}
	public String getten() {
		return ten;
	}
	public void setten(String ten) {
		this.ten = ten;
	}
	public String getngaysinh() {
		return ngaysinh;
	}
	public void setngaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getquoctich() {
		return quoctich;
	}
	public void setquoctich(String quoctich) {
		this.quoctich = quoctich;
	}
	public String getvitri() {
		return vitri;
	}
	public void setvitri(String vitri) {
		this.vitri = vitri;
	}
	public String getngaygianhap() {
		return ngaygianhap;
	}
	public void setngaygianhap(String ngaygianhap) {
		this.ngaygianhap = ngaygianhap;
	}
	public double gettienluong() {
		return tienluong;
	}
	public void settienluong(double tienluong) {
		this.tienluong = tienluong;
	}
	public void setcaulacbo(String string) {
		// TODO Auto-generated method stub
		
	}
	public String getcaulacbo() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
