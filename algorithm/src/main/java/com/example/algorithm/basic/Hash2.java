package com.example.algorithm.basic;

import java.util.*;

public class Hash2 {


    static class Song {
        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }

        public int getIndex() {
            return index;
        }

        public int getPlay() {
            return play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {


        Map<String, List<Song>> genresMap = new HashMap<>();
        Map<String, Integer> genresCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genresCountMap.put(genres[i], genresCountMap.getOrDefault(genres[i], 0) + plays[i]);

            if (genresMap.containsKey(genres[i])) {
                genresMap.get(genres[i]).add(new Song(i, plays[i]));
            } else {
                List<Song> songList = new ArrayList<>();
                songList.add(new Song(i, plays[i]));
                genresMap.put(genres[i], songList);
            }
        }
        List<String> sortedGenres = new ArrayList<>(genresCountMap.keySet());
        sortedGenres.sort((a, b) -> genresCountMap.get(b) - genresCountMap.get(a));
        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = genresMap.get(genre);

            songs.sort((a, b) -> {
                if (a.getIndex() == b.getIndex()) return a.getIndex() - b.getIndex();
                return b.getPlay() - a.getPlay();
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answerList.add(songs.get(i).getIndex());
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
