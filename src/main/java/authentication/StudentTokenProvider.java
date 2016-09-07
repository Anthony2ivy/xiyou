package authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Httpclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzw on 16-9-6.
 */
public class StudentTokenProvider {
    private String currentToken;
    private String URL="http://zssys.sustc.edu.cn/studentApi/oauth/token";
    private String client_id="ClientStudent";
    private String client_secret ="5fcb6bbcd1b284fc1926";
    private String grant_type ="client_credentials";
    public StudentTokenProvider()
    {
        refreshToken();
    }
    public boolean refreshToken()
    {
        Map<String,String> params=new HashMap<String,String>();
        params.put("grant_type", grant_type);
        params.put("client_id",client_id);
        params.put("client_secret", client_secret);
        String result= Httpclient.postRequest(URL,params);
        if(result==null){
            return false;
        }
        ObjectMapper mapper=new ObjectMapper();
        Map<String,String> parseResult =null;
        try {
            parseResult=mapper.readValue(result,Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if(result==null ||parseResult==null)
        {
            return false;
        }
        else{
            String token=parseResult.get("access_token");
            if(token==null||token.equals(""))
            {
                System.out.println(parseResult.get("error"));
                return false;
            }
            else
            {
                currentToken=token;
                return true;
            }
        }
    }

    public String getCurrentToken() {
        return currentToken;
    }


}
