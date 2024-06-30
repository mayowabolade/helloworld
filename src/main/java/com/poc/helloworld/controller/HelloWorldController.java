package com.poc.helloworld.controller;



import com.poc.helloworld.service.HelloWorldService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;
    //    /helloworld/greet
    @GetMapping(path = "/greet")
    public ResponseEntity<String> greetAsJson() throws JSONException {
        JSONObject jsonObject = helloWorldService.fetchRightGreeting();
        return ResponseEntity.ok(jsonObject.toString());
    }
    //    /helloworld/sayhi
    @GetMapping(path = "/sayhi")
    public String greetAsString() {
        return helloWorldService.getTimeOfDay();
    }
}