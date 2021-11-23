import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

        String JsonData = data_s.substring(beginIndex, data_s.length()-2);

        System.out.println(JsonData);
        JSONObject jsonObject = JSON.parseObject(JsonData);

        JSONObject main = jsonObject.getJSONObject ( "main" ) ;
        System.out.println(main);
        JSONArray data = jsonObject.getJSONArray("data");
        System.out.println(data);

        String htmls = "";
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
            htmls += feeds.getHtml() + "<div>------------分割线------------<div/>";


        }




//        Elements links = doc.getElementsByTag("a");
//        for (Element link : links) {
//            String linkHref = link.attr("href");
//            String linkText = link.text();
//            System.out.println(linkText);
//        }
        int feed_id = 1;
        Document docs = Jsoup.parse(htmls);
        Elements feed_lis = docs.getElementsByClass("f-single");
        for (Element feed_li : feed_lis) {

            System.out.println("id:"+feed_id);

            Elements head = feed_li.getElementsByClass("f-single-head");
            String headText = head.text();
            System.out.println("Head:"+headText);

            Elements content = feed_li.getElementsByClass("f-single-content");
            String contentText = content.text();
            System.out.println("content:"+contentText);

            Elements foot = feed_li.getElementsByClass("f-single-foot");
            String footText = foot.text();
            System.out.println("foot:"+footText);

            Elements detailUrl = feed_li.getElementsByAttribute("data-detailurl");
            String detailUrlText = detailUrl.attr("data-detailurl");
            System.out.println(detailUrlText);

            Elements Src = feed_li.select("a.img-item>img");
            String srcText = Src.attr("src");
            System.out.println(srcText);

            feed_id ++;

        }

//        f-single-content f-wrap


        FileWriter writer;
        try {
            writer = new FileWriter("E:/data.html");
            writer.write(htmls);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
