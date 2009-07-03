package com.flyong.pic;

import java.io.IOException;

import com.flyong.Random.RandomString;

public class Test {   
    public static void main(String[] args) {   
        try{   
            StringBuffer sb = new StringBuffer();   
            
            String str="qwertt";
            int len=10*(int)Math.random();
            String r=RandomString.genRandomNumber(6);
           
            sb.append(r);   
            //sb.append("中华人民共和国eeeee\n");   
               
            FileImageCreator creator = new FileImageCreator(new SimpleDrawer(), "d:\\test\\1.jpeg");   
            creator.setWidth(60); //图片宽度   
            creator.setHeight(30); //图片高度   
            creator.setLineNum(1); //干扰线条数   
            creator.setFontSize(15); //字体大小   
            creator.setFontName("黑体");   
               
            //文字旋转   
            creator.setRadian(1.0); //旋转弧度   
            creator.setRotateX(creator.getWidth()/5);   
            creator.setRotateY(creator.getHeight()*5/10);   
               
            creator.generateImage(sb.toString());   
               
            System.out.println("ok");   
               
        }catch(IOException ex){   
            ex.printStackTrace();   
        }   
    }   
}  
