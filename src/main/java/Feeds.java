public class Feeds {

    private String opuin;
    private String nickname;
    private String uin;
    private String logimg;
    private String feedstime;
    private String html;

    public String getOpuin() {
        return opuin;
    }
    public String getUin() {
        return uin;
    }
    public String getFeedstime() {
        return feedstime;
    }
    public String getHtml() {
        return html;
    }
    public String getLogimg() {
        return logimg;
    }
    public String getNickname() {
        return nickname;
    }

    public void setFeedstime(String feedstime) {
        this.feedstime = feedstime;
    }
    public void setHtml(String html) {
        this.html = html;
    }
    public void setLogimg(String logimg) {
        this.logimg = logimg;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setOpuin(String opuin) {
        this.opuin = opuin;
    }
    public void setUin(String uin) {
        this.uin = uin;
    }

//    private String processHtml(){
//
//
//    }

    @Override
    public String toString(){

        String str = "昵称:" + nickname + "\n" +
                "log链接:" + logimg + "\n" +
                "时间:" + feedstime + "\n" +
                "opuin:" + opuin + "\n" +
                "uin:" + uin + "\n" +
                "html:" + html + "\n";
        return str;

    }
}
