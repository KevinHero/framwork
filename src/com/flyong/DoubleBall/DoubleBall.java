package com.flyong.DoubleBall;

import java.util.ArrayList;   
import java.util.List;   
import java.util.Scanner;   
  
public class DoubleBall {   
  
    // ��4��������ÿע˫ɫ�����   
    private List<int[]> ballList;   
    // ����һע���������   
    private int[] ball;   
  
    /**  
     * ���췽��  
     *   
     * @param number,����������  
     */  
    public DoubleBall() {   
        Scanner s = new Scanner(System.in);   
        System.out.print("�����������������:");   
        int number = s.nextInt();   
        this.init();   
        // ���ballList�ĳ�ʼ��   
        ballList = new ArrayList<int[]>();   
        for (int i = 0; i < number; i++) {   
            // ��ʼ��ball   
            ball = new int[7];   
            // ����һע����   
            ball = this.createBall(ball);   
            ball = this.sort(ball);   
            // ����ע����ĺ�����ӵ�list֮��   
            ballList.add(ball);   
        }   
    }   
  
    /**  
     * ����˫ɫ����߸����  
     *   
     * @param ball  
     * @return  
     */  
    public int[] createBall(int[] ball) {   
        for (int i = 0; i < ball.length; i++) {   
            // Ĭ�����һ����뱣���6ɫ��   
            if (i < ball.length - 1) {   
                // ����Ǻ�ɫ������֤ÿ�����ĺ����Ƿ��Ѿ����ڡ�   
                ball = this.validateBall(ball, i);   
            } else {   
                // �����6ɫ��ֱ�Ӳ���1--16֮��������   
                ball[i] = (int) Math.round(Math.random() * 15 + 1);   
            }   
        }   
        // ���������ϣ�������ע����ĺ��롣   
        return ball;   
    }   
  
    /**  
     * ÿ��ֻ����һ���ɫ���룬����֤�˺����Ƿ��Ѿ����ڣ� �����ڣ����²�����룬ֻ��û���ظ����롣  
     *   
     * @param ball  
     * @param index  
     *            �����ɫ��������±꣬���ڼ�����롣  
     * @return  
     */  
    public int[] validateBall(int[] ball, int index) {   
        // ����һ��1--33�������   
        int random = (int) Math.round(Math.random() * 32 + 1);   
        while (true) {   
            int i = 0;   
            for (; i < index; i++) {   
                // �������ظ�����   
                if (random == ball[i]) {   
                    // ���²������   
                    random = (int) Math.round(Math.random() * 32 + 1);   
                    // �������forѭ��������whileѭ��   
                    i = index + 1;   
                }   
            }   
            // �����֤�������к��룬�ǰ��������������,������   
            if (i == index) {   
                ball[index] = random;   
                return ball;   
            }   
        }   
    }   
  
    /**  
     * ��ʾ�����˫ɫ�����  
     *   
     */  
    public void displayBall() {   
        System.out.println("============����������ϸ��Ϣ����============");   
        for (int[] ball : ballList) {   
            for (int i = 0; i < ball.length; i++) {   
                // �����벻��}λ����ǰ�����"0"��ʾ��   
                System.out.print(((ball[i] < 10) ? ("0" + ball[i]) : ball[i])   
                        + "\t");   
            }   
            System.out.println();   
        }   
    }   
  
    /**  
     * ��ɳ�ʼ�����ƶ�˫ɫ������ ��ʼ�ͽ�������  
     *   
     */  
    public void init() {   
           
    }   
  
    /**  
     * �Ժ����������,ֻ�����һ�������ǰ�� �����������  
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

