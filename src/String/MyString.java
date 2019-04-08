package String;

import java.util.Arrays;

public class MyString {
    private char value[]; //字符数组及字符长度
    private int len;
    //3种构造函数
    public MyString() {
        this.value = new char[0];
    }

    public MyString(int capacity){
        value=new char[capacity];
    }

    public MyString(MyString original) {
        this.value = original.value;
        this.len = original.len;
    }
//获取字符串
    public char[] getValue() {
        return value;
    }
//获取字符串长度
    public int getLen(){
        return len;
    }
//获取字符数组容量
    public int getCapacity(){
        return value.length;
    }
//扩容方法
    public void expandCapacity(int minimumCapacity){
        if(minimumCapacity>value.length)/*判断是否超出当前容量*/ {
            int newCapacity = (value.length + 1) * 2;
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            } else if (minimumCapacity > newCapacity) {
                newCapacity = minimumCapacity;
            }
            value = Arrays.copyOf(value, newCapacity);
        }
    }
//减小容量方法
    public void reduceCapacity(){
        if(len<value.length){
            value=Arrays.copyOf(value,len);
        }
    }
//替换单个字符
    public void setChar(int index,char ch){
        if((index<0)||(index>=len))
            throw new StringIndexOutOfBoundsException(index);
        value[index-1]=ch;
    }
//查看某个位置字符
    public char charAt(int index) {
        if ((index < 0) || (index >= len))
            throw new StringIndexOutOfBoundsException(index);
        return value[index];
    }

//在我的字符串末尾处添加字符串
    public MyString append(String str){
        if(str == null) str ="null";//检查字符串是否为空;
        int len =str.length();
        if(len == 0)return this;//判断字符串长度是否为零
        int newlen = this.len +len;
        expandCapacity(newlen);//扩容
        str.getChars(0, len, value, this.len);
        this.len = newlen;
        return this;
    }

    public static void main(String[] args) {
        MyString ms = new MyString(10);
        ms.append("666").append("xxx");
        MyString ns = new MyString(ms);
        ms.setChar(1,'8');
        ms.append("rrr");
        ns.expandCapacity(200);
        System.out.println(ms.getValue());
        System.out.println(ms.getLen());
        System.out.println(ns.getLen());
        System.out.println(ns.getCapacity());

    }
}




