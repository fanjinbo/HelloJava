package com.fanjinbo.future;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by kevin on 2016/11/23.
 */
public class FutureTest {

    public static void main(String[] args){
        //TODO enter your code
        Scanner in = new Scanner(System.in);
        System.out.println("输入起始目录");
        String diretory = in.nextLine();
        System.out.println("输入关键字");
        String keyword = in.nextLine();
        MathCounter counter = new MathCounter(new File(diretory), keyword);
        FutureTask<Integer> task = new FutureTask<Integer>(counter);
        Thread t = new Thread(task);
        t.start();
        try {
            System.out.println(task.get() + "找到文件");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}



