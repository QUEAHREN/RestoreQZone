public class Feeds {

    private String opuin;
    private String nickname;
    private String uin;
    private String logimg;
    private String feedstime;
    private String html;

    private String headText;
    private String contentText;
    private String footText;
    private String detailUrl;
    private String imgUrl;
    private String logoUrl;


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
    public String getContentText() {
        return contentText;
    }
    public String getDetailUrl() {
        return detailUrl;
    }
    public String getFootText() {
        return footText;
    }
    public String getHeadText() {
        return headText;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public String getLogoUrl() {
        return logoUrl;
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
    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
    public void setFootText(String footText) {
        this.footText = footText;
    }
    public void setHeadText(String headText) {
        this.headText = headText;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }


    @Override
    public String toString(){

        String str = "昵称:" + nickname + "QQ号:" + uin + "操作时间:" + feedstime + '\n' +
                "Head:" + headText + '\n' +
                "Content:" + contentText + '\n' +
                "Foot:" + footText + '\n' +
                "缩略图Url:" + imgUrl + '\n' +
                "头像Url:" + logoUrl + '\n' +
                "原始地址:" + detailUrl + '\n' +
                "--------------------------------------------------------------\n";
        return str;

    }

}
