import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class UserInput extends JPanel implements ActionListener, MouseListener {
	JTextField textFieldName;
	JTextField textFieldWeight;
	JTextField textFieldHeight;

	JLabel labelBMI;

	public UserInput() {

		setBackground(Color.decode("#dbebfa"));
		// setPreferredSize(new Dimension(200, 80));

		final JLabel labelName = new JLabel("Name:");
		labelName.setForeground(Color.decode("#000000"));

		textFieldName = new JTextField();
		textFieldName.setPreferredSize(new Dimension(100, 20));
		textFieldName.addActionListener(new NameInputAction());

		textFieldName.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				System.out.println(textFieldName.getText());
				textFieldName.setBackground(Color.decode("#25d366"));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				textFieldName.setBackground(Color.decode("#FF5A5F"));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		final JLabel labelWeight = new JLabel("Weight (kg):");
		labelWeight.setForeground(Color.decode("#000000"));

		textFieldWeight = new JTextField();
		textFieldWeight.setPreferredSize(new Dimension(100, 20));
		textFieldWeight.addMouseListener(this);

		textFieldWeight.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				float weight = Float.valueOf(textFieldWeight.getText());
				System.out.println(weight);
				textFieldWeight.setBackground(Color.decode("#25d366"));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				textFieldWeight.setBackground(Color.decode("#FF5A5F"));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		final JLabel labelHeight = new JLabel("Height (cm):");
		labelHeight.setForeground(Color.decode("#000000"));

		textFieldHeight = new JTextField("");
		textFieldHeight.setPreferredSize(new Dimension(100, 20));
		textFieldHeight.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				float height = Float.valueOf(textFieldHeight.getText());
				System.out.println(height);
				textFieldHeight.setBackground(Color.decode("#25d366"));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				textFieldHeight.setBackground(Color.decode("#FF5A5F"));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				textFieldHeight.setBackground(Color.decode("#000000"));
			}
		});

		labelBMI = new JLabel("BMI:");
		labelBMI.setForeground(Color.decode("#000000"));
		labelBMI.setVisible(false);

		final JButton buttonCalculate = new JButton("Calculate");
		buttonCalculate.setBackground(Color.decode("#c0de9e"));
		buttonCalculate.setForeground(Color.decode("#008200"));
		buttonCalculate.setPreferredSize(new Dimension(100, 20));
		buttonCalculate.addActionListener(new CalculateClickAction());

		final JButton buttonClear = new JButton("Clear");
		buttonClear.setBackground(Color.decode("#ffaaaa"));
		buttonClear.setForeground(Color.decode("#ad182d"));
		buttonClear.setPreferredSize(new Dimension(100, 20));
		buttonClear.addActionListener(new ClearClickAction());

		final GridBagConstraints gbc = new GridBagConstraints();
		final GridBagLayout layout = new GridBagLayout();

		setLayout(layout);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(labelName, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(textFieldName, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(labelWeight, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(textFieldWeight, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(labelHeight, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(textFieldHeight, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(buttonCalculate, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(buttonClear, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(labelBMI, gbc);
	}

	private class CalculateClickAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Entered Name: " + textFieldName.getText());
			System.out.println("Entered Weight: " + textFieldWeight.getText());
			System.out.println("Entered Height: " + textFieldHeight.getText());
			float weight = Float.valueOf(textFieldWeight.getText());
			float height = Float.valueOf(textFieldHeight.getText()) / 100;
			float bmi = weight / (height * height);
			System.out.println("BMI: " + bmi);
			labelBMI.setVisible(true);
			labelBMI.setText("BMI = " + String.valueOf(bmi));

		}
	}

	private class NameInputAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nameText = textFieldName.getText();
			System.out.println("Entered Name: " + nameText);
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	class ClearClickAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			textFieldName.setText("");
			textFieldWeight.setText("");
			textFieldHeight.setText("");
			labelBMI.setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
