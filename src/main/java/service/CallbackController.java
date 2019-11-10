package service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallbackController {

    private String authCode;
    private boolean ready = false;

    @RequestMapping("/callback")
    public void callback(@RequestParam(value = "code") String code) {
        System.out.println("Response received: " + code);
        ready = true;
        authCode = code;
    }

    @RequestMapping("/getAuthCode")
    public String getCode() {
        ready = false;
        return authCode;
    }

    @RequestMapping("/checkStatus")
    public boolean getStatus() {
        return ready;
    }

}
