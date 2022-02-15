package problem.greedy.problem04;

import java.util.*;

/**
 * 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
 * 설명
 * 현수는 유명한 강연자이다. N개의 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
 *
 * 출력
 * 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
 */

public class Main {

    static class Request {
        int pay;
        int day;

        public Request(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    public int solution(List<Request> requests) {

        int answer = 0;

        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        requests.sort((o1, o2) -> o2.day - o1.day);

        int count = requests.get(0).day;
        int i = 0;

        while (count > 0) {

            for (; i < requests.size(); i++) {
                Request request = requests.get(i);
                if (request.day == count) {
                    priorityQueue.offer(request.pay);
                } else {
                    break;
                }
            }

            if (!priorityQueue.isEmpty()) {
                answer += priorityQueue.poll();
            }
            count--;
        }

        return answer;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Request> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pay = in.nextInt();
            int day = in.nextInt();
            requests.add(new Request(pay, day));
        }
        System.out.println(main.solution(requests));
    }
}
