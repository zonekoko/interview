package com.zyp.interview.util;


import com.alibaba.fastjson.JSON;
import com.zyp.interview.vo.ExportTemplateVO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/21 09:40
 */
public class LocalJsonUtil {

    public static <T> List<T> getListFromJson(String path, Class<T> clazz) throws IOException {
//        final String jsonFilePath = LocalJsonUtil.class.getClassLoader().getResource(path).getPath();
        final InputStream is = LocalJsonUtil.class.getClassLoader().getResourceAsStream(path);
        BufferedReader br = null;
        StringWriter sw = new StringWriter();
        try {
            br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1024 * 4];
            int n = 0;
            while ((n = br.read(buffer)) != -1) {
                sw.write(buffer,0,n);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("未找到该文件");
        } finally {
            br.close();
            sw.close();
        }
        final String json = sw.toString();

        final List<T> ts = JSON.parseArray(json, clazz);
        return ts;
    }
}
