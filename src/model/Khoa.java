package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Khoa implements Serializable{
	private int Makh;
	private String TenKhoa;
	public Khoa(int makh, String ten) {
		Makh = makh;
		TenKhoa = ten;
	}
	public int getMakh() {
		return Makh;
	}
	public void setMakh(int makh) {
		Makh = makh;
	}
	public String getTenKh() {
		return TenKhoa;
	}
	public void setTenKh(String ten) {
		TenKhoa = ten;
	}
	@Override
	public String toString() {
		return "Khoa [Makh=" + Makh + ", Ten=" + TenKhoa + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Makh, TenKhoa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Khoa other = (Khoa) obj;
		return Objects.equals(Makh, other.Makh) && Objects.equals(TenKhoa, other.TenKhoa);
	}
	
	public static ArrayList<Khoa> getDSKhoa(){
		String [] arr_Khoa= {"Khoa Quy hoạch đô thị và nông thôn",
							"Khoa Thiết kế mỹ thuật",
							"Khoa Nội thất",
							"Khoa Xây dựng",
							"Khoa Kỹ thuật hạ tầng và Môi trường đô thị",
							"Khoa Quản lý đô thị",
							"Khoa Công nghệ thông tin",
							"Khoa Thời Trang"};
		
		
		ArrayList<Khoa> listKhoa=new ArrayList<Khoa>();
		
		int i = 0;
		for (String tenKhoa : arr_Khoa) {
			Khoa t = new Khoa(i,tenKhoa);
			listKhoa.add(t);
		}
		return listKhoa;
	}
	
	
	public static Khoa getKhoaById(int maKh) {
		return Khoa.getDSKhoa().get(maKh);
	}
	public static Khoa getKhoaByName(String tenKhoa) {
		// TODO Auto-generated method stub
		ArrayList<Khoa> listKhoa =Khoa.getDSKhoa();
		for (Khoa khoa : listKhoa) {
			if(khoa.TenKhoa.equals(tenKhoa))
				return khoa;
		}
		return null;
	}
	
}
