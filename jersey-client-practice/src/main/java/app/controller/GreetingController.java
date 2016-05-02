package app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello" + name;
    }

    @RequestMapping("/hello/timeout")
    public String helloTimeout(@RequestParam(value = "name", defaultValue = "World") String name) throws InterruptedException {
        Thread.sleep(10_000L);
        return "Hello" + name;
    }
}
