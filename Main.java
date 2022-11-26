
import java.awt.EventQueue;

/**
 * Method untuk menjalankan program utama
 */
public class Main {
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
}
