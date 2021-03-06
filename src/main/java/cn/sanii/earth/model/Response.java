package cn.sanii.earth.model;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @Author: shouliang.wang
 * @Date: 2019/2/13 17:01
 * @Description: 抓取响应
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private Request request;

    private ResultField resultField = new ResultField();

    private boolean success;

    private String name;

    private String html;

    private byte[] bytes;

    public void setResult(String html) {
        this.html = html;
    }

    public Document getDocument() {
        return Jsoup.parse(html);
    }
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
