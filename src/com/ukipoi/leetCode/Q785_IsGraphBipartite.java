package com.ukipoi.leetCode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Q785_IsGraphBipartite {
    public static void main(String[] args) {
//        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
//        int[][] graph = new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
//        int[][] graph = new int[][]{{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        int[][] graph = new int[][]{{2, 4}, {2, 3, 4}, {0, 1}, {1}, {0, 1}, {7}, {9}, {5}, {}, {6}, {12, 14}, {}, {10}, {}, {10}, {19}, {18}, {}, {16}, {15}, {23}, {23}, {}, {20, 21}, {}, {}, {27}, {26}, {}, {}, {34}, {33, 34}, {}, {31}, {30, 31}, {38, 39}, {37, 38, 39}, {36}, {35, 36}, {35, 36}, {43}, {}, {}, {40}, {}, {49}, {47, 48, 49}, {46, 48, 49}, {46, 47, 49}, {45, 46, 47, 48}};
        System.out.println(isBipartite(graph));
    }

    /**
     * 这题提交了3次，无关最优，解题的思路大致没问题，卡壳了两个地方。一个是没判断是否搜索过，导致无限loop
     * 另一个是没考虑完全分开的两个图的情况
     * 和官方的解答有着很大的差距，还需要再学习
     * @param graph 无向图
     * @return 是否可以把顶点分成两个集合
     */
    private static boolean isBipartite(int[][] graph) {
        int length = graph.length;
        for (int i = 0; i < length; i++) {
            if (!a(graph, i, new int[length], new int[length]))
                return false;
        }
        return true;
    }

    private static boolean a(int[][] graph, int index, int[] graph_flag, int[] do_search) {
        if (do_search[index] == 1) {
            return true;
        }
        if (graph[index].length == 0) {
            do_search[index] = 1;
            graph_flag[index] = 1;
            return true;
        }
        if (graph_flag[index] == 0) {
            graph_flag[index] = 1;
        }
        for (int i = 0; i < graph[index].length; i++) {
            if (graph_flag[index] == 1) {
                if (graph_flag[graph[index][i]] == 1) {
                    return false;
                } else {
                    graph_flag[graph[index][i]] = 2;
                }
            } else if (graph_flag[index] == 2) {
                if (graph_flag[graph[index][i]] == 2) {
                    return false;
                } else {
                    graph_flag[graph[index][i]] = 1;
                }
            }
        }
        do_search[index] = 1;
        for (int i = 0; i < graph[index].length; i++) {
            boolean a = a(graph, graph[index][i], graph_flag, do_search);
            if (!a) {
                return false;
            }
        }
        return true;
    }
}
/*
class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; ++i) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    public void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int cNei = c == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, cNei, graph);
                if (!valid) {
                    return;
                }
            } else if (color[neighbor] != cNei) {
                valid = false;
                return;
            }
        }
    }
}

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/is-graph-bipartite/solution/pan-duan-er-fen-tu-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
