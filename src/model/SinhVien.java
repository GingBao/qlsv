package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SinhVien implements Serializable{
	private Double MaSV;
	private String TenSV;
	private Khoa khoa;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String email;
	private double GPA;
	private Tinh queQuan;
	
	
	
	public SinhVien() {
	}


	public SinhVien(Double maSV, String tenSV, Khoa khoa, Date ngaySinh, boolean gioiTinh, String email, double gPA,
			Tinh queQuan) {
		this.MaSV = maSV;
		this.TenSV = tenSV;
		this.khoa = khoa;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.GPA = gPA;
		this.queQuan = queQuan;
	}


	public Double getMaSV() {
		return MaSV;
	}

	public void setMaSV(Double maSV) {
		MaSV = maSV;
	}

	public String getTenSV() {
		return TenSV;
	}

	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}

	public Khoa getKhoa() {
		return khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public Tinh getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}

	@Override
	public String toString() {
		return "SinhVien [MaSV=" + MaSV + ", TenSV=" + TenSV + ", khoa=" + khoa + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", email=" + email + ", GPA=" + GPA + ", queQuan=" + queQuan + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(GPA, MaSV, TenSV, email, gioiTinh, khoa, ngaySinh, queQuan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Double.doubleToLongBits(GPA) == Double.doubleToLongBits(other.GPA) && Objects.equals(MaSV, other.MaSV)
				&& Objects.equals(TenSV, other.TenSV) && Objects.equals(email, other.email)
				&& gioiTinh == other.gioiTinh && Objects.equals(khoa, other.khoa)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(queQuan, other.queQuan);
	}
	
	

	
	
	
	
	
	
}
