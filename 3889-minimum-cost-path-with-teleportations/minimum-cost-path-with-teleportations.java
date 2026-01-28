import java.util.*;

class Solution {
    static class State implements Comparable<State> {
        int cost, i, j, t;
        State(int cost, int i, int j, int t) {
            this.cost = cost;
            this.i = i;
            this.j = j;
            this.t = t;
        }
        public int compareTo(State other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public int minCost(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        // Store all cells with value and position
        List<int[]> vals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vals.add(new int[]{grid[i][j], i, j});
            }
        }

        // Sort in descending order by value
        vals.sort((a, b) -> Integer.compare(b[0], a[0]));

        // available[t] stores copy of vals list (sorted by value)
        List<Deque<int[]>> available = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Deque<int[]> dq = new ArrayDeque<>();
            dq.addAll(vals);
            available.add(dq);
        }

        // shortest[i][j][t] = min cost to reach (i,j) with t teleports used
        int[][][] shortest = new int[n][m][k + 1];
        for (int[][] arr : shortest) {
            for (int[] row : arr) {
                Arrays.fill(row, Integer.MAX_VALUE / 2);
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        shortest[0][0][0] = 0;
        pq.add(new State(0, 0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int cost = cur.cost, i = cur.i, j = cur.j, t = cur.t;

            if (cost > shortest[i][j][t] || (t > 0 && cost >= shortest[i][j][t - 1])) 
                continue;

            if (i == n - 1 && j == m - 1) return cost; // reached end

            // Normal moves (down and right)
            if (i + 1 < n) {
                int newCost = cost + grid[i + 1][j];
                if (newCost < shortest[i + 1][j][t]) {
                    shortest[i + 1][j][t] = newCost;
                    pq.add(new State(newCost, i + 1, j, t));
                }
            }

            if (j + 1 < m) {
                int newCost = cost + grid[i][j + 1];
                if (newCost < shortest[i][j + 1][t]) {
                    shortest[i][j + 1][t] = newCost;
                    pq.add(new State(newCost, i, j + 1, t));
                }
            }

            // Teleport moves (if still have teleports left)
            if (t < k) {
                Deque<int[]> dq = available.get(t);
                while (!dq.isEmpty() && dq.peekLast()[0] <= grid[i][j]) {
                    int[] cell = dq.pollLast();
                    int ni = cell[1], nj = cell[2];
                    if (cost < shortest[ni][nj][t + 1]) {
                        shortest[ni][nj][t + 1] = cost;
                        pq.add(new State(cost, ni, nj, t + 1));
                    }
                }

                // Clean higher teleport lists
                for (int p = t + 1; p < k; p++) {
                    Deque<int[]> dqp = available.get(p);
                    while (!dqp.isEmpty() && dqp.peekLast()[0] <= grid[i][j]) {
                        dqp.pollLast();
                    }
                }
            }
        }
        return -1;
    }
}
