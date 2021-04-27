package forest.ori.parrot.controller;

import forest.ori.parrot.common.annotation.AnonymousAccess;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v")
public class helloController {

    @AnonymousAccess
    @GetMapping("Hello")
    public String getHello(){
        return  "hellp";
    }
}
