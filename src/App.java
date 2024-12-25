import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Aplikasi Manajemen Stok Daun Teh");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 350);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 1));

            JLabel label = new JLabel("Hello, Admin!", SwingConstants.CENTER);
            panel.add(label);

            JButton btnTambahJenis = new JButton("Tambah Jenis Teh");
            JButton btnTambahStok = new JButton("Tambah Stok");
            JButton btnKurangiStok = new JButton("Kurangi Stok");
            JButton btnLihatStok = new JButton("Lihat Stok");

            panel.add(btnTambahJenis);
            panel.add(btnTambahStok);
            panel.add(btnKurangiStok);
            panel.add(btnLihatStok);

            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            btnTambahJenis.addActionListener(e -> new TambahJenisGUI());
            btnTambahStok.addActionListener(e -> new TambahStokGUI());
            btnKurangiStok.addActionListener(e -> new KurangiStokGUI());
            btnLihatStok.addActionListener(e -> new LihatStokGUI());
        });
    }
}