import java.util.*;

class Solution {
    private static final String DELIMITER = "\\.";
    private static final String SPACE = " ";

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termsMap = getTermsMap(terms);
        collectDeletePrivacy(today, privacies, termsMap, answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Map<String, Integer> getTermsMap(String[] terms) {
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(SPACE);
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }
        return termsMap;
    }

    private void collectDeletePrivacy(String today, String[] privacies, Map<String, Integer> termsMap, List<Integer> answer) {
        int[] todayYearMonthDay = parseToLocalDate(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(SPACE);
            int[] storeStartYearMonthDay = parseToLocalDate(split[0]);
            String term = split[1];
            int termMonth = termsMap.get(term);
            int[] expireYearMonthDay = plusMonth(storeStartYearMonthDay, termMonth);
            if (calculateAfter(todayYearMonthDay, expireYearMonthDay)) {
                answer.add(i + 1);
            }
        }
    }

    private boolean calculateAfter(int[] todayYearMonthDay, int[] expireYearMonthDay) {
        int todayDays = toDays(todayYearMonthDay);
        int expireDays = toDays(expireYearMonthDay);
        return todayDays >= expireDays;
    }

    private int[] plusMonth(int[] storeStartYearMonthDay, int termMonth) {
        int year = storeStartYearMonthDay[0];
        int month = storeStartYearMonthDay[1];
        int day = storeStartYearMonthDay[2];

        int totalDays = year * 12 * 28 + month * 28 + day + termMonth * 28;
        year = totalDays / (12 * 28);
        totalDays %= 12 * 28;
        month = totalDays / 28;
        day = totalDays % 28;
        
        if (day == 0) {
            day = 28;
            month--;
            if (month == 0) {
                month = 12;
                year--;
            }
        }

        return new int[] { year, month, day };
    }

    private int[] parseToLocalDate(String date) {
        String[] split = date.split(DELIMITER);
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return new int[] { year, month, day };
    }

    private int toDays(int[] date) {
        return date[0] * 12 * 28 + date[1] * 28 + date[2];
    }
}