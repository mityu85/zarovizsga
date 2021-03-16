package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WorkHours {

    public String minWork(String file) {
        Map<String, String> employees = new HashMap<>();
        int min = Integer.MAX_VALUE;
        try (BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (Integer.parseInt(temp[1]) < min) {
                    min = Integer.parseInt(temp[1]);
                    employees.put(temp[0], temp[2]);
                }
            }
            return employees.keySet().toArray()[0].toString() + ": " + employees.get(employees.keySet().toArray()[0].toString());
        } catch (IOException e) {
            throw new IllegalStateException("File cannot read", e);
        }
    }

}
