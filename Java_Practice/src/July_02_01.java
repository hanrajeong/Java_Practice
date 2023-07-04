import java.util.*;
/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42579
 *  입력 : 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays
 *  출력 : 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
 */

class July_02_01 {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 시간을 저장하는 HashMap
        HashMap<String, Integer> totalPlayTime = new HashMap<>();
        // 장르별 노래를 저장하는 HashMap
        HashMap<String, PriorityQueue<Song>> songMap = new HashMap<>();

        // 장르별 총 재생 시간과 노래를 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playTime = plays[i];

            // 장르별 총 재생 시간 업데이트
            // getOrDefault : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
            // getOrDefault(Object key, V DefaultValue)
            totalPlayTime.put(genre, totalPlayTime.getOrDefault(genre, 0) + playTime);

            // 장르별 노래 저장
            if (!songMap.containsKey(genre)) {
                // 우선순위 큐를 사용하여 재생 횟수 기준으로 내림차순 정렬
                songMap.put(genre, new PriorityQueue<>(new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        // 재생 횟수가 같은 경우에는 고유 번호(id)가 낮은 순서로 정렬
                        if (s1.playTime == s2.playTime)
                            return s1.id - s2.id;
                        // 재생 횟수를 기준으로 내림차순 정렬
                        return s2.playTime - s1.playTime;
                    }
                }));
            }

            // 노래를 장르별로 저장
            songMap.get(genre).add(new Song(i, playTime));
        }

        // 재생 시간에 따라 장르를 정렬
        List<String> sortedGenres = sortByPlayTime(totalPlayTime);
        List<Integer> answerList = new ArrayList<>();

        // 재생 시간이 가장 긴 장르부터 노래 선택
        for (String genre : sortedGenres) {
            PriorityQueue<Song> pq = songMap.get(genre);

            int count = 0;
            // 장르 내에서 재생 횟수가 가장 높은 노래 두 개 선택
            while (!pq.isEmpty() && count < 2) {
                answerList.add(pq.poll().id);
                count++;
            }
        }

        // List<Integer>를 int[] 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    // 재생 시간을 기준으로 장르를 정렬하는 메소드
    private List<String> sortByPlayTime(HashMap<String, Integer> totalPlayTime) {
        List<String> sortedGenres = new ArrayList<>(totalPlayTime.keySet());
        // 총 재생 시간을 기준으로 내림차순 정렬
        sortedGenres.sort((g1, g2) -> totalPlayTime.get(g2) - totalPlayTime.get(g1));
        return sortedGenres;
    }
    // Song 정보 (인덱스, 재생시간)을 저장하기 위한 클래스
    class Song {
        int id;
        int playTime;

        public Song(int id, int playTime) {
            this.id = id;
            this.playTime = playTime;
        }
    }
}
       
