package authentication;

import org.springframework.context.annotation.Bean;

import java.util.*;

/**
 * Created by zwx729915632 on 2016/9/5.
 */
public class AccountAuthentic {
    private HashMap<String,AccountToken> tokenList;
    private int timeoutDay;
    public AccountAuthentic(int timeoutDay)
    {
        this.tokenList=new HashMap<String,AccountToken>();
        this.timeoutDay=timeoutDay;
    }
    public void addToken(String token,String id)
    {
        AccountToken accountToken=new AccountToken(id,token);
        tokenList.put(token,accountToken);
    }
    public String checkToken(String token)
    {
        AccountToken accountToken=tokenList.get(token);
        if (accountToken==null)
        {
            return null;
        }else
        {
            if(((new Date().getTime()-accountToken.getCreateTime().getTime())/24/3600/1000)>7)
            {
                tokenList.remove(token);
                return null;
            }else {
                accountToken.setCreateTime(new Date());
                return accountToken.getStuId();
            }
        }
    }
}
