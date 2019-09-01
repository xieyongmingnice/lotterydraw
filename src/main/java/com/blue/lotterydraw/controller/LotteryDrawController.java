package com.blue.lotterydraw.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description 抽奖
 * @author orcas
 * @since 2019/9/1
 **/
@RestController
@RequestMapping("/draw")
public class LotteryDrawController {

    @RequestMapping(value = "/single",method = RequestMethod.POST)
    public ReturnVO singleDraw(@RequestParam(value = "usernameList")  List<String> usernames){
        ReturnVO vo = new ReturnVO();
        vo.setCode("200");
        usernames = handleParam(usernames);

        String luckyDog = drawRandom(usernames);
        vo.setMessage("获奖的幸运孤儿是"+luckyDog+"！！！");
        System.out.println(luckyDog);
        return vo;
    }

    private List<String>  handleParam(List<String> usernames){
        List<String> list=new ArrayList();
        for (String username : usernames){
            if (StringUtils.isNotEmpty(username) ){
                if (username.contains("\"")){
                   username = username.replaceAll("\"","");
                }
                if (username.contains("[")){
                    username = username.replaceAll("\\[","");
                }
                if (username.contains("]")){
                    username = username.replaceAll("]","");
                }
                list.add(username);
            }
        }
        return list;
    }

    private String drawRandom(List<String> user){
        int len = user.size();
        Random random = new Random();
        int ranInt = random.nextInt(9999999);
        int result =  ranInt % len ;
        return user.get(result);
    }

    class ReturnVO{
        private String code ;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
