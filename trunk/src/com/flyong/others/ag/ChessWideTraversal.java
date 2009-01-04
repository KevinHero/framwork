package com.flyong.others.ag;

import java.awt.Point;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 查找同色围棋子的广度遍历方法。
 * 
 * 
 * 
 */
public class ChessWideTraversal {


  static char[][] chess = { { '1', '1', '1', '1', '1', '1', '1', '1', '1' },
    { '1', '1', '1', '1', '1', '1', '1', '1', '1' },
    { '1', '1', '1', '1', '0', '0', '0', '1', '1' },
    { '1', '1', '1', '1', '0', '1', '0', '1', '1' },
    { '1', '0', '0', '1', 'A', '1', '1', '1', '1' },
    { '1', '1', '0', '0', '0', '1', '1', '1', '1' },
    { '1', '1', '1', '1', '0', '1', '1', '1', '1' },
    { '1', '1', '1', '1', '0', '1', '1', '1', '1' },
    { '1', '1', '1', '1', '1', '1', '1', '1', '1' },
    { '1', '1', '1', '1', '1', '1', '1', '1', '1' } };
  

  // 如果已经遍历了，则不再重复
  static boolean[][] haveFound = new boolean[chess.length][chess[0].length];

  /**
   * 被查找的广度遍历。
   * 
   * @param x
   *          种子横坐标
   * @param y
   *          种子纵坐标
   * @param sign
   *          颜色
   * @return 同色数组
   */
  public static List<Point> find(int x, int y, char sign) {
    List<Point> list = new ArrayList<Point>();
    Point p = new Point(x, y);
    list.add(p); // 起始的种子
    for (int i = 0; i < list.size(); i++) {
      p = list.get(i);// 当前位置

      // 左侧，没有到边界
      if (p.x > 0) {
        // 数值等于0 且没有找过
        if (chess[p.y][p.x - 1] == sign && !haveFound[p.y][p.x - 1]) {
          list.add(new Point(p.x - 1, p.y));
          haveFound[p.y][p.x - 1] = true;
        }
      }

      // 上侧，没有到边界
      if (p.y > 0) {
        // 数值等于0 且没有找过
        if (chess[p.y - 1][p.x] == sign && !haveFound[p.y - 1][p.x]) {
          list.add(new Point(p.x, p.y - 1));
          haveFound[p.y - 1][p.x] = true;
        }
      }

      // 右侧，没有到边界
      if (p.x < chess[0].length - 1) {
        // 数值等于0 且没有找过
        if (chess[p.y][p.x + 1] == sign && !haveFound[p.y][p.x + 1]) {
          list.add(new Point(p.x + 1, p.y));
          haveFound[p.y][p.x + 1] = true;
        }
      }

      // 下侧，没有到边界
      if (p.y < chess[0].length - 1) {
        // 数值等于0 且没有找过
        if (chess[p.y + 1][p.x] == sign && !haveFound[p.y + 1][p.x]) {
          list.add(new Point(p.x, p.y + 1));
          haveFound[p.y + 1][p.x] = true;
        }
      }
    }
    return list;
  }

  /**
   * 以图形形式显示遍历结果
   */
  private static void printGraph() {
    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess[0].length; j++) {
        System.out.print(haveFound[i][j] ? '*' : ' ');
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) throws UnsupportedEncodingException {
    System.out.println(URLEncoder.encode("http://192.168.1.1:8080/resources/电话.xls","UTF-8"));
    List<Point> list = find(4, 4, '0');
    printGraph();
    for (Point p : list) {
      System.out.println(p.x + "," + p.y);
    }
  }

}
