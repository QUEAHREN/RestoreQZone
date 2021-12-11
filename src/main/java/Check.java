import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Check {

    public static void main(String[] args) throws IOException, SQLException {

        InputStream is = new FileInputStream("C:/Users/xsyoo/Desktop/Demo/DATA0.json");
        String line; // 用来保存每行读取的内容
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行


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
        String JsonData = data_s.substring(beginIndex, data_s.length()-2);

        System.out.println(JsonData);
        JSONObject jsonObject = JSON.parseObject(JsonData);

        JSONObject main = jsonObject.getJSONObject ( "main" ) ;
        System.out.println(main);
        JSONArray data = jsonObject.getJSONArray("data");
        System.out.println(data);

        ArrayList<Feeds> feedsList = new ArrayList<>();

        StringBuilder htmls = new StringBuilder();
        System.out.println(data.size());
        for (int i = 0; i < data.size()-1; i++) {

            JSONObject datai = data.getJSONObject(i);

            String feedstime = datai.getString("feedstime");
            String html = datai.getString("html");
            String logimg = datai.getString("logimg");
            String nickname = datai.getString("nickname");
            String opuid = datai.getString("opuin");
            String uin = datai.getString("uin");

            Feeds feeds = new Feeds();
            feeds.setFeedstime(feedstime);
            feeds.setHtml(html);
            feeds.setLogimg(logimg);
            feeds.setNickname(nickname);
            feeds.setOpuin(opuid);
            feeds.setUin(uin);
            htmls.append(feeds.getHtml()).append("<div>------------分割线------------</div>");

            Document feed_li = Jsoup.parse(html);
            Elements head = feed_li.getElementsByClass("f-single-head");
            feeds.setHeadText(head.text());

            Elements content = feed_li.getElementsByClass("f-single-content");
            feeds.setContentText(content.text());

            Elements foot = feed_li.getElementsByClass("f-single-foot");
            feeds.setFootText(foot.text());

            Elements detailUrl = feed_li.getElementsByAttribute("data-detailurl");
            feeds.setDetailUrl(detailUrl.attr("data-detailurl"));

            Elements imgUrl = feed_li.select("a.img-item>img");
            feeds.setImgUrl(imgUrl.attr("src"));

            Elements logoUrl = feed_li.select("div.user-pto>a>img");
            feeds.setLogoUrl(logoUrl.attr("src"));

            feedsList.add(feeds);
            feeds.updateDB();

        }



        for (Feeds feed:feedsList){
            System.out.println(feed.toString());
        }


        FileWriter writer;
        try {
            writer = new FileWriter("E:/data.html");
            writer.write(htmls.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void merge(ArrayList<Feeds> feedsList){

        feedsList.sort(new Comparator<Feeds>() {
            @Override
            public int compare(Feeds o1, Feeds o2) {
                return o1.getContentText().compareTo(o2.getContentText());
            }
        });



    }


}
