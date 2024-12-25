// TambahJenisGUI.java
import java.awt.*;
import javax.swing.*;

public class TambahJenisGUI {
    TambahJenisGUI() {
        JFrame frame = new JFrame("Tambah Jenis Teh");
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel lblJenis = new JLabel("Nama Jenis Teh:");
        JTextField txtJenis = new JTextField();
        JButton btnSimpan = new JButton("Simpan");

        panel.add(lblJenis);
        panel.add(txtJenis);
        panel.add(new JLabel());
        panel.add(btnSimpan);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        btnSimpan.addActionListener(e -> {
            String jenis = txtJenis.getText().trim();
            if (!jenis.isEmpty()) {
                TeaTypeManager.addTeaType(jenis);
                JOptionPane.showMessageDialog(frame, "Jenis teh berhasil ditambahkan!");
                frame.dispose();
            }
        });
    }
}