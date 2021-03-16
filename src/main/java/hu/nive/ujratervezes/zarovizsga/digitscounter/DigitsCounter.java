package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<String> digits = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (isNumber(s.substring(i, i + 1))) {
                digits.add(s.substring(i, i + 1));
            }
        }
        return digits.size();
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
