package entry;

import javax.swing.UIManager;
import dao.DAO;
import view.LoginFrm;

public class Run {
	public static void main(String[] args) {
		try {
			new DAO();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new LoginFrm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
