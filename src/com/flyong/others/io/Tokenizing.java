package com.flyong.others.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * 文件拆分。
 * 
 * 
 * 
 */
public class Tokenizing {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      // 读取文件进行拆分
      FileReader rd = new FileReader("src/net/java2000/io/Tokenizing.java");
      StreamTokenizer st = new StreamTokenizer(rd);

      // Java格式的拆分规则
      st.parseNumbers();
      st.wordChars('_', '_');
      st.eolIsSignificant(true);

      // 允许空格
      st.ordinaryChars(0, ' ');

      // 屏蔽掉注释
      st.slashSlashComments(true);
      st.slashStarComments(true);

      // 解析文件
      int token = st.nextToken();
      while (token != StreamTokenizer.TT_EOF) {
        token = st.nextToken();
        System.out.println(token);
        switch (token) {
        case StreamTokenizer.TT_NUMBER:
          // A number was found; the value is in nval
          double num = st.nval;
          break;
        case StreamTokenizer.TT_WORD:
          // A word was found; the value is in sval
          String word = st.sval;
          break;
        case '"':
          // A double-quoted string was found; sval contains the contents
          String dquoteVal = st.sval;
          break;
        case '\'':
          // A single-quoted string was found; sval contains the contents
          String squoteVal = st.sval;
          break;
        case StreamTokenizer.TT_EOL:
          // End of line character found
          break;
        case StreamTokenizer.TT_EOF:
          // End of file has been reached
          break;
        default:
          // A regular character was found; the value is the token itself
          char ch = (char) st.ttype;
          break;
        }
      }
      rd.close();
    } catch (IOException e) {
    }

  }

}
