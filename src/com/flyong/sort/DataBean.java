package com.flyong.sort;

import java.io.Serializable;
import java.text.MessageFormat;

public class DataBean implements Serializable{
	private static final long serialVersionUID = 1L;   
	  
    private long id;   
    private String name;   
    private String sex;   
  
    public DataBean() {   
  
    }   
  
    public DataBean(long id, String name, String sex) {   
        this.id = id;   
        this.name = name;   
        this.sex = sex;   
    }   
  
    public long getId() {   
        return id;   
    }   
  
    public void setId(long id) {   
        this.id = id;   
    }   
  
    public String getName() {   
        return name;   
    }   
  
    public void setName(String name) {   
        this.name = name;   
    }   
  
    public String getSex() {   
        return sex;   
    }   
  
    public void setSex(String sex) {   
        this.sex = sex;   
    }   
  
    @Override  
    public String toString() {   
        return MessageFormat.format("id:{0},name:{1},sex:{2}", this.id,   
                this.name, this.sex);   
    }   


}
