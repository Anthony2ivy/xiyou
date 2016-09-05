package controller;

import common.Httpclient;
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
        String clientId="42765ad72b9341c6bb13eedc008bb432";
        String redirect_uri="http://172.18.129.21:8080/login";
        String clientSecret="359e584f550647fe2b5e51d7d88801f3";
        String urlNameString ="https://cas.sustc.edu.cn/cas/oauth2.0/accessToken?response_type=c"+
                "ode&client_id="+clientId+"&redirect_uri="+redirect_uri+"&client_secret="+clientSecret+"&code="+ST;

        String result= Httpclient.getRequest(urlNameString);
        if(result!=null)
        {
            return result;
        }else {
            return "";
        }
    }
}
