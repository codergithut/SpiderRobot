package util;


import java.io.File;
import java.io.IOException;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/9/8
 * @description
 */
public class HttpFileUtil {
    private final static String path = "D:\\htmlcontent";

    private final static String suffix = ".hl";

    public static void saveStringToFile(String content, String root, String name) throws IOException {
        File file = new File(path + "\\" + root);

        if(!file.exists()) {
            file.mkdir();
        }

        System.out.println(content);

        FileUtil.saveStringToFile(content, new File(path + "\\" + root + "\\" + name + suffix));

    }
}
