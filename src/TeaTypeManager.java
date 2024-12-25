// TeaTypeManager.java
import java.io.*;
import java.util.*;

public class TeaTypeManager {
    private static final String FILE_PATH = "tea_types.txt";
    private static Set<String> teaTypes = new HashSet<>();

    static {
        loadTeaTypes();
    }

    public static void addTeaType(String type) {
        teaTypes.add(type);
        saveTeaTypes();
    }

    public static String[] getTeaTypes() {
        return teaTypes.toArray(new String[0]);
    }

    private static void loadTeaTypes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                teaTypes.add(line.trim());
            }
        } catch (IOException e) {
            // Start with empty set if file not found
        }
    }

    private static void saveTeaTypes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String type : teaTypes) {
                bw.write(type);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}