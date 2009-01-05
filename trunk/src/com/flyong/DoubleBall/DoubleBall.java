package com.flyong.DoubleBall;

import java.util.ArrayList;   
import java.util.List;   
import java.util.Scanner;   
  
public class DoubleBall {   
	  
    // 用来保存产生的每注双色球号码   
    private List<int[]> ballList;   
    // 保存一注号码的数组   
    private int[] ball;   
  
    /**  
     * 构造方法  
     *   
     * @param number,产生号码的数量  
     */  
    public DoubleBall() {   
        Scanner s = new Scanner(System.in);   
        System.out.print("请输入产生随机号码数量:");   
        int number = s.nextInt();   
        this.init();   
        // 完成ballList的初始化   
        ballList = new ArrayList<int[]>();   
        for (int i = 0; i < number; i++) {   
            // 初始化ball   
            ball = new int[7];   
            // 产生一注号码   
            ball = this.createBall(ball);   
            ball = this.sort(ball);   
            // 将这注产生的号码添加到list之中   
            ballList.add(ball);   
        }   
    }   
  
    /**  
     * 产生双色球的七个号码  
     *   
     * @param ball  
     * @return  
     */  
    public int[] createBall(int[] ball) {   
        for (int i = 0; i < ball.length; i++) {   
            // 默认最后一个号码保留给蓝色球   
            if (i < ball.length - 1) {   
                // 如果是红色球，则验证每个产生的号码是否已经存在。   
                ball = this.validateBall(ball, i);   
            } else {   
                // 如果是蓝色球，直接产生1--16之间的随机数   
                ball[i] = (int) Math.round(Math.random() * 15 + 1);   
            }   
        }   
        // 产生号码完毕，返回这注产生的号码。   
        return ball;   
    }   
  
    /**  
     * 每次只产生一个红色号码，并验证此号码是否已经存在， 如果存在，重新产生号码，只到没有重复号码。  
     *   
     * @param ball  
     * @param index  
     *            产生红色球数组的下标，即第几个号码。  
     * @return  
     */  
    public int[] validateBall(int[] ball, int index) {   
        // 产生一个1--33的随机数   
        int random = (int) Math.round(Math.random() * 32 + 1);   
        while (true) {   
            int i = 0;   
            for (; i < index; i++) {   
                // 如果存在重复数字   
                if (random == ball[i]) {   
                    // 重新产生号码   
                    random = (int) Math.round(Math.random() * 32 + 1);   
                    // 并且跳出for循环，进入while循环   
                    i = index + 1;   
                }   
            }   
            // 如果验证完了所有号码，那把这个号码插入数组,并返回   
            if (i == index) {   
                ball[index] = random;   
                return ball;   
            }   
        }   
    }   
  
    /**  
     * 显示产生的双色球号码  
     *   
     */  
    public void displayBall() {   
        System.out.println("============产生号码的详细信息如下============");   
        for (int[] ball : ballList) {   
            for (int i = 0; i < ball.length; i++) {   
                // 如果号码不足两位数，在前面添加"0"显示。   
                System.out.print(((ball[i] < 10) ? ("0" + ball[i]) : ball[i])   
                        + "\t");   
            }   
            System.out.println();   
        }   
    }   
  
    /**  
     * 完成初始化，制定双色球号码的 开始和结束区域  
     *   
     */  
    public void init() {   
           
    }   
  
    /**  
     * 对号码进行排序,只对最后一个号码以前的 号码进行排序  
     *   
     * @param ball  
     * @return  
     */  
    private int[] sort(int[] ball) {   
        for (int i = 0; i < ball.length - 1; i++) {   
            for (int j = 0; j < ball.length - i - 2; j++) {   
                if (ball[j] > ball[j + 1]) {   
                    int t = ball[j];   
                    ball[j] = ball[j + 1];   
                    ball[j + 1] = t;   
                }   
            }   
        }   
        return ball;   
    }   
  
    public static void main(String[] args) {   
        DoubleBall ball = new DoubleBall();   
        ball.displayBall();   
    }   
  
}  
