package app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping("/hello/retry")
    public ResponseEntity<?> helloRetry(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "retry") int retry) {
        if (retry < 2) {
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Hello" + name, HttpStatus.OK);
    }
}
