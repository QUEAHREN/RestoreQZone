import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.awt.*;
import java.io.*;


public class Check {

    public static void main(String[] args) throws IOException {



        InputStream is = new FileInputStream("C:/Users/xsyoo/Desktop/Demo/DATA0.json");
        String line; // 用来保存每行读取的内容
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行


        int flag = 0;
        while (line != null) { // 如果 line 为空说明读完了
            if (line.equals("\t\"data\":")) {
                line = reader.readLine(); // 读取下一行
                buffer.append(line); // 将读到的内容添加到 buffer 中
                buffer.append("\n"); // 添加换行符
                break;
            }
            line = reader.readLine(); // 读取下一行

        }
        reader.close();
        is.close();

        String data_s = buffer.toString();

        int beginIndex = 0;
//        for (int i = 0; i < data_s.length(); i ++){
//            if (data_s.charAt(i) == '[') {
//                beginIndex = i;
//                break;
//            }
//        }
        String JsonData = data_s.substring(beginIndex, data_s.length()-2);

        System.out.println(JsonData);
        JSONObject jsonObject = JSON.parseObject(JsonData);

        JSONObject main = jsonObject.getJSONObject ( "main" ) ;
        System.out.println(main);
        JSONArray data = jsonObject.getJSONArray("data");
        System.out.println(data);

        for (int i = 0; i < 2; i++) {

            JSONObject datai = data.getJSONObject(i);

            String feedstime = datai.getString("feedstime");
            String html = datai.getString("html");
            String logimg = datai.getString("logimg");
            String nickname = datai.getString("nickname");
            String opuid = datai.getString("opuid");
            String uin = datai.getString("uin");

            Feeds feeds = new Feeds();
            feeds.setFeedstime(feedstime);
            feeds.setHtml(html);
            feeds.setLogimg(logimg);
            feeds.setNickname(nickname);
            feeds.setOpuin(opuid);
            feeds.setUin(uin);

            System.out.println(feeds.toString());

        }



    }

}
