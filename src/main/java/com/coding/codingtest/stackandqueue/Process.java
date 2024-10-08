package com.coding.codingtest.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 알고리즘 고득점 kit
 * 스택/큐
 * 프로세스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * */
public class Process {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        System.out.println(solution(priorities, 0));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        for (int priority : priorities) {
            queue.add(priority);
        }

        while (!queue.isEmpty()) {
            int maxPriority = queue.stream().max(Integer::compareTo).get();
            while (queue.peek() < maxPriority) {
                if (location == 0) {
                    location = queue.size() - 1;
                } else {
                    location -= 1;
                }
                queue.offer(queue.poll());
            }
            queue.poll();
            answer += 1;
            if (location == 0) {
                break;
            } else {
                location -= 1;
            }
        }

        return answer;
    }
}
