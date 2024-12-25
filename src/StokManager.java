import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StokManager {
    private static final String FILE_PATH = "stok_daun_teh.txt";
    private static Map<String, Double> stok = new HashMap<>();

    static {
        loadStok();
    }

    public static void tambahStok(String jenis, double jumlah) {
        stok.put(jenis, stok.getOrDefault(jenis, 0.0) + jumlah);
        saveStok();
    }

    public static boolean kurangiStok(String jenis, double jumlah) {
        if (stok.containsKey(jenis) && stok.get(jenis) >= jumlah) {
            stok.put(jenis, stok.get(jenis) - jumlah);
            saveStok();
            return true;
        }
        return false;
    }

    public static Map<String, Double> getStok() {
        return stok;
    }

    private static void loadStok() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                stok.put(parts[0], Double.parseDouble(parts[1]));
            }
        } catch (IOException e) {
            // File tidak ditemukan, mulai dengan stok kosong
        }
    }

    private static void saveStok() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, Double> entry : stok.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}