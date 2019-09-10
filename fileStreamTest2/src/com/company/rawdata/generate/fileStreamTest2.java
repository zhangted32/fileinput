package com.company.rawdata.generate;
//文件名 :fileStreamTest2.java
import java.io.*;
import java.util.*;
import java.lang.*;
import com.company.rawdata.generate.DataCollector;
import com.company.rawdata.generate.DataGenerator;

public class fileStreamTest2 implements DataGenerator, DataCollector{
    private static ArrayList<String> list;

    private static File f;
    private int index = 0;


    @Override
    public void collect(String path) throws IOException {
        list = (ArrayList<String>) readTxtFileIntoStringArrList(path);
    }

    @Override
    public boolean hasNext() {
        if (index >= list.size())
            return false;
        else
            return true;
    }

    @Override
    public String generator() {
        if (hasNext()) {
            index = index + 1;
            return list.get(index - 1);

        }
        else
            return null;
    }
    public static List<String> readTxtFileIntoStringArrList(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }

}
