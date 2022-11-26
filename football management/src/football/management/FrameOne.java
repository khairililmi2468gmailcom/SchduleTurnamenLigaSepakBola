
package football.management;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameOne extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameOne frame = new FrameOne();
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
	public FrameOne() {
		//setVisible(true);
		setTitle("Tour Helper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(63, 111, 250, 129);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		contentPane.add(scrollPane);
		
		final JTextArea txtrHere = new JTextArea();
		
		txtrHere.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrHere.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtrHere.setBackground(new Color(245,245,245));
		txtrHere.setForeground(SystemColor.textHighlight);
		txtrHere.setText("");
		scrollPane.setViewportView(txtrHere);
		
		JLabel lblAddTeamsHere = new JLabel("Add Teams Here!");
		lblAddTeamsHere.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblAddTeamsHere.setForeground(Color.darkGray);
		lblAddTeamsHere.setBounds(63, 82, 137, 17);
		contentPane.add(lblAddTeamsHere);
		
		JLabel lblInf = new JLabel("* one per line");
		lblInf.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblInf.setForeground(Color.RED);
		lblInf.setBounds(62, 94, 108, 17);
		contentPane.add(lblInf);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setForeground(UIManager.getColor("Button.highlight"));
		btnEnter.setBackground(new Color(36, 160, 237));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				String list_club=txtrHere.getText();
				//System.out.print(list_club);
				//System.out.println("Hey BRo");
				FrameTwo ft = new FrameTwo(list_club);
				ft.setVisible(true);
			}
		});
		btnEnter.setBounds(325, 213, 71, 27);
		contentPane.add(btnEnter);
		
		JLabel lblTourHelper = new JLabel("Tour Helper");
		lblTourHelper.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblTourHelper.setForeground(new Color(0, 0, 0));
		lblTourHelper.setBounds(174, 11, 115, 17);
		contentPane.add(lblTourHelper);
		
		JLabel lblTourname = new JLabel("Tour name");
		lblTourname.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblTourname.setBackground(Color.darkGray);
		lblTourname.setBounds(63, 24, 64, 17);
		contentPane.add(lblTourname);
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textField.setForeground(SystemColor.textHighlight);
		//textField.setText("Asian Cup");
		textField.setMargin(new Insets(0, 2, 0, 0));
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setBounds(63, 40, 154, 21);
		textField.setBackground(new Color(245, 245, 245));
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
