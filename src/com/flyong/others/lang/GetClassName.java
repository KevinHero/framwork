package com.flyong.others.lang;

/**
 * 得到类的名字。
 * 
 * 
 * 
 */
public class GetClassName {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 类的全名
    Class cls = java.lang.String.class;
    String name = cls.getName(); // java.lang.String

    // 内部类的全名
    cls = java.util.Map.Entry.class;
    name = cls.getName(); // java.util.Map$Entry

    // 得到不完整的类名
    cls = java.util.Map.Entry.class;
    name = cls.getName();
    if (name.lastIndexOf('.') > 0) {
      name = name.substring(name.lastIndexOf('.') + 1); // Map$Entry
    }

    // $ 可以被替换为 .
    name = name.replace('$', '.'); // Map.Entry

    // 得到主类型的名字
    name = int.class.getName(); // int

    // 得到数组的名字
    name = boolean[].class.getName(); // [Z
    name = byte[].class.getName(); // [B
    name = char[].class.getName(); // [C
    name = short[].class.getName(); // [S
    name = int[].class.getName(); // [I
    name = long[].class.getName(); // [J
    name = float[].class.getName(); // [F
    name = double[].class.getName(); // [D
    name = String[].class.getName(); // [Ljava.lang.String;
    name = int[][].class.getName(); // [[I

    // 得到 void 类型的名字
    cls = Void.TYPE;
    name = cls.getName(); // void
  }
}
