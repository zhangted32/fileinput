package com.company.rawdata.generate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface DataCollector {
    /**
     * 给定一个log文件，做一些简单处理。optional
     * @param path
     */
    void collect(String path) throws IOException;
}
