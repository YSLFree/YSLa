package ysl.com.packagea.otherbusiness;

/**
 * 该类是和平台交互的主类
 * Created by free on 2017/12/31.
 */

public class ContentBean {

    /**
     * data : {"appid":"20171212","appname":"安卓测试","is_jump":"2","jump_url":"https://apk.update-daquan369app.com/","status":"2"}
     * type : 200
     */

    private DataBean data;
    private String type;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class DataBean {
        /**
         * appid : 20171212
         * appname : 安卓测试
         * is_jump : 2
         * jump_url : https://apk.update-daquan369app.com/
         * status : 2
         */

        private String appid;
        private String appname;
        private String is_jump;
        private String jump_url;
        private String status;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getAppname() {
            return appname;
        }

        public void setAppname(String appname) {
            this.appname = appname;
        }

        public String getIs_jump() {
            return is_jump;
        }

        public void setIs_jump(String is_jump) {
            this.is_jump = is_jump;
        }

        public String getJump_url() {
            return jump_url;
        }

        public void setJump_url(String jump_url) {
            this.jump_url = jump_url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
