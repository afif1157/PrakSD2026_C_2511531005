package pekan7_2511531005;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;	

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class sortingGUI_2511531005 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNama_1005, txtNim_1005, txtProdi_1005;
	private JButton addButton_1005, stepButton_1005, resetButton_1005;
	private JComboBox<String> comboSorting_1005;
	private JPanel panelArray_1005;
	private JTextArea areaLangkah_1005;
	private JLabel[] labelArray_1005;

	private ArrayList<ADTMahasiswa_251531005> listMhs_1005;
	private ArrayList<ADTMahasiswa_251531005> dataSorting_1005;
	
	private int i_1005;
	private boolean sortingSelesai_1005;

	
	public sortingGUI_2511531005() {
		
		setTitle("Visualisasi Sorting Mahasiswa");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		listMhs_1005 = new ArrayList<>();
		
		JPanel panelInput_1005 = new JPanel(new GridLayout(5, 2, 5, 5));
		panelInput_1005.setBorder(BorderFactory.createTitledBorder("Input Data"));

		panelInput_1005.add(new JLabel("Nama Mahasiswa"));
		txtNama_1005 = new JTextField();
		panelInput_1005.add(txtNama_1005);
		
		panelInput_1005.add(new JLabel("NIM"));
		txtNim_1005 = new JTextField();
		panelInput_1005.add(txtNim_1005);
		
		panelInput_1005.add(new JLabel("Program Studi"));
		txtProdi_1005 = new JTextField();
		panelInput_1005.add(txtProdi_1005);
		
		panelInput_1005.add(new JLabel("Pilih Sotring"));
		comboSorting_1005 = new JComboBox<>();
		
		comboSorting_1005.addItem("Insertion Sort");
		comboSorting_1005.addItem("Selection Sort");
		comboSorting_1005.addItem("Bubble Sort");
		
		panelInput_1005.add(comboSorting_1005);
		addButton_1005 = new JButton("Tambah Data");
		panelInput_1005.add(addButton_1005);
		
		
		panelArray_1005 = new JPanel();
		panelArray_1005.setLayout(new FlowLayout());
		panelArray_1005.setBorder(
				BorderFactory.createTitledBorder("Visualisasi Data"));
		
		
		JPanel panelControl_1005 = new JPanel();
		stepButton_1005 = new JButton("Langkah Selanjutnya");
		resetButton_1005 = new JButton("Reset");
		panelControl_1005.add(stepButton_1005);
		panelControl_1005.add(resetButton_1005);

		
		areaLangkah_1005 = new JTextArea();
		areaLangkah_1005.setEditable(false);
		areaLangkah_1005.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scroll_1005 = new JScrollPane(areaLangkah_1005);
		scroll_1005.setPreferredSize(new Dimension(350, 500));

		
		add(panelInput_1005, BorderLayout.NORTH);
		add(panelArray_1005, BorderLayout.CENTER);
		add(panelControl_1005, BorderLayout.SOUTH);
		add(scroll_1005, BorderLayout.EAST);

		
		addButton_1005.addActionListener(e -> tambahData_1005());
		stepButton_1005.addActionListener(e -> prosesSorting_1005());
		resetButton_1005.addActionListener(e -> reset_1005());
		stepButton_1005.setEnabled(false);
	}
	
	//method tambah data
	private void tambahData_1005() {
		String nama_1005 = txtNama_1005.getText().trim();
		String nim_1005 = txtNim_1005.getText().trim();
		String prodi_1005 = txtProdi_1005.getText().trim();
		
		if (nama_1005.isEmpty() || nim_1005.isEmpty() || prodi_1005.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Data belum lengkap!");
			return;
		}
		
		ADTMahasiswa_251531005 mhs_1005 = new ADTMahasiswa_251531005
				(nama_1005, nim_1005, prodi_1005);
		listMhs_1005.add(mhs_1005);
		tampilkanVisual_1005(listMhs_1005);
		
		txtNama_1005.setText("");
		txtNim_1005.setText("");
		txtProdi_1005.setText("");
		stepButton_1005.setEnabled(true);
		
		i_1005 = 1;
		sortingSelesai_1005 = false;
		areaLangkah_1005.setText("");
	}
	
	//method tampilkan visual
	private void tampilkanVisual_1005(ArrayList<ADTMahasiswa_251531005> data_1005) {
		panelArray_1005.removeAll();
		labelArray_1005 = new JLabel[data_1005.size()];
		
		for (int k_1005 = 0; k_1005 < data_1005.size(); k_1005++) {
			labelArray_1005[k_1005] = new JLabel(data_1005.get(k_1005).getNama_1005());
			labelArray_1005[k_1005].setFont(new Font("Arial", Font.BOLD, 16));
			labelArray_1005[k_1005].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_1005[k_1005].setPreferredSize(new Dimension(120, 50));
			labelArray_1005[k_1005].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_1005.add(labelArray_1005[k_1005]);
		}
		panelArray_1005.revalidate();
		panelArray_1005.repaint();
	}

	
	//proses sorting
	private void prosesSorting_1005() {
		if (listMhs_1005.size() <= 1) {
			JOptionPane.showMessageDialog(this, "Data minimal 2!");
			return;
		}
		
		if (dataSorting_1005 == null || i_1005 == 1) {
			dataSorting_1005 = new ArrayList<>();
			for (ADTMahasiswa_251531005 m : listMhs_1005) {
				dataSorting_1005.add(new ADTMahasiswa_251531005(
						m.getNama_1005(), m.getNama_1005(), m.getProdi_1005()));
			}
		}
		
		String pilihan_1005 = comboSorting_1005.getSelectedItem().toString();
		if (pilihan_1005.equals("Insetion Sort")) {
			insertionStep_1005();
		} else if (pilihan_1005.equals("Selection Sort")) {
			selectionStep_1005();
		} else {
			bubbleStep_1005();
		}
		
		tampilkanVisual_1005(dataSorting_1005);
	}
	
	
	//insertion 
	private void insertionStep_1005() {
		if (i_1005 < dataSorting_1005.size()) {
			ADTMahasiswa_251531005 key_1005 = dataSorting_1005.get(i_1005);
			int j_1005 = i_1005 - 1;
			
			while (j_1005 >= 0 && dataSorting_1005.get(
					j_1005).getNama_1005().compareToIgnoreCase(
							key_1005.getNama_1005()) > 0) {
				dataSorting_1005.set(j_1005 + 1, dataSorting_1005.get(j_1005));
				j_1005--;
			}
			
			dataSorting_1005.set(j_1005 + 1, key_1005);
			areaLangkah_1005.append(
					"Langkah " + i_1005 + " : " + tampilNama_1005(
							dataSorting_1005) + "\n");
			i_1005++;
		} else {
			selesai_1005();
		}
	}
	
	//selection
	private void selectionStep_1005() {
		if (i_1005 < dataSorting_1005.size()) {
			int min_1005 = i_1005 - 1;
			for (int j_1005 = i_1005; j_1005 < dataSorting_1005.size(); j_1005++) {
				if (dataSorting_1005.get(j_1005).getNama_1005().
						compareToIgnoreCase(dataSorting_1005.get(min_1005).
								getNama_1005()) < 0) {
					min_1005 = j_1005;
				}
			}
			ADTMahasiswa_251531005 temp_1005 = dataSorting_1005.get(i_1005 - 1);
			dataSorting_1005.set(i_1005 - 1, dataSorting_1005.get(min_1005));
			dataSorting_1005.set(min_1005, temp_1005);
			
			areaLangkah_1005.append("Pass " + i_1005 + " : "
					+ tampilNama_1005(dataSorting_1005) + "\n");
			
			i_1005++;
		} else {
			selesai_1005();
		}
	}


	//bubble
	private void bubbleStep_1005() {
		if (i_1005 < dataSorting_1005.size()) {
			for (int j_1005 = 0; j_1005 < dataSorting_1005.size() - i_1005; j_1005++) {
				if (dataSorting_1005.get(j_1005).getNama_1005().compareToIgnoreCase(
						dataSorting_1005.get(j_1005 + 1).getNama_1005()) > 0) {
					ADTMahasiswa_251531005 temp_1005 = dataSorting_1005.get(j_1005);
					dataSorting_1005.set(j_1005, dataSorting_1005.get(j_1005 + 1));
					dataSorting_1005.set(j_1005 + 1, temp_1005);
				}
			}
			areaLangkah_1005.append("Pass " + i_1005 + " : " + tampilNama_1005(
					dataSorting_1005) + "\n");
			
			i_1005++;
		} else {
			selesai_1005();
		}
	}
	
	//tampilkan nama
	private String tampilNama_1005(ArrayList<ADTMahasiswa_251531005> data_1005) {
		String hasil_1005 = "[";
		
		for (int i_1005 = 0; i_1005 < data_1005.size(); i_1005++) {
			hasil_1005 += data_1005.get(i_1005).getNama_1005();
			if (i_1005 != data_1005.size() - 1) {
				hasil_1005 += ", ";
			}
		}
		hasil_1005 += "]";
		return hasil_1005;
	}
	
	//selesai
	private void selesai_1005() {
		if (!sortingSelesai_1005) {
			sortingSelesai_1005 = true;
			stepButton_1005.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesai!");
		}
	}
	
	//reset
	private void reset_1005() {
		listMhs_1005.clear();
		dataSorting_1005 = null;
		panelArray_1005.removeAll();
		panelArray_1005.revalidate();
		panelArray_1005.repaint();
		
		areaLangkah_1005.setText("");
		txtNama_1005.setText("");
		txtNim_1005.setText("");
		txtProdi_1005.setText("");
		
		stepButton_1005.setEnabled(false);
		i_1005 = 1;
		sortingSelesai_1005 = false;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new sortingGUI_2511531005().setVisible(true);
		});
	}

}
