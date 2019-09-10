package com.company.rawdata.generate;
import com.company.rawdata.generate.fileStreamTest2;

import java.io.IOException;

public class input {
    private static String path = "a.txt";
    public static void main(String[] args) throws IOException {
        fileStreamTest2 test = new fileStreamTest2();
        test.collect(path);
        while(test.hasNext()){
            System.out.println(test.generator());
        }
    }
}
