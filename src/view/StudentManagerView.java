package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Khoa;
import model.QLSVModel;
import model.SinhVien;
import model.Tinh;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;

public class StudentManagerView extends JFrame {

	private JPanel contentPane_NhapDiem;
	public QLSVModel model;
	public JMenuBar menuBar;
	public JTextField textField_sinhVien_timKiem;
	public JTable table;
	public JTextField textField_masv;
	public JTextField textField_tensv;
	public JTextField textField_ngaysinh;
	public JTextField textField_email;
	public JTextField textField_diem_gpa;
	public JComboBox comboBox_Khoa;
	public ButtonGroup buttonGroup_gioiTinh;
	public JComboBox comboBox_queQuan;
	public JRadioButton button_Nam;
	public JRadioButton button_Nu;
	private JComboBox comboBox_khoa_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagerView frame = new StudentManagerView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentManagerView() {
		
		this.model =new QLSVModel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Nơi tải lung tung\\pngtree-student-glyph-black-icon-png-image_691145.jpg"));
		setTitle("Quản Lý Sinh Viên");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 537);
		
		ActionListener actionListener=new QLSVController(this);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_file = new JMenu("File");
		menu_file.addActionListener(actionListener);
		menuBar.add(menu_file);
		
		JMenuItem menuItem_open = new JMenuItem("Open");
		menuItem_open.addActionListener(actionListener);
		menu_file.add(menuItem_open);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(actionListener);
		menu_file.add(mntmSave);
		
		JSeparator separator = new JSeparator();
		menu_file.add(separator);
		
		JMenuItem menuItem_exit = new JMenuItem("Exit");
		menuItem_exit.addActionListener(actionListener);
		menu_file.add(menuItem_exit);
		
		JMenu menu_about = new JMenu("About");
		menu_about.addActionListener(actionListener);
		menuBar.add(menu_about);
		
