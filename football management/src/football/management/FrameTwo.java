package football.management;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
public class FrameTwo extends JFrame {

    private JPanel contentPane;
    private String list_club;
    private JTable klasemenTabel;
    private static FrameTwo frame;
    public void setlist_club(String s) {
        this.list_club = s;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new FrameTwo(null);
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
    public FrameTwo(String list_str) {
        
        setlist_club(list_str);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UIManager.put("TabbedPane.selected", Color.DARK_GRAY);
        setBounds(100, 100, 800, 800);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(190, 190, 190));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("Monospaced", Font.BOLD, 14));
        tabbedPane.setForeground(new Color(246, 245, 244));
        tabbedPane.setBackground(new Color(135, 134, 131));


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(17);
        tabbedPane.addTab("Match Update", null, scrollPane, null);
        
        
        JPanel panel_1 = new JPanel();
        scrollPane.setViewportView(panel_1);
        
        final Liga match = new Liga(list_club);		//create Liga object
        int jml_pertandingan = match.getjmlPertandingan();		//nanti diambil dari jumlah pertandingan yang telah di generate
        int[] array_rowHeight = new int[jml_pertandingan];
        double[] array_rowWeight = new double[jml_pertandingan];
        for (int i = 0; i < jml_pertandingan; i++) {
            array_rowHeight[i] = 30;	//digunakan untuk row height
            array_rowWeight[i] = 30;	//diguakan untuk rowWeight
        }
        ArrayList<JPanel> list_pert = new ArrayList<JPanel>();
        final ArrayList<JTextField> list_score = new ArrayList<JTextField>();	//tempat tampung score
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        scrollPane.setViewportView(panel);
        //tabbedPane.addTab("New tab", null, panel, null);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0};
        gbl_panel.rowHeights = array_rowHeight;
        gbl_panel.columnWeights = new double[]{1.0};
        gbl_panel.rowWeights = array_rowWeight;
        panel.setLayout(gbl_panel);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        JScrollPane Klasemen = new JScrollPane();
        tabbedPane.addTab("Klasemen", null, Klasemen, null);

        klasemenTabel = new JTable();
        klasemenTabel.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        klasemenTabel.setBorder(null);
        klasemenTabel.setFillsViewportHeight(true);
        klasemenTabel.setBackground(Color.LIGHT_GRAY);
        klasemenTabel.setForeground(Color.DARK_GRAY);
        klasemenTabel.setShowVerticalLines(false);
        klasemenTabel.setFont(new Font("FreeSans", Font.PLAIN, 13));
        klasemenTabel.setEnabled(false);
        klasemenTabel.setRowHeight(1000, 1000);
        final DefaultTableModel model = new DefaultTableModel(new Object[0][10],
                new String[]{
                    "No", "Tim", "PD", "M", "S", "K", "GM", "GK", "SG", "P"
                }
        );

        for (int i = 0; i < match.getjmlClub(); i++) {
            Object[] row_data = {String.valueOf(i + 1), match.getClub(i).getNama(), "0", String.valueOf(match.getClub(i).getmenang()), String.valueOf(match.getClub(i).getseri()),
                String.valueOf(match.getClub(i).getkalah()), String.valueOf(match.getClub(i).getgoal()), String.valueOf(match.getClub(i).getbobol()),
                String.valueOf(match.getClub(i).getselisihGoal()), String.valueOf(match.getClub(i).getpoin())};
            model.addRow(row_data);
        }

