package com.qianfeng;

import lombok.Data;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestBasic {


    //读写文件内容
    @Test
    public void testIo() throws IOException {
        FileInputStream in = new FileInputStream("F://aa.txt");
        byte[] b = new byte[1024];
        int len = 0 ;
        while ((len =in.read(b)) >= 0) {
            System.out.println(new String (b,0,len));
        }
        in.close();
    }
    //读写文件
    @Test
    public void testIo1 () throws IOException {
        FileOutputStream out = new FileOutputStream("F://11.txt");
        FileInputStream  in = new FileInputStream("F://aa.txt");

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = in.read(b)) >= 0 ) {
            out.write(b,0,len);
        }
        out.close();
        in.close();
    }
    @Test
    public void testIo2() throws IOException {
        FileWriter fileWriter = new FileWriter("F://aa.txt");
        fileWriter.write("Test\r");
        fileWriter.write("wxx\r");
        fileWriter.close();
    }
@Test
 public void testClass (){
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setBirthday("2020-05-26");
        employee.setName("lisi");
        employee.Employee();
 }
@Test
 public void testSm(){
    System.out.println(("1232".equals("345"))?"123":"test");
 }

@Test
 public void testWhile(){
        int i = 10;
        while (i < 20) {
            i++;
            System.out.println("i = " + i);
        }
 }
 @Test
public void testDowhile(){
        int i = 15;
    do {
        i++;
        System.out.println("i = " + i);
    } while (i < 20);
}
@Test
public void testFor(){
        int [] i = {1,2,10,30};
        for (int j:i){
            if(j == 10){
                break;
            }
            System.out.println("j = " + j);
        }
}
@Test
public void testSwitch(){
    int i = 10;
    switch (i){
        case 1:
            System.out.println("i = " + i);
        break;
        case 3:
            System.out.println("i = " + i);
            break;
        case 10:
            System.out.println("i = " + (i+1));
            break;
        case 4:
            System.out.println("i = " + i);
            break;
    }
}
@Test
public void testPattern (){
        String line = "sdfskgfj23hkvkxcvb";
        String pattern = "(.*)(\\d)(.*)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(line);
    if (m.find( )) {
        System.out.println("Found value: " + m.group(0) );
        System.out.println("Found value: " + m.group(1) );
        System.out.println("Found value: " + m.group(2) );
    } else {
        System.out.println("NO MATCH");
    }
 }
 @Test
public void testMath (){
    System.out.println("Math.sin(Math.PI/2) = " + Math.sin(Math.PI/2));
}
@Test
public void testArray(){
        char[]  helloArray = {'h','e','l','l','o'};
        String helloString = new String (helloArray);
        System.out.println("helloString = " + helloString);

        String str = "dfg dfgf test";
        int len = str.length();
        System.out.println("len = " + len);


        //打印所有的数组
        double[] myList = {1,23,34,2,5,7};
    for (int i = 0; i < myList.length ; i++) {
       // System.out.println("i = " + myList[i]);
    }
    //求数组的值
    double j = 0;
    for (int i = 0; i <myList.length ; i++) {
            j = j+myList[i];
    }
    System.out.println("j = " + j);
    // 取出数组中的值
    double max = myList[0];
    for (int i = 0; i < myList.length; i++) {
        if(max < myList[i]){
            max = myList[i];
        }
    }
    System.out.println("max = " + max);
    }

    @Test
    public void testIoRead() throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));

        System.out.println("Enter characters, 'q' to quit.");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while(c != 'q');
    }
    @Test
    public void testScanner (){
        Scanner sc = new Scanner(System.in);
        System.out.println("next 方式接受" );
        if (sc.hasNext()){
            String str = sc.next();
            System.out.println("str = " + str);
        }
    }

}


@Data
class Employee {
    private int age;
    private String name;
    private String birthday;

    public void Employee (){
        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("birthday = " + birthday);
    }

}