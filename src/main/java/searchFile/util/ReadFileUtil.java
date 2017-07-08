package searchFile.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * 
 * @ClassName: ReadFileUtil
 * @Description: 读取单个文件并且转换成List<String>
 * @author shinian
 * @date 2017年7月8日 下午3:32:36
 * 
 */
public class ReadFileUtil {

    private static int index = 0;

    public static List<String> readFile(File file) {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        String str;
        List<String> strings = new ArrayList<>();
        try {
            while ((str = bf.readLine()) != null) {
                strings.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    public static void printList(List<String> list, Matcher matcher, String path) {
        if (list != null && list.size() > 0) {
            for (String line : list) {
                matcher.reset(line);// 重置
                while (matcher.find()) {
                    System.out.println(index++ + ": " + matcher.group() + ": "
                            + matcher.start() + " 文件名为: " + path);
                }
            }
        } else {
            //System.out.println(path + "内容为空!");
        }
    }
}
