package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 16-9-4.
 */

@RestController
@RequestMapping("/")
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(@RequestParam String code)
    {
        String ST=code;
        System.out.println(ST);
        String result = "";
        BufferedReader in = null;
        try {
            String clientId="42765ad72b9341c6bb13eedc008bb432";
            String redirect_uri="http://172.18.129.21:8080/login";
            String clientSecret="359e584f550647fe2b5e51d7d88801f3";
            String urlNameString ="https://cas.sustc.edu.cn/cas/oauth2.0/accessToken?response_type=c"+
            "ode&client_id="+clientId+"&redirect_uri="+redirect_uri+"&client_secret="+clientSecret+"&code="+ST;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = (HttpsURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
