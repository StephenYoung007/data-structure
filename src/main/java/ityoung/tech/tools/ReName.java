package ityoung.tech.tools;

import java.io.File;

public class ReName {

    public static void main(String[] args) {
        rename();
    }

    private static void rename() {
        File dir = new File("E:\\尚硅谷 韩顺平 Java数据结构和算法\\视频");
        String dest = "E:\\尚硅谷 韩顺平 Java数据结构和算法\\视频\\";
        File[] files = dir.listFiles();
        for (File file : files) {
            String oldName = file.getName();
            System.out.println(oldName);
            String order = oldName.substring(0, 3);
            String desc = oldName.substring(23);
            String newName = order + desc;
            System.out.println(newName);
            file.renameTo(new File(dest + newName));
        }
    }
}
