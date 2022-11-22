import java.awt.BorderLayout;
import java.awt.FlowLayout;
/*from   w  w w. jav  a 2 s . c  o  m*/
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tes {
  public static void main(String[] args) {
    JPanel gui = new JPanel(new BorderLayout(2, 3));

    JPanel buttonConstrsint = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton getQuotesButton = new JButton("Load");
    buttonConstrsint.add(getQuotesButton);
    gui.add(buttonConstrsint, BorderLayout.NORTH);

    getQuotesButton.addActionListener(e->{
        String[] columnNames = { "First Name", "Last Name", "Sport",
            "# of Years", "Vegetarian" };

        Object[][] data = {
            { "A", "B", "Snowboarding", new Integer(5),
                new Boolean(false) },
            { "C", "D", "Pool", new Integer(10), new Boolean(false) } };

        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        gui.add(scrollPane, BorderLayout.CENTER);
        gui.revalidate();
        gui.repaint();
    });

    JOptionPane jOptionPane = new JOptionPane(gui);

    JDialog dialog = jOptionPane.createDialog(new JFrame(), "title");
    dialog.setSize(200, 200);
    dialog.setVisible(true);
  }
}