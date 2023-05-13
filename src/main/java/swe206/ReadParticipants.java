package swe206;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ReadParticipants {
    public static ArrayList<Participant> participants = new ArrayList<>();

    public static ArrayList<Participant> reader(String file) {
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String[] process = new String[5];
                for (int j = 0; j < 5; j++) {
                    process[j] = row[j].split("\n")[0];
                }
                participants.add(new Participant(process[0],process[1],process[2],process[3],process[4]));
            }


            return participants;
        } catch (Exception e) {
            e.printStackTrace();
            return participants;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Participant> getParticipants() {
        return participants;
    }
}