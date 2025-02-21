package collection.map.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1 {
    // 문제3 - 같은 단어가 나타난 수
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        Map<String, Integer> map = new HashMap<>();

        String[] str = text.split(" ");

        /*
        for (String s : str) {// map 초기화!
            map.put(s, 0);
        }
        for (String s : str) {
            if (map.keySet().contains(s)) {
                int cnt = map.get(s);
                cnt++;
                map.put(s, cnt);
            }
        }
        */

        for (String s : str) {
            Integer cnt = map.get(s); // 처음 루프에서는 아무 것도 있지 않아 null 반납될 것 그리고
            if (cnt == null) { // 한번도 들어온 적이 없는 null 인 경우에는 cnt를 0으로 설정해주기
                cnt = 0;
            }
            cnt++; // 0으로 설정이 되었다면 1로 올려줌 + 0이 아니더라도 map.get(s)를 통해서 얻어온 cnt를 하나 증가시켜줌
            map.put(s, cnt);
        }
        System.out.println(map);
    }
}