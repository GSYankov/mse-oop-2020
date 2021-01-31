import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Button;

public class Frame1 {

	private JFrame frame;
	private JTable table;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<Student> students= new ArrayList<Student>();
		frame = new JFrame();
		frame.setBounds(100, 100, 608, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable(new DefaultTableModel(new Object[] { "Name ", "facNum", "marksAvg" }, 0));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { "Name ", "facNum", "marksAvg" });
		table.setBounds(122, 41, 338, 146);
		frame.getContentPane().add(table);

		JButton btnNewButton = new JButton("Load data");
		btnNewButton.setBounds(122, 346, 130, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader reader;
				String line = "";
				try {
					model.setNumRows(1);
					students.clear();
					reader = new BufferedReader(new FileReader("students.txt"));
					line = reader.readLine();
					while (line != null) {
						String[] sutdentData = line.split("\\t");
						String facNum = sutdentData[0];
						int[] marks = Stream.of(sutdentData[1].split(" ")).mapToInt(Integer::valueOf).toArray();
						int photoHeight = Integer.parseInt(sutdentData[2]);
						int photoWidth = Integer.parseInt(sutdentData[3]);
						int height = Integer.parseInt(sutdentData[4]);
						int weight = Integer.parseInt(sutdentData[5]);
						String ucn = sutdentData[6];
						String name = sutdentData[7];
						Student student = new Student(facNum, marks, photoHeight, photoWidth, height, weight, ucn,
								name);
						addStudentToTable(student);
						students.add(student);
						line = reader.readLine();
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			private void addStudentToTable(Student student) {
				model.addRow(new Object[] { student.getName(), student.getFacNum(), student.getMarksAvg() });

			}
		});

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("Show the best");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Student> filteredstudents= new ArrayList<Student>();
				model.setNumRows(1);
				students.forEach(s -> {
					if (s.getMarksAvg() > 5.50) {
						model.addRow(new Object[] { s.getName(), s.getFacNum(), s.getMarksAvg() });
						filteredstudents.add(s);
					}
				});
			}
		});
		btnNewButton_1.setBounds(338, 346, 122, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
