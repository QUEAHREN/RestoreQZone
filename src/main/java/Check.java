import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.awt.*;
import java.io.*;

public class Check {

    public static void main(String[] args) throws IOException {



        InputStream is = new FileInputStream("C:/Users/xsyoo/Desktop/Demo/Demo0.js");
        String line; // 用来保存每行读取的内容
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();

        System.out.println(buffer);

//        JSONObject jsonobject = JSON.parseObject();


    }

}
