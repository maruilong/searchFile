package searchFile;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import searchFile.util.ReadFileUtil;

public class Application {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("条件");// 这里面是条件
        Matcher matcher = pattern.matcher("");// 这里不填在里面进行替换
        // 你要搜索的路径
        searchFile("d://blog", matcher);
    }

    public static void searchFile(String path, Matcher matcher) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        searchFile(file2.getAbsolutePath(), matcher);// 如果是文件夹,继续执行
                    } else {
                        List<String> strings = ReadFileUtil.readFile(file2);// 读取文件
                        ReadFileUtil.printList(strings, matcher,
                                file2.getAbsolutePath());// 输出
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
