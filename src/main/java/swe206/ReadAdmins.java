package swe206;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ReadAdmins {
    public static ArrayList<Admin> admins = new ArrayList<>();

    public static ArrayList<Admin> reader(String file) {
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String[] process = new String[2];
                for (int j = 0; j < 2; j++) {
                    process[j] = row[j].split("\n")[0];
                }
                admins.add(new Admin(process[0], process[1]));
            }


            return admins;
        } catch (Exception e) {
            e.printStackTrace();
            return admins;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
