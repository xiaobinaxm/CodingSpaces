import org.junit.Test;

import java.io.File;

/**
 * @Description
 * @Author Robin
 * @Date 2019/9/27 23:56
 */
public class CodeTest {

    int d = 0;
    @Test
    public void test(){
        File file = new File("E:\\testFile");
        delFile(file);
    }

    public static void delFile(File file){
        File[] files = file.listFiles();
        if (files != null && files.length != 0){
            for (File file1 : files){
                delFile(file1);
            }
            /*for (int i = 0; i < files.length; i++) {
                delFile(files[i]);
            }*/
        }
        System.out.println(file.getName());
        file.delete();
    }

}
