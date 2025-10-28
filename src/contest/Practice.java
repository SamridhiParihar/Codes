package contest;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        String secret = "1122";
        String guess = "1222";
        System.out.println(getHint(secret,guess));
    }

    public static String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int i = 0;
        for (char ch : secret.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            map.putIfAbsent(ch, new HashSet<>());
            map.get(ch).add(i++);
        }

        int bulls = 0, cows = 0;
        for (int j = 0; j < guess.length(); j++) {
            char ch = guess.charAt(j);
            if (map.containsKey(ch)) {
                if (map.get(ch).contains(j)) {
                    bulls++;
                    map2.put(ch, map2.get(ch) - 1);
                }
            }
        }
        for (int j = 0; j < guess.length(); j++) {
            char ch = guess.charAt(j);
            if (map.containsKey(ch)) {
                 if (!map.get(ch).contains(j) && map2.get(ch) > 0) {
                    cows++;
                    map2.put(ch, map2.get(ch) - 1);
                }

            }
        }

        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }

}
