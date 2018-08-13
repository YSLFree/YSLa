package ysl.com.packagea.otherbusiness;

/**
 * 该类是app进入后页面显示的控制实体类，
 * Created by free on 2017/12/31.
 */

public class ControlBean {

    /**
     * appid : null  接入者ID (appid)
     * appname : null
     * isshowwap : null1.  是否跳转到wap页面，1：是 加载wapurl 2： 否  不加载wapurl,  0：否 不加载 wapurl     wap页面URL，
     * wapurl : null
     * status : 0    2. status 是否成功获取数据状态，1：成功，2：失败
     * desc : 此信息不存在。
     */

    private Object appid;
    private Object appname;
    private Object isshowwap;
    private Object wapurl;
    private int status;
    private String desc;

    public Object getAppid() {
        return appid;
    }

    public void setAppid(Object appid) {
        this.appid = appid;
    }

    public Object getAppname() {
        return appname;
    }

    public void setAppname(Object appname) {
        this.appname = appname;
    }

    public Object getIsshowwap() {
        return isshowwap;
    }

    public void setIsshowwap(Object isshowwap) {
        this.isshowwap = isshowwap;
    }

    public Object getWapurl() {
        return wapurl;
    }

    public void setWapurl(Object wapurl) {
        this.wapurl = wapurl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
