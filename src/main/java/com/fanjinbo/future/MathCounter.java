package com.fanjinbo.future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 统计指定包含给定字段的文件夹和子目录里面的文件的数量
 * 继承了Callable接口实现call方法来查找文件
 * Created by kevin on 2016/11/23.
 */
public class MathCounter implements Callable<Integer>{

    private File directory;
    private String keyword;
    private int count;

    /**
     * java.util.concurrent.Callable<V>
     *     V call()
     *     运行一个将产生结果的任务
     * @return
     * @throws Exception
     */
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<Future<Integer>>();

            for (File file : files){
                if (file.isDirectory()){
                    MathCounter counter = new MathCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<Integer>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }
                else {
                    if (search(file))
                        count++;
                    System.out.println(file.getPath());
                    System.out.println("1:    " + count);
                }
                for (Future<Integer> result : results){
                    try {
                        count += result.get();
                        System.out.println("2:    " + count);
                    }catch (ExecutionException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return count;
    }

    public boolean search(File file){
        try {
            try(Scanner in = new Scanner(file)) {
                boolean found = false;
                while (!found && in.hasNextLine()){
                    String line = in.nextLine();
                    if (line.contains(keyword))
                        found = true;
                }
                return found;
            }
        }catch (IOException ex){
            return false;
        }
    }

    public MathCounter(File directory, String keyword){
        this.directory = directory;
        this.keyword = keyword;
    }

}
