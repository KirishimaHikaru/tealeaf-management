import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class LihatStokGUI {
    LihatStokGUI() {
        JFrame frame = new JFrame("Lihat Stok");
        frame.setSize(400, 300);

        String[] columnNames = {"Jenis Daun Teh", "Jumlah (kg)"};
        Map<String, Double> stok = StokManager.getStok();
        Object[][] data = new Object[stok.size()][2];

        int index = 0;
        for (Map.Entry<String, Double> entry : stok.entrySet()) {
            data[index][0] = entry.getKey();
            data[index][1] = entry.getValue();
            index++;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}