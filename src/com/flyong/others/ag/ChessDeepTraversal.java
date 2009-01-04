package com.flyong.others.ag;

/**
 * 查找同色围棋子的深度遍历方法
 * 
 * 
 * 
 */
public class ChessDeepTraversal {
  private char[][] layout = { { '1', '1', '1', '1', '1', '1', '1', '1', '1' },
      { '1', '1', '1', '1', '1', '1', '1', '1', '1' },
      { '1', '1', '1', '1', '0', '0', '0', '1', '1' },
      { '1', '1', '1', '1', '0', '1', '0', '1', '1' },
      { '1', '0', '0', '1', 'A', '1', '1', '1', '1' },
      { '1', '1', '0', '0', '0', '1', '1', '1', '1' },
      { '1', '1', '1', '1', '0', '1', '1', '1', '1' },
      { '1', '1', '1', '1', '0', '1', '1', '1', '1' },
      { '1', '1', '1', '1', '1', '1', '1', '1', '1' },
      { '1', '1', '1', '1', '1', '1', '1', '1', '1' } };

  // 9行 10列
  private int w = 9, h = 10;
  private boolean[][] flag = new boolean[h][w];

  /**
   * 以 x, y 为起点进行深度优先遍历
   */
  private void traverse(int x, int y) {
    flag[x][y] = true;

    // 尝试遍历左侧结点
    if(x > 0 && !flag[x-1][y] && layout[x-1][y] == '0'){
      traverse(x - 1, y);
    }

    // 尝试遍历上侧结点
    if(y > 0 && !flag[x][y-1] && layout[x][y-1] == '0'){
      traverse(x, y - 1);
    }

    // 尝试遍历右侧结点
    if(x < w - 1 && !flag[x + 1][y] && layout[x + 1][y] == '0'){
      traverse(x + 1, y);
    }

    // 尝试遍历下侧结点
    if(y < h - 1 && !flag[x][y + 1] && layout[x][y + 1] == '0'){
      traverse(x, y + 1);
    }
  }

  /**
   * 以图形形式显示遍历结果
   */
  private void printGraph() {
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        System.out.print(flag[i][j] ? '*' : ' ');
      }
      System.out.println();
    }
  }

  /**
   * 以坐标形式显示遍历结果
   */
  private void printCoordinates() {
    System.out.println("遍历到的结点坐标：");
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        System.out.print(flag[i][j] ? (j + ", " + i + "\n") : "");
      }
    }
  }

  public static void main(String[] args) {
    // 遍历起点坐标
    int x = 4, y = 4;
    ChessDeepTraversal cdt = new ChessDeepTraversal();
    cdt.traverse(x, y);
    cdt.printGraph();
    cdt.printCoordinates();
  }
}