        klasemenTabel.setModel(model);
        klasemenTabel.getColumnModel().getColumn(0).setPreferredWidth(30);
        klasemenTabel.getColumnModel().getColumn(1).setPreferredWidth(150);
        klasemenTabel.getColumnModel().getColumn(2).setPreferredWidth(32);
        klasemenTabel.getColumnModel().getColumn(3).setPreferredWidth(32);
        klasemenTabel.getColumnModel().getColumn(4).setPreferredWidth(32);
        klasemenTabel.getColumnModel().getColumn(5).setPreferredWidth(32);
        klasemenTabel.getColumnModel().getColumn(6).setPreferredWidth(32);
        klasemenTabel.getColumnModel().getColumn(7).setPreferredWidth(32);
        klasemenTabel.getColumnModel().getColumn(8).setPreferredWidth(32);
        klasemenTabel.getColumnModel().getColumn(9).setPreferredWidth(32);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        klasemenTabel.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        klasemenTabel.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        klasemenTabel.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        klasemenTabel.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        klasemenTabel.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        klasemenTabel.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        klasemenTabel.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        klasemenTabel.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        klasemenTabel.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);

        Klasemen.setViewportView(klasemenTabel);

        JButton UpdateBtn = new JButton("Update");
        UpdateBtn.setForeground(UIManager.getColor("Button.highlight"));
        UpdateBtn.setBackground(new Color(36, 160, 237));
        UpdateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int z = 0;
                for (int i = 0; i < match.getjmlPertandingan(); i++) {
                    if (list_score.get(z).getText().isEmpty() || list_score.get(z + 1).getText().isEmpty()) {
                        //System.out.println("empty....");
                        match.getPertandingan(i).setplayed(false);
                        match.getPertandingan(i).setteamHomeScore(0);
                        match.getPertandingan(i).setteamAwayScore(0);
                        z += 2;
                        continue;
                    }
                    //Assignment score untuk club di pertandingam
                    match.getPertandingan(i).setplayed(true);
                    match.getPertandingan(i).setteamHomeScore(Integer.parseInt(list_score.get(z).getText()));
                    match.getPertandingan(i).setteamAwayScore(Integer.parseInt(list_score.get(z + 1).getText()));
                    //System.out.println(list_score.get(z).getText()+list_score.get(z+1).getText());
                    System.out.println(match.getPertandingan(i).getteamHomeScore() + "--" + match.getPertandingan(i).getteamAwayScore());
                    z += 2;	//update index for list_scoreimport java.awt.EventQueue;

                }
                match.UpdateClub();
                model.setRowCount(0);
                for (int i = 0; i < match.getjmlClub(); i++) {
                    Object[] row_data = {String.valueOf(i + 1), match.getClub(i).getNama(), String.valueOf(match.getClub(i).getmatchPertandingan()), String.valueOf(match.getClub(i).getmenang()), String.valueOf(match.getClub(i).getseri()),
                        String.valueOf(match.getClub(i).getkalah()), String.valueOf(match.getClub(i).getgoal()), String.valueOf(match.getClub(i).getbobol()),
                        String.valueOf(match.getClub(i).getselisihGoal()), String.valueOf(match.getClub(i).getpoin())};
                    model.addRow(row_data);
                }
                //klasemenTabel.revalidate();
                //klasemenTabel.repaint();
            }
        });
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(UpdateBtn, BorderLayout.SOUTH);
        contentPane.add(tabbedPane);
        for (int i = 0; i < jml_pertandingan; i++) {
            JPanel pert = new JPanel();		//panel pert(per baris)
            pert.setBorder(new LineBorder(new Color(68, 68, 68), 1, true));
            pert.setBorder(new LineBorder(Color.lightGray, 0, true));
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
            lblTimKiri.setForeground(new Color(68, 68, 68));
            lblTimKiri.setBounds(12, 12, 140, 17);
            list_pert.get(i).add(lblTimKiri);

            JLabel lblTimKanan = new JLabel(match.getPertandingan(i).getteamAway().getNama());
            lblTimKanan.setFont(new Font("Monospaced", Font.BOLD, 12));
            lblTimKanan.setHorizontalAlignment(SwingConstants.RIGHT);
            lblTimKanan.setForeground(new Color(68, 68, 68));
            lblTimKanan.setBounds(280, 12, 125, 17);
            list_pert.get(i).add(lblTimKanan);

            JTextField txtScore = new JTextField();
            txtScore.setHorizontalAlignment(SwingConstants.CENTER);
            txtScore.setText(null);
            txtScore.setFont(new Font("Free Sans", Font.BOLD, 12));
            txtScore.setBounds(155, 10, 21, 21);
            txtScore.setBackground(Color.white);
            txtScore.setForeground(Color.darkGray);
            list_pert.get(i).add(txtScore);
            txtScore.setColumns(10);
            list_score.add(txtScore);

            txtScore = new JTextField();
            txtScore.setHorizontalAlignment(SwingConstants.CENTER);
            txtScore.setText(null);
            txtScore.setFont(new Font("Free Sans", Font.BOLD, 12));
            txtScore.setColumns(10);
            txtScore.setBounds(250, 10, 21, 21);
            txtScore.setBackground(Color.white);
            txtScore.setForeground(Color.darkGray);
            list_pert.get(i).add(txtScore);
            list_score.add(txtScore);

            JLabel lblvsCenter = new JLabel("VS");
            lblvsCenter.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
            lblvsCenter.setBounds(202, 10, 27, 17);
            list_pert.get(i).add(lblvsCenter);
        }
        //scrollPane.setSize(getPreferredSize());
        //scrollPane.add(panellist);
    }
}
