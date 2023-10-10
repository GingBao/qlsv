package test;

import javax.swing.UIManager;

import view.StudentManagerView;


public class StudentManagerApp {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			StudentManagerView stv =new StudentManagerView();
			stv.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
