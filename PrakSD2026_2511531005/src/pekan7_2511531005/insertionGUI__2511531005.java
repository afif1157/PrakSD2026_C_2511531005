package pekan7_2511531005;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class insertionGUI__2511531005 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int[] array_1005;
	private JLabel[] labelArray_1005;
	private JButton stepButton_1005, resetButton_1005, setButton_1005;
	private JTextField inputField_1005;
	private JPanel panelArray_1005;
	private JTextArea stepArea_1005;
	
	private int i = 1,j;
	private boolean sorting_1005 = false;
	private int stepCount_1005 = 1;
	
	

	
	

	/**
	 * Create the frame.
	 */
	public insertionGUI__2511531005() {
		setTitle("insertion sort langkah per langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel inputPanel_1005 = new JPanel(new FlowLayout());
		inputField_1005 = new JTextField(30);
		setButton_1005 = new JButton("set array");
		inputPanel_1005.add(new JLabel("masukkan angka (pisahkan dengan koma) : "));
		inputPanel_1005.add(inputField_1005);
		inputPanel_1005.add(setButton_1005);
		
		panelArray_1005 = new JPanel();
		panelArray_1005.setLayout(new FlowLayout());
		
		JPanel controlPanel = new JPanel();
		stepButton_1005 = new JButton("langkah selanjutnya ");
		resetButton_1005 = new JButton("reset");
		stepButton_1005.setEnabled(false);
		controlPanel.add(stepButton_1005);
		controlPanel.add(resetButton_1005);
		
		stepArea_1005 = new JTextArea(15, 30);
		stepArea_1005.setEditable(false);
		stepArea_1005.setFont(new Font ("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(stepArea_1005);
		
		add(inputPanel_1005, BorderLayout.NORTH);
		add(panelArray_1005, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.EAST);
		
		setButton_1005.addActionListener(e -> setArrayFromInput());
		
		stepButton_1005.addActionListener(e -> performStep());
		
		resetButton_1005.addActionListener(e -> reset());
				
	}
	
	private void setArrayFromInput() {
		String text_1005 = inputField_1005.getText().trim();
		if(text_1005.isEmpty()) return;
		String[] parts = text_1005.split(",");
		array_1005 = new int[parts.length];
		try {
			for (int k = 0 ; k < parts.length; k++) {
				array_1005[k] = Integer.parseInt(parts[k].trim());
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "masukkan angka yang dipisahkan " 
					+ "dengan koma !", "error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		i = 1;
		stepCount_1005 = 1;
		sorting_1005 = true;
		setButton_1005.setEnabled(true);
		stepArea_1005.setText("");
		panelArray_1005.removeAll();
		labelArray_1005 = new JLabel[array_1005.length];
		for (int k = 0; k < array_1005.length; k++) {
			labelArray_1005[k] = new JLabel(String.valueOf(array_1005[k]));
			labelArray_1005[k].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray_1005[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_1005[k].setPreferredSize(new Dimension(50, 50));
			labelArray_1005[k].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_1005.add(labelArray_1005[k]);
		}
		
		panelArray_1005.revalidate();
		panelArray_1005.repaint();
		
	}
	
	public void performStep() {
		if(i < array_1005.length && sorting_1005) {
			int key_1005 = array_1005[i];
			j = i - 1;
			
			StringBuilder stepLog_1005 = new StringBuilder();
			stepLog_1005.append("langkah ").append(stepCount_1005).append(": memasukkan ").append(key_1005).append("\n");
			
			while(j >= 0 && array_1005[j] > key_1005) {
				array_1005[j + 1] = array_1005[j];
				j--;
			}
			array_1005[j + 1] = key_1005;
			
			updateLabels();
			stepLog_1005.append("hasil : ").append(arrayToString(array_1005)).append("\n\n");
			stepArea_1005.append(stepLog_1005.toString());
			
			i++;
			stepCount_1005++;
			
			if(i == array_1005.length) {
				sorting_1005 = false;
				stepButton_1005.setEnabled(false);
				JOptionPane.showMessageDialog(this, "sorting selesai!");
			}
		}
	}
	
	private void updateLabels() {
		
		for (int k = 0; k < array_1005.length; k++) {
			labelArray_1005[k].setText(String.valueOf(array_1005[k]));
		}
		
	}
	
	private void reset() {
		
		inputField_1005.setText("");
		panelArray_1005.removeAll();
		panelArray_1005.revalidate();
		panelArray_1005.repaint();
		stepArea_1005.setText("");
		stepButton_1005.setEnabled(false);
		sorting_1005 = false;
		i = 1;
		stepCount_1005 = 1;
	}

	private Object arrayToString(int[] arr_1005) {
		
		StringBuilder sb_1005 = new StringBuilder();
		for(int k = 0; k < arr_1005.length; k++) {
			sb_1005.append(arr_1005[k]);
			if (k < arr_1005.length - 1) sb_1005.append(", ");
		}
		return sb_1005.toString();
		
	}
	
	


}