		JMenuItem mntmAboutMe = new JMenuItem("About Me");
		mntmAboutMe.addActionListener(actionListener);
		menu_about.add(mntmAboutMe);
		contentPane_NhapDiem = new JPanel();
		contentPane_NhapDiem.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_NhapDiem);
		contentPane_NhapDiem.setLayout(null);
		
		JLabel label_khoa = new JLabel("Khoa");
		label_khoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_khoa.setBounds(22, 11, 42, 19);
		contentPane_NhapDiem.add(label_khoa);
		
		JLabel label_khoa_1 = new JLabel("Mã Sinh Viên");
		label_khoa_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_khoa_1.setBounds(338, 11, 86, 19);
		contentPane_NhapDiem.add(label_khoa_1);
		
		textField_sinhVien_timKiem = new JTextField();
		textField_sinhVien_timKiem.setBounds(434, 11, 239, 20);
		contentPane_NhapDiem.add(textField_sinhVien_timKiem);
		textField_sinhVien_timKiem.setColumns(10);
		
		JButton btn_timKiem = new JButton("Tìm");
		btn_timKiem.addActionListener(actionListener);
		btn_timKiem.setBounds(696, 10, 89, 23);
		contentPane_NhapDiem.add(btn_timKiem);
		
		comboBox_khoa_timKiem = new JComboBox();
		ArrayList<Khoa> listKhoa=Khoa.getDSKhoa();
		comboBox_khoa_timKiem.addItem("");
		for (Khoa khoa : listKhoa) {
			comboBox_khoa_timKiem.addItem(khoa.getTenKh());
		}
		
		comboBox_khoa_timKiem.setBounds(74, 10, 239, 22);
		contentPane_NhapDiem.add(comboBox_khoa_timKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 39, 871, 2);
		contentPane_NhapDiem.add(separator_1);
		
		JLabel label_khoa_2 = new JLabel("Danh Sách Sinh Viên");
		label_khoa_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_khoa_2.setBounds(22, 51, 127, 19);
		contentPane_NhapDiem.add(label_khoa_2);
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 81, 885, 177);
		contentPane_NhapDiem.add(scrollPane);
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Sinh Viên", "Tên Sinh Viên","Giới Tính", "Ngày Sinh", "Quê Quán", "Khoa", "GPA", "Email",
			}
		));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 269, 871, 2);
		contentPane_NhapDiem.add(separator_2);
		
		JLabel label_khoa_2_1 = new JLabel("Thông Tin Sinh Viên");
		label_khoa_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_khoa_2_1.setBounds(22, 280, 127, 19);
		contentPane_NhapDiem.add(label_khoa_2_1);
		
		JLabel label_masv = new JLabel("Mã Sinh Viên");
		label_masv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_masv.setBounds(22, 310, 89, 19);
		contentPane_NhapDiem.add(label_masv);
		
		JLabel label_tensv = new JLabel("Tên Sinh Viên");
		label_tensv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_tensv.setBounds(22, 340, 89, 19);
		contentPane_NhapDiem.add(label_tensv);
		
		JLabel label_ngaysinh = new JLabel("Ngày Sinh");
		label_ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_ngaysinh.setBounds(22, 370, 86, 19);
		contentPane_NhapDiem.add(label_ngaysinh);
		
		textField_masv = new JTextField();
		textField_masv.setColumns(10);
		textField_masv.setBounds(115, 310, 239, 20);
		contentPane_NhapDiem.add(textField_masv);
		
		textField_tensv = new JTextField();
		textField_tensv.setColumns(10);
		textField_tensv.setBounds(115, 340, 239, 20);
		contentPane_NhapDiem.add(textField_tensv);
		
		textField_ngaysinh = new JTextField();
		textField_ngaysinh.setColumns(10);
		textField_ngaysinh.setBounds(115, 370, 239, 20);
		contentPane_NhapDiem.add(textField_ngaysinh);
		
		JLabel label_queQuan = new JLabel("Quê Quán");
		label_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_queQuan.setBounds(441, 310, 89, 19);
		contentPane_NhapDiem.add(label_queQuan);
		
		JLabel label_email = new JLabel("Email");
		label_email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_email.setBounds(441, 343, 89, 19);
		contentPane_NhapDiem.add(label_email);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(544, 340, 239, 20);
		contentPane_NhapDiem.add(textField_email);
		
		
		textField_diem_gpa = new JTextField();
		textField_diem_gpa.setColumns(10);
		textField_diem_gpa.setBounds(544, 370, 239, 20);
		contentPane_NhapDiem.add(textField_diem_gpa);
		
		JLabel label_Khoa = new JLabel("Khoa");
		label_Khoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_Khoa.setBounds(22, 400, 89, 19);
		contentPane_NhapDiem.add(label_Khoa);
		
		comboBox_Khoa = new JComboBox();
		comboBox_Khoa.addItem("");
		for (Khoa khoa : listKhoa) {
			comboBox_Khoa.addItem(khoa.getTenKh());
		}
		comboBox_Khoa.setBounds(115, 401, 239, 22);
		contentPane_NhapDiem.add(comboBox_Khoa);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(actionListener);
		btn_them.setBounds(84, 442, 89, 23);
		contentPane_NhapDiem.add(btn_them);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(actionListener);
		btn_xoa.setBounds(240, 442, 89, 23);
		contentPane_NhapDiem.add(btn_xoa);
		
		JButton btn_capnhat = new JButton("Cập Nhật");
		btn_capnhat.addActionListener(actionListener);
		btn_capnhat.setBounds(394, 442, 89, 23);
		contentPane_NhapDiem.add(btn_capnhat);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.addActionListener(actionListener);
		btn_luu.setBounds(555, 442, 89, 23);
		contentPane_NhapDiem.add(btn_luu);
		
		JButton btn_huy = new JButton("Hủy Bỏ");
		btn_huy.addActionListener(actionListener);
		btn_huy.setBounds(709, 442, 89, 23);
		contentPane_NhapDiem.add(btn_huy);
		
		JLabel label_gioiTinh = new JLabel("Giới Tính");
		label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_gioiTinh.setBounds(441, 403, 89, 19);
		contentPane_NhapDiem.add(label_gioiTinh);
		
		button_Nam = new JRadioButton("Nam");
		button_Nam.setBounds(544, 399, 109, 23);
		contentPane_NhapDiem.add(button_Nam);
		
		button_Nu = new JRadioButton("Nữ");
		button_Nu.setBounds(674, 398, 109, 23);
		contentPane_NhapDiem.add(button_Nu);
		
		buttonGroup_gioiTinh=new ButtonGroup();
		buttonGroup_gioiTinh.add(button_Nam);
		buttonGroup_gioiTinh.add(button_Nu);
		
		JLabel label_gpa = new JLabel("GPA");
		label_gpa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_gpa.setBounds(441, 373, 89, 19);
		contentPane_NhapDiem.add(label_gpa);
		
		ArrayList<Tinh> listTinh=Tinh.getDSTinh();
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(544, 307, 239, 22);
		contentPane_NhapDiem.add(comboBox_queQuan);
		
		JButton btn_huyTim = new JButton("Hủy Tìm");
		btn_huyTim.addActionListener(actionListener);
		btn_huyTim.setBounds(806, 10, 89, 23);
		contentPane_NhapDiem.add(btn_huyTim);
		
		this.setVisible(true);
	}

	public void XoaForm() {
		// TODO Auto-generated method stub
		textField_masv.setText("");
		textField_tensv.setText("");
		textField_ngaysinh.setText("");
		textField_email.setText("");
		textField_diem_gpa.setText("");
		comboBox_Khoa.setSelectedIndex(-1);
		comboBox_queQuan.setSelectedIndex(-1);
		buttonGroup_gioiTinh.clearSelection();
	}
	
	public void themSinhVienVaoTable(SinhVien sv) {
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {sv.getMaSV()+"",
				sv.getTenSV(),
				(sv.isGioiTinh()?"Nam":"Nữ"),
				sv.getNgaySinh().getDate()+"/"+sv.getNgaySinh().getMonth()+"/"+(sv.getNgaySinh().getYear()+1900),
				sv.getQueQuan().getTenTinh()+"",
				sv.getKhoa().getTenKh()+"",
				sv.getGPA()+"",
				sv.getEmail()+"",
				});
	}
	
	

	public void themHoacCapNhatSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(sv)) {
			this.model.insert(sv);
		model_table.addRow(new Object[] {sv.getMaSV()+"",
									sv.getTenSV(),
									(sv.isGioiTinh()?"Nam":"Nữ"),
									sv.getNgaySinh().getDate()+"/"+sv.getNgaySinh().getMonth()+"/"+(sv.getNgaySinh().getYear()+1900),
									sv.getQueQuan().getTenTinh()+"",
									sv.getKhoa().getTenKh()+"",
									sv.getGPA()+"",
									sv.getEmail()+"",
									});
		
		
		}else {
			this.model.update(sv);
			int soLuongDong= model_table.getRowCount();
			for(int i=0;i<soLuongDong;i++) {
				String id= model_table.getValueAt(i, 0)+"";
				if(id.equals(sv.getMaSV())) {
					model_table.setValueAt(sv.getMaSV()+"",i,0);
					model_table.setValueAt(sv.getTenSV()+"",i,1);
					model_table.setValueAt((sv.isGioiTinh()?"Nam":"Nữ")+"",i,2);
					model_table.setValueAt(sv.getNgaySinh().getDate()+"/"+sv.getNgaySinh().getMonth()+"/"+(sv.getNgaySinh().getYear()+1900)+"",i,3);
					model_table.setValueAt(sv.getQueQuan().getTenTinh()+"",i,4);
					model_table.setValueAt(sv.getKhoa().getTenKh()+"",i,5);
					model_table.setValueAt(sv.getGPA()+"",i,6);
					model_table.setValueAt(sv.getEmail()+"",i,7);
					
				}
			}
			
		}
	}

	public void capNhatSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		
	}
	
	public SinhVien getSinhVienDangChon() {
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		int i_row= table.getSelectedRow();
		
		Double MaSV = Double.valueOf(model_table.getValueAt(i_row, 0)+"");
		String TenSV= model_table.getValueAt(i_row, 1)+"";
		String textGioiTinh=model_table.getValueAt(i_row, 2)+"";
		Boolean gioiTinh=textGioiTinh.equals("Nam");
		Date ngaySinh= new Date(model_table.getValueAt(i_row, 3)+"");
		Tinh tinh=Tinh.getTinhbyName(model_table.getValueAt(i_row, 4)+"");
		Khoa khoa=Khoa.getKhoaByName(model_table.getValueAt(i_row, 5)+"");
		Double gpa=Double.valueOf(model_table.getValueAt(i_row, 6)+"");
		String email=model_table.getValueAt(i_row, 7)+"";
		
		SinhVien sv=new SinhVien(MaSV, TenSV, khoa, ngaySinh, gioiTinh, email, gpa, tinh);
		return sv;
	}

	public void hienThiThongTinSinhVienDaChon() {
		// TODO Auto-generated method stub
		SinhVien sv=getSinhVienDangChon();
		
		this.textField_masv.setText(sv.getMaSV()+"");
		this.textField_tensv.setText(sv.getTenSV()+"");
		if(sv.isGioiTinh()) {
			button_Nam.setSelected(true);
		}else {
			button_Nu.setSelected(true);
		}
		//this.buttonGroup_gioiTinh.setSelected(null, rootPaneCheckingEnabled);
		String s_ngaySinh=sv.getNgaySinh().getDate()+"/"+sv.getNgaySinh().getMonth()+"/"+(sv.getNgaySinh().getYear()+1900)+"";
		this.textField_ngaysinh.setText(s_ngaySinh);
		this.comboBox_queQuan.setSelectedItem(sv.getQueQuan().getTenTinh());
		this.comboBox_Khoa.setSelectedItem(sv.getKhoa().getTenKh());
		this.textField_email.setText(sv.getEmail()+"");
		this.textField_diem_gpa.setText(sv.getGPA() +"");
		
	}

	public void xoaThongTin() {
		// TODO Auto-generated method stub
		DefaultTableModel model_table=(DefaultTableModel) table.getModel();
		int i_row= table.getSelectedRow();
		int lua_chon=JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa !");
		if(lua_chon==JOptionPane.YES_OPTION) {
			SinhVien sv=getSinhVienDangChon();
			this.model.delete(sv);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemSinhVien() {
		// TODO Auto-generated method stub
		Double MaSV = Double.valueOf(this.textField_masv.getText());
		String TenSV= (this.textField_tensv.getText());
		int nameKhoa=this.comboBox_Khoa.getSelectedIndex()-1;
		Khoa khoa =Khoa.getKhoaById(nameKhoa);
		Date ngaySinh= new Date(this.textField_ngaysinh.getText());
		Boolean gioiTinh= true;
	
		if(this.button_Nam.isSelected()) {
			gioiTinh=true;
		}else if(this.button_Nu.isSelected()) {
			gioiTinh=false;
		}
		String email=(this.textField_email.getText());
		Double gpa=Double.valueOf(this.textField_diem_gpa.getText());
		int queQuan=this.comboBox_queQuan.getSelectedIndex()-1;
		Tinh tinh=Tinh.getTinhById(queQuan);
		
		SinhVien sv=new SinhVien(MaSV, TenSV, khoa, ngaySinh, gioiTinh, email, gpa, tinh);
		this.themHoacCapNhatSinhVien(sv);
	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
				this.thucHienTaiLaiDuLieu();
				
				// Thuc hien tim kiem
				int maKhoa = this.comboBox_khoa_timKiem.getSelectedIndex() - 1;
				String maSvTimKiem = this.textField_sinhVien_timKiem.getText();
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				int soLuongDong = model_table.getRowCount();

				Set<Double> idCuaSinhVienCanXoa = new TreeSet<Double>();
				if (maKhoa >= 0) {
					Khoa khoaDaChon = Khoa.getKhoaById(maKhoa);
					for (int i = 0; i < soLuongDong; i++) {
						String tenKhoa = model_table.getValueAt(i, 5) + "";
						String id = model_table.getValueAt(i, 0) + "";
						if (!tenKhoa.equals(khoaDaChon.getTenKh())) {
							idCuaSinhVienCanXoa.add(Double.valueOf(id));
						}
					}
				}
				if (maSvTimKiem.length() > 0) {
					for (int i = 0; i < soLuongDong; i++) {
						String id = model_table.getValueAt(i, 0) + "";
						if (!id.equals(maSvTimKiem)) {
							idCuaSinhVienCanXoa.add(Double.valueOf(id));
						}
					}
				}
				for (Double idCanXoa : idCuaSinhVienCanXoa) {
					System.out.println(idCanXoa);
					soLuongDong = model_table.getRowCount();
					for (int i = 0; i < soLuongDong; i++) {
						String idTrongTable = model_table.getValueAt(i, 0) + "";
						System.out.println("idTrongTable: " + idTrongTable);
						if (idTrongTable.equals(idCanXoa.toString())) {
							System.out.println("Đã xóa: " + i);
							try {
								model_table.removeRow(i);
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
	}
	
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (SinhVien sv : this.model.getDsSinhVien()) {
			this.themSinhVienVaoTable(sv);
		}
	}
	
	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản sinh viên 1.0! Bản thử nghiệm");
	}
	
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien sv : this.model.getDsSinhVien()) {
				oos.writeObject(sv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	
//	public void thucHienSaveFile() {
//	    JFileChooser fc = new JFileChooser();
//	    int returnVal = fc.showSaveDialog(this);
//	    if (returnVal == JFileChooser.APPROVE_OPTION) {
//	        File file = fc.getSelectedFile();
//	        saveFile(file.getAbsolutePath());
//	    }
//	}
	public void openFile(File file) {
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien sv = null;
			while((sv = (SinhVien) ois.readObject())!=null) {
				ds.add(sv);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsSinhVien(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
	
}
