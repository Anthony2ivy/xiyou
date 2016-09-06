package controller;

import authentication.AccountAuthentic;
import bean.CASToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import common.Httpclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 16-9-4.
 */

@Controller
@RequestMapping("/")
public class LoginController {
    String clientId="42765ad72b9341c6bb13eedc008bb432";
    String redirect_uri="http://172.18.129.21:8080/login";
    String clientSecret="359e584f550647fe2b5e51d7d88801f3";
    @Autowired
    private AccountAuthentic accountAuthentic;
    @RequestMapping(value="/")
    public String index(HttpServletRequest request)
    {
        String token="";
        Cookie[] cookies=request.getCookies();
        if(cookies==null||cookies.length==0){
            return "redirect:https://cas.sustc.edu.cn/cas/oauth2.0/authorize?client_id="+clientId+"&redirect_uri="+redirect_uri;
        }
        for (int i = 0; i < cookies.length; i++) {
            String name= cookies[i].getName();
            if(name.equals("accountToken"))
            {
                token=cookies[i].getValue();
            }
        }
        if(token.equals("")||token==null)
        {
            return "redirect:https://cas.sustc.edu.cn/cas/oauth2.0/authorize?client_id="+clientId+"&redirect_uri="+redirect_uri;
        }
        else{
            String stuid=accountAuthentic.checkToken(token);
            return "index";
        }
    }
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestParam String code, HttpServletResponse response)
    {
        String ST=code;
        String urlNameString ="https://cas.sustc.edu.cn/cas/oauth2.0/accessToken?response_type=c"+
                "ode&client_id="+clientId+"&redirect_uri="+redirect_uri+"&client_secret="+clientSecret+"&code="+ST;
        String result1= Httpclient.getRequest(urlNameString);
        if(result1!=null)
        {
            ObjectMapper mapper=new ObjectMapper();
            try {
                CASToken casToken=mapper.readValue(result1,CASToken.class);
                 String url="https://cas.sustc.edu.cn/cas/oauth2.0/profile?access_token="+casToken.getAccess_token();
                String result2= Httpclient.getRequest(url);
                Map<String,Object> stuInfo =mapper.readValue(result2,Map.class);
//                Map<String,String> attributes=mapper.readValue((String)stuInfo.get("attributes"),Map.class);
                Map<String,String> attributes=(Map<String,String>)stuInfo.get("attributes");
                String sid=attributes.get("sid");
                accountAuthentic.addToken(casToken.getAccess_token(),sid);
                response.addCookie(new Cookie("accountToken",casToken.getAccess_token()));
                return attributes.get("sid");
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }else {
            return "error null";
        }
    }

}
