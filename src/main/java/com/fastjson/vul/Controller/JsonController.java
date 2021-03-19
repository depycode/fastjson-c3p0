package com.fastjson.vul.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getByJSON(@RequestBody String jsonParam) {

        JSONObject jsonObject = JSON.parseObject(jsonParam);
        JSONObject result = new JSONObject();
        result.put("data", jsonObject.toJSONString());
        return result.toJSONString();
    }
}
