package model;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import Entity.User;

public class UserModelRest {

    private String BASE_URL="http://192.168.0.104:8080/bugHunterSpringRest/";
    private RestTemplate restTemplate=new RestTemplate();
    public User checkLogin(String username,String password)
    {
        try{
            return restTemplate.getForObject(BASE_URL+"user/check.do?username="+username+"&password="+password,User.class);
        }
        catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<User> getAll()
    {
        try{
            return  restTemplate.exchange(BASE_URL + "/resource/getAllRes.do", HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<User>>(){}).getBody();

        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
}
