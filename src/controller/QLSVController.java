package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Khoa;
import model.SinhVien;
import model.Tinh;
import view.StudentManagerView;

public class QLSVController implements ActionListener{
	public StudentManagerView studentManagerView;
	
	public QLSVController(StudentManagerView studentManagerView) {
		this.studentManagerView = studentManagerView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand=e.getActionCommand();
//		JOptionPane.showMessageDialog(studentManagerView, "Bạn vừa nhấn vào:"+actionCommand);
		if(actionCommand.equals("Thêm")) {
			try {
				this.studentManagerView.thucHienThemSinhVien();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			this.studentManagerView.XoaForm();
			this.studentManagerView.model.setLuaChon("Thêm");
			
		}else if(actionCommand.equals("Lưu")) {
			try {
				this.studentManagerView.thucHienThemSinhVien();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}else if(actionCommand.equals("Cập Nhật")) {
			this.studentManagerView.hienThiThongTinSinhVienDaChon();
		}else if(actionCommand.equals("Xóa")) {
			this.studentManagerView.xoaThongTin();
		}else if(actionCommand.equals("Hủy Bỏ")) {
			this.studentManagerView.XoaForm();
		}else if(actionCommand.equals("Tìm")) {
			this.studentManagerView.thucHienTim();
		}else if(actionCommand.equals("Hủy Tìm")) {
			this.studentManagerView.thucHienTaiLaiDuLieu();
		}else if(actionCommand.equals("About me")) {
			this.studentManagerView.hienThiAbout();
		}else if(actionCommand.equals("Exit")) {
			this.studentManagerView.thoatKhoiChuongTrinh();
		}else if(actionCommand.equals("Save")) {
			this.studentManagerView.thucHienSaveFile();
		}else if(actionCommand.equals("Open")) {
			this.studentManagerView.thucHienOpenFile();
		}
	}

}
