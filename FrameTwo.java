package guitour;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameTwo extends JFrame {

	private JPanel contentPane;
	private JTextField txtScore;
	private JTextField textField;
	private String list_club;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public void setlist_club(String s){
		this.list_club=s;
	}
	/**
	 * Method untuk menjalankan program frame kedua
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTwo frame = new FrameTwo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Method untuk membuat frame
	 */
	public FrameTwo(String list_str) {
		setUndecorated(false);
		setlist_club(list_str);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 413);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 32, 603, 381);
		contentPane.add(tabbedPane);
		
		//JPanel panel_1 = new JPanel();
		//scrollPane.setViewportView(panel_1);
		Liga match = new Liga(list_club);		//create Liga object
		int jml_pertandingan=match.getjmlPertandingan();		//nanti diambil dari jumlah pertandingan yang telah di generate
		int[] array_rowHeight = new int[jml_pertandingan];
		double[] array_rowWeight = new double[jml_pertandingan];
		for(int i=0; i<jml_pertandingan; i++) {
			array_rowHeight[i]=50;	//digunakan untuk row height
			array_rowWeight[i]=1.0;	//diguakan untuk rowWeight
		}
		ArrayList<JPanel> list_pert = new ArrayList<JPanel>();
		ArrayList<JTextField> list_score = new ArrayList<JTextField>();	//tempat tampung score
		

		// source code Klasemen 
		
		JScrollPane Klasemen = new JScrollPane();
		tabbedPane.addTab("Klasemen", null, Klasemen, null);
		
		//JPanel panelklasemen = new JPanel();
		//Klasemen.setColumnHeaderView(panelklasemen);
		
		// source code tabel 
		
		list = new javax.swing.JTable();

		list.setForeground(new java.awt.Color(51, 51, 51));

		list.setModel(new javax.swing.table.DefaultTableModel(
		    new Object [][] {
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null},
		        {null, null, null, null, null, null, null, null, null}
		    },
		    new String [] {
		        "No", "CLUB", "MAIN", "MENANG", "SERI", "KALAH", "GOAL", "KEBOBOLAN", "POIN"
		    }
		) {
		    Class[] types = new Class [] {
		        java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
		    };

		    public Class getColumnClass(int columnIndex) {
		        return types [columnIndex];
		    }
		});

		list.setGridColor(new java.awt.Color(204, 204, 204));

		list.setOpaque(false);

		list.setSelectionBackground(new java.awt.Color(0, 153, 204));

		list.setSelectionForeground(new java.awt.Color(255, 255, 255));

		//dok.setViewportView(list);
		//Klasemen.setColumnHeaderView(list);
		Klasemen.setViewportView(list);
		
		// Klasemen
		
		
		// source code History Match
		
		JScrollPane HistoryMatch = new JScrollPane();
		tabbedPane.addTab("History Match", null, HistoryMatch, null);
		
		JPanel panel_1_1 = new JPanel();
		HistoryMatch.setViewportView(panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{400, 0};
		gbl_panel_1_1.rowHeights = new int[]{50, 50, 50, 50, 50, 0};
		gbl_panel_1_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1_1.setLayout(gbl_panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setLayout(null);
		GridBagConstraints gbc_panel_2_1 = new GridBagConstraints();
		gbc_panel_2_1.fill = GridBagConstraints.BOTH;
		gbc_panel_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2_1.gridx = 0;
		gbc_panel_2_1.gridy = 0;
		panel_1_1.add(panel_2_1, gbc_panel_2_1);
		
		JLabel lblNewLabel = new JLabel("Team 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblNewLabel.setBounds(12, 12, 125, 17);
		panel_2_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Team 2");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(280, 12, 125, 17);
		panel_2_1.add(lblNewLabel_1);
		
		txtScore = new JTextField();
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setText("0");
		txtScore.setBounds(155, 10, 21, 21);
		panel_2_1.add(txtScore);
		txtScore.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("0");
		textField.setColumns(10);
		textField.setBounds(250, 10, 21, 21);
		panel_2_1.add(textField);
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		lblVs.setBounds(202, 10, 27, 17);
		panel_2_1.add(lblVs);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_3_1 = new GridBagConstraints();
		gbc_panel_3_1.fill = GridBagConstraints.BOTH;
		gbc_panel_3_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3_1.gridx = 0;
		gbc_panel_3_1.gridy = 1;
		panel_1_1.add(panel_3_1, gbc_panel_3_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4_1 = new GridBagConstraints();
		gbc_panel_4_1.fill = GridBagConstraints.BOTH;
		gbc_panel_4_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4_1.gridx = 0;
		gbc_panel_4_1.gridy = 2;
		panel_1_1.add(panel_4_1, gbc_panel_4_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_5_1 = new GridBagConstraints();
		gbc_panel_5_1.fill = GridBagConstraints.BOTH;
		gbc_panel_5_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5_1.gridx = 0;
		gbc_panel_5_1.gridy = 3;
		panel_1_1.add(panel_5_1, gbc_panel_5_1);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_6_1 = new GridBagConstraints();
		gbc_panel_6_1.fill = GridBagConstraints.BOTH;
		gbc_panel_6_1.gridx = 0;
		gbc_panel_6_1.gridy = 4;
		panel_1_1.add(panel_6_1, gbc_panel_6_1);
		
		
		// History Match 
		
		
		// source code Update Match
		
		JScrollPane MatchUpdate = new JScrollPane();
		MatchUpdate.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedPane.addTab("Match Update", null, MatchUpdate, null);
		JPanel panel = new JPanel();
		MatchUpdate.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblEnterDate = new JLabel("Enter Date : ");
		lblEnterDate.setBounds(88, 33, 89, 15);
		lblEnterDate.setVerticalTextPosition(SwingConstants.TOP);
		lblEnterDate.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblEnterDate);
		
		JLabel lblTeamA = new JLabel("Team A : ");
		lblTeamA.setBounds(88, 106, 70, 15);
		panel.add(lblTeamA);
		
		JLabel lblTeamB = new JLabel("Team B :");
		lblTeamB.setBounds(348, 106, 70, 15);
		panel.add(lblTeamB);
		
		JLabel lblTeamAGoal = new JLabel("Team A Goal :");
		lblTeamAGoal.setBounds(88, 187, 120, 15);
		panel.add(lblTeamAGoal);
		
		JLabel lblTeamBGoal = new JLabel("Team B Goal :");
		lblTeamBGoal.setBounds(348, 187, 120, 15);
		panel.add(lblTeamBGoal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 60, 136, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 133, 136, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 214, 136, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(348, 133, 136, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(348, 214, 136, 19);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Enter ");
		btnNewButton_1.setBounds(229, 272, 117, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(12, 0, 114, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int z=0;
				for(int i=0; i<match.getjmlPertandingan(); i++) {
						match.getPertandingan(i).setteamHomeScore(Integer.parseInt(list_score.get(z).getText()));
						match.getPertandingan(i).setteamAwayScore(Integer.parseInt(list_score.get(z+1).getText()));
						System.out.println(list_score.get(z).getText()+list_score.get(z+1).getText());
						z+=2;
						//System.out.println(match.getPertandingan(i).getteamHomeScore()+","+match.getPertandingan(i).getteamAwayScore());
					
					
				}
			}
		});
		contentPane.add(btnNewButton);
		for(int i=0; i<jml_pertandingan; i++) {
			JPanel pert = new JPanel();		//panel pert(per baris)
			pert.setBorder(new LineBorder(new Color(0, 0, 0)));
			pert.setLayout(null);
			GridBagConstraints gbc_pert = new GridBagConstraints();
			gbc_pert.insets = new Insets(0, 0, 5, 0);
			gbc_pert.fill = GridBagConstraints.BOTH;
			gbc_pert.gridx = 0;
			gbc_pert.gridy = i;
			list_pert.add(pert);		//memasukkan panel pert ke dalam list_pert ArrayList
			panel.add(list_pert.get(i), gbc_pert);
			
			JLabel lblTimKiri = new JLabel(match.getPertandingan(i).getteamHome().getNama());
			lblTimKiri.setHorizontalAlignment(SwingConstants.LEFT);
			lblTimKiri.setFont(new Font("Monospaced", Font.BOLD, 12));
			lblTimKiri.setBounds(12, 12, 125, 17);
			list_pert.get(i).add(lblTimKiri);
			
			JLabel lblTimKanan = new JLabel(match.getPertandingan(i).getteamAway().getNama());
			lblTimKanan.setFont(new Font("Monospaced", Font.BOLD, 12));
			lblTimKanan.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTimKanan.setBounds(280, 12, 125, 17);
			list_pert.get(i).add(lblTimKanan);
			
			txtScore = new JTextField();
			txtScore.setHorizontalAlignment(SwingConstants.CENTER);
			txtScore.setText("0");
			txtScore.setBounds(155, 10, 21, 21);
			list_pert.get(i).add(txtScore);
			txtScore.setColumns(10);
			list_score.add(txtScore);
			
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("0");
			textField.setColumns(10);
			textField.setBounds(250, 10, 21, 21);
			list_pert.get(i).add(textField);
			list_score.add(textField);
			
			JLabel lblvsCenter = new JLabel("VS");
			lblvsCenter.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
			lblvsCenter.setBounds(202, 10, 27, 17);
			list_pert.get(i).add(lblvsCenter);
		}
		
		//scrollPane.setSize(getPreferredSize());
		//scrollPane.add(panellist);
	}
}
