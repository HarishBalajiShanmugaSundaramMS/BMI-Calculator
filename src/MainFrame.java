import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private FormPanel formPanel;

	public MainFrame() {
		super("BMI Calculator"); // Sets Title
		ImageIcon img = new ImageIcon("//Users//harishbalaji//eclipse-workspace//BMI-Calc//BMI_Calc//src//heartbeat.png");
		this.setIconImage(img.getImage());
		setLayout(new BorderLayout());
		formPanel = new FormPanel();
		add(formPanel, BorderLayout.WEST);
		setSize(250, 180);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
