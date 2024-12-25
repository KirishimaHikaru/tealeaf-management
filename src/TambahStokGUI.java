// TambahStokGUI.java
import java.awt.*;
import javax.swing.*;

class TambahStokGUI {
    TambahStokGUI() {
        JFrame frame = new JFrame("Tambah Stok");
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel lblJenis = new JLabel("Jenis Daun Teh:");
        JComboBox<String> cmbJenis = new JComboBox<>(TeaTypeManager.getTeaTypes());

        JLabel lblJumlah = new JLabel("Jumlah:");
        JTextField txtJumlah = new JTextField();

        JLabel lblSatuan = new JLabel("Satuan:");
        JComboBox<WeightUnit> cmbSatuan = new JComboBox<>(WeightUnit.values());

        JButton btnSimpan = new JButton("Simpan");

        panel.add(lblJenis);
        panel.add(cmbJenis);
        panel.add(lblJumlah);
        panel.add(txtJumlah);
        panel.add(lblSatuan);
        panel.add(cmbSatuan);
        panel.add(new JLabel());
        panel.add(btnSimpan);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        btnSimpan.addActionListener(e -> {
            String jenis = (String) cmbJenis.getSelectedItem();
            if (jenis != null && !txtJumlah.getText().isEmpty()) {
                double jumlah = Double.parseDouble(txtJumlah.getText());
                WeightUnit unit = (WeightUnit) cmbSatuan.getSelectedItem();
                double jumlahKg = unit.toKilograms(jumlah);
                StokManager.tambahStok(jenis, jumlahKg);
                JOptionPane.showMessageDialog(frame, "Stok berhasil ditambahkan!");
                frame.dispose();
            }
        });
    }
}