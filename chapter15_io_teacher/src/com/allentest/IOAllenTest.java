package com.allentest;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * ClassName: IOAllenTest
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023.11.20 10:29
 * @ Version: v1.0
 */
public class IOAllenTest {
    //需求，找到C:\Users\hanyu\Pictures\Saved Pictures\桌面壁纸\1代文件夹中.jpg的文件，并输出
    @Test
    public void test01(){
        File file = new File("C:\\Users\\hanyu\\Pictures\\Saved Pictures\\桌面壁纸\\1代");

        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
//                System.out.println(dir.toString());
                //如果文件名以。jpb结尾，那就返回true，否则返回false；
                return name.endsWith(".jpg");
            }
        });
        if(list != null){
            for (String s : list) {
                System.out.println(s);
            }
        }else {
            System.out.println("没有包含.jpg结尾名称的文件");
        }
    }

    /*
    遍历指定文件目录下的所有文件的名称，包括子文件目录中的文件。(C:\Users\hanyu\Pictures\Saved Pictures\桌面壁纸)
public void printFileName(File file)  //file可能是文件，也可能是文件目录
     */
    @Test
    public void test02(){
        File file = new File("C:\\Users\\hanyu\\Pictures\\Saved Pictures\\桌面壁纸");

        printFileName(file);
    }

    public void printFileName(File file){
        //判定file类型
        if(file.isFile()){
            System.out.println("file.getName() = " + file.getName());
        } else if (file.isDirectory()) {
            for (File listFile : file.listFiles()) {
                printFileName(listFile);
            }
        }
//        for (File listFile : file.listFiles()) {
//            if(listFile.isFile()){
//                System.out.println("listFile.getName() = " + listFile.getName());
//            } else if (listFile.isDirectory()) {
//                printFileName(listFile);
//            }
//        }

    }

    //递归删除文件夹中文件:C:\Users\hanyu\Desktop\新建文件夹
    @Test
    public void test03(){
        File file = new File("C:\\Users\\hanyu\\Desktop\\新建文件夹");
        deleteFile(file);
    }

    private void deleteFile(File file) {
        if(file.isDirectory()){
            File[] listFiles = file.listFiles();
            for (File listFile : listFiles) {
                deleteFile(listFile);
            }
        }
        file.delete();
    }

    /*
    复制文件AllenHelloIO.txt 为 AllenHelloIO_copy.txt
     */
    @Test
    public void test04(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1：创建读取或者写出文件对象
            File sourceFile = new File("AllenHelloIO.txt");
            File destnationFile = new File("AllenHelloIO_copy.txt");
            System.out.println("sourceFile.getAbsolutePath() = " + sourceFile.getAbsolutePath());

            //2：创建输入&输出流+读入&写出
            fileReader = new FileReader(sourceFile);
            fileWriter = new FileWriter(destnationFile);

            char[] chars = new char[10];
            int read;
            while ((read = fileReader.read(chars))!=-1){
                fileWriter.write(chars, 0, read);
            }

            System.out.println("copy succeed!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            if(fileReader!=null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if(fileWriter!=null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    @Test
    public void test05() throws IOException {
        File fileSource = new File("D:\\【learn】CS视频教程\\code_doc_course_ebook_note\\learning_course\\atguigu_java入门基础2023\\01_课件与电子教材\\01_课件与电子教材\\01_课件与电子教材\\尚硅谷_第15章_File类与IO流\\images\\1_charset.jpg");
        File fileDest = new File("1_charset_copy.jpg");

        FileUtils.copyFile(fileSource,fileDest);
        System.out.println("使用Apache.commons.io传输完成。");
    }


}
