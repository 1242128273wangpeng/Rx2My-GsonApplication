package com.example.wangpeng.mygsonapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wangpeng on 2017/9/21.
 */

public class ResultDetail {

    /**
     * reason : 查询成功
     * result : [{"title":"首个街区制公租房小区年底入住","content":"在2013年郭公庄一期<em>公租房<\/em>项目规划设计时,就敲定要走\"开放式小区\"的路线--不设围墙、密路网、窄道路。 \" 内部形成的路网接入市政道路,每条道路宽度只有4到6米。\"韩风磊是郭公庄一期<em>公租房<\/em>项目的设计负责人,早在住建部门提倡\"街区制\"之前,他的设计团队就希望能借鉴国外不少高...","img_width":"","full_title":"首个街区制公租房小区年底入住","pdate":"4小时前","src":"新华网","img_length":"","img":"","url":"http://news.xinhuanet.com/house/2017-09-22/c_1121705097.htm","pdate_src":"2017-09-22 07:49:49"},{"title":"快申请!通州宋庄批复20万平米公租房,投资15亿、配建幼儿园!","content":"那么问题来了,<em>公租房<\/em>是如何申请的呢?哪些人可以申请<em>公租房<\/em>?<em>公租房<\/em>又有哪些优点?如何获得租房补贴?要准备哪些申请材料呢? 下面是超详细版<em>公租房<\/em>申请攻略,在助您变身为<em>公租房<\/em>申请知识小达人的同时,祝您安居北京! <em>公租房<\/em>申请攻略 申请<em>公租房<\/em>有哪些好处?1 北京集体户口租<em>公租<\/em>...","img_width":"324","full_title":"快申请!通州宋庄批复20万平米公租房,投资15亿、配建幼儿园!","pdate":"5小时前","src":"今日爆点","img_length":"640","img":"http://p8.qhimg.com/t01e7173a239b436d76.jpg","url":"http://sh.qihoo.com/pc/detail?check=44b05086272b0888&sign=360_e39369d1&url=http://zm.news.so.com/03fba333285c29317f4af60f3e7fa25f","pdate_src":"2017-09-22 06:45:00"},{"title":"逾万套公租房申请不限收入","content":"本次推出分配的<em>公租房<\/em>采取单位整体租赁模式,而只要是住所地在本市、申请之日已取得法人资格的单位均可申请。具体来说主要分为两类,第一类是《广州市新就业无房职工公共租赁住房保障办法》列明的广州市高新技术企业、创新标杆企业、高等院校、科研机构,以及政法、医疗、交...","img_width":"","full_title":"逾万套公租房申请不限收入","pdate":"5小时前","src":"新浪","img_length":"","img":"","url":"http://news.sina.com.cn/c/2017-09-22/doc-ifymenmt6052898.shtml","pdate_src":"2017-09-22 06:34:04"},{"title":"万套公租房 用人单位莫错过","content":"广州日报讯 (全媒体记者何颖思 通讯员穗建)昨日记者从广州市住房保障办获悉,广州市推出第二批面向用人单位整体租赁的新就业无房职工<em>公租房<\/em>共12100套,今日起受理用人单位申请。与第一批相比,这次面向的单位范围有所拓宽,凡是住所地在广州、申请之日已取得法人资格的单位均可...","img_width":"","full_title":"万套公租房 用人单位莫错过","pdate":"7小时前","src":"凤凰网","img_length":"","img":"","url":"http://news.ifeng.com/a/20170922/52112819_0.shtml","pdate_src":"2017-09-22 04:00:48"}]
     * error_code : 0
     */

    @SerializedName("reason")
    private String reason;
    @SerializedName("error_code")
    private int errorCode;
    @SerializedName("result")
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "ResultDetail{" +
                "reason='" + reason + '\'' +
                ", errorCode=" + errorCode +
                ", result=" + result +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * title : 首个街区制公租房小区年底入住
         * content : 在2013年郭公庄一期<em>公租房</em>项目规划设计时,就敲定要走"开放式小区"的路线--不设围墙、密路网、窄道路。 " 内部形成的路网接入市政道路,每条道路宽度只有4到6米。"韩风磊是郭公庄一期<em>公租房</em>项目的设计负责人,早在住建部门提倡"街区制"之前,他的设计团队就希望能借鉴国外不少高...
         * img_width :
         * full_title : 首个街区制公租房小区年底入住
         * pdate : 4小时前
         * src : 新华网
         * img_length :
         * img :
         * url : http://news.xinhuanet.com/house/2017-09-22/c_1121705097.htm
         * pdate_src : 2017-09-22 07:49:49
         */

        @SerializedName("title")
        private String title;
        @SerializedName("content")
        private String content;
        @SerializedName("img_width")
        private String imgWidth;
        @SerializedName("full_title")
        private String fullTitle;
        @SerializedName("pdate")
        private String pdate;
        @SerializedName("src")
        private String src;
        @SerializedName("img_length")
        private String imgLength;
        @SerializedName("img")
        private String img;
        @SerializedName("url")
        private String url;
        @SerializedName("pdate_src")
        private String pdateSrc;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImgWidth() {
            return imgWidth;
        }

        public void setImgWidth(String imgWidth) {
            this.imgWidth = imgWidth;
        }

        public String getFullTitle() {
            return fullTitle;
        }

        public void setFullTitle(String fullTitle) {
            this.fullTitle = fullTitle;
        }

        public String getPdate() {
            return pdate;
        }

        public void setPdate(String pdate) {
            this.pdate = pdate;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getImgLength() {
            return imgLength;
        }

        public void setImgLength(String imgLength) {
            this.imgLength = imgLength;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPdateSrc() {
            return pdateSrc;
        }

        public void setPdateSrc(String pdateSrc) {
            this.pdateSrc = pdateSrc;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", imgWidth='" + imgWidth + '\'' +
                    ", fullTitle='" + fullTitle + '\'' +
                    ", pdate='" + pdate + '\'' +
                    ", src='" + src + '\'' +
                    ", imgLength='" + imgLength + '\'' +
                    ", img='" + img + '\'' +
                    ", url='" + url + '\'' +
                    ", pdateSrc='" + pdateSrc + '\'' +
                    '}';
        }
    }
}
