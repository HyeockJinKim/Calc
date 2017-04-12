package univ.lecture.riotapi.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import univ.lecture.riotapi.model.CalcApp;
import univ.lecture.riotapi.model.Result;
import univ.lecture.riotapi.model.Operator;

import java.io.UnsupportedEncodingException;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@Log4j
public class RiotApiController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/calc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Result Calculator(@RequestParam(value="token[]",required=false,defaultValue="0") String token[]) throws UnsupportedEncodingException {
        
    	final String endpoint = "http://52.79.162.52:8080/api/v1/answer";
    	
    	 CalcApp cal = new CalcApp();
         double rst = cal.calc(token);
        String response = restTemplate.postForObject(endpoint, rst, String.class);
        
        
       
        Result result = new Result(6, System.currentTimeMillis(), rst);

        return result;
    }
}
