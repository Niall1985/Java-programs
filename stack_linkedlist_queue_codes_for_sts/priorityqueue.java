import java.util.*;

class Task {
    String id;
    int p1;
    int p2;

    Task(String id, int p1, int p2) {
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Task> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.p1 != b.p1)
                    return b.p1 - a.p1;
                return a.p2 - b.p2;
            }
        );

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            pq.add(new Task(sc.next(), sc.nextInt(), sc.nextInt()));
        }

        while (!pq.isEmpty()) {
            Task t = pq.poll();
            System.out.println(t.id + " " + t.p1 + " " + t.p2);
        }
    }
}
