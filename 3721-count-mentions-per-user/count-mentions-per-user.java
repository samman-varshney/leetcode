import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] timestamp = new int[numberOfUsers];
        int[] mentions = new int[numberOfUsers];

        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) return timeA - timeB;
            if (a.get(0).equals("OFFLINE")) return -1;
            if (b.get(0).equals("OFFLINE")) return 1;
            return 0;
        });

        for (List<String> event : events) {
            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(event.get(2));
                timestamp[id] = -(time + 60);
            } else if (type.equals("MESSAGE")) {
                for (int i = 0; i < numberOfUsers; i++) {
                    if (timestamp[i] < 0 && -timestamp[i] <= time) {
                        timestamp[i] = 0;
                    }
                }

                String mentionsString = event.get(2);
                if (mentionsString.equals("ALL")) {
                    for(int i=0;i<numberOfUsers;i++)
                            mentions[i]++;
                } else if (mentionsString.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (timestamp[i] >= 0) mentions[i]++;
                    }
                } else {
                    for (String idS : mentionsString.split(" ")) {
                        int id = Integer.parseInt(idS.substring(2));
                        mentions[id]++;
                    }
                }
            }
        }

        return mentions;
    }
}
