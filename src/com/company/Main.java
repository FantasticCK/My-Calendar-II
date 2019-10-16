package com.company;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Solution MyCalendar = new Solution();
        MyCalendar.book(10, 20); // returns true
        MyCalendar.book(50, 60); // returns true
        MyCalendar.book(10, 40); // returns true
        MyCalendar.book(5, 15); // returns false
        MyCalendar.book(5, 10); // returns true
        MyCalendar.book(25, 55); // returns true
    }
}

class MyCalendarTwo {
    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public boolean book(int s, int e) {
        map.put(s, map.getOrDefault(s, 0) + 1);
        map.put(e, map.getOrDefault(e, 0) - 1);

        int cnt = 0, k = 0;
        for (int v : map.values()) {
            k = Math.max(k, cnt += v);
            if (k > 2) {
                map.put(s, map.get(s) - 1);
                map.put(e, map.get(e) + 1);
                return false;
            }
        }
        return true;
    }
}

class MyCalendarTwo {

    List<int[]> books;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        books = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            if (Math.max(overlap[0], start) < Math.min(overlap[1], end)) {
                return false;
            }
        }
        for (int[] book : books) {
            int overlapStart = Math.max(book[0], start);
            int overlapEnd = Math.min(book[1], end);
            if (overlapStart < overlapEnd) {
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }
        books.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */