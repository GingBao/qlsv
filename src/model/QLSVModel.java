package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<SinhVien> dsSinhVien;
	private String luaChon;
	private String tenFile;

	public QLSVModel() {
		this.dsSinhVien = new ArrayList<SinhVien>();
		this.luaChon="";
		this.tenFile="";
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public QLSVModel(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = new ArrayList<SinhVien>();
	}

	public ArrayList<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	
	public void insert(SinhVien sinhVien) {
		this.dsSinhVien.add(sinhVien);
	}
	
	public void delete(SinhVien sinhVien) {
		for(SinhVien sinhvien:dsSinhVien) {
			if(sinhvien.getMaSV()==sinhVien.getMaSV())
				this.dsSinhVien.remove(sinhvien);
		}
		
	}
	
	public void update(SinhVien sinhVien) {
		this.dsSinhVien.remove(sinhVien);
		this.dsSinhVien.add(sinhVien);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean kiemTraTonTai(SinhVien sv) {
		// TODO Auto-generated method stub
		for (SinhVien sinhVien : dsSinhVien) {
			if(sinhVien.getMaSV()== sv.getMaSV()) {
				return true;
			}
		}
		return false;
	}
	
	
}
