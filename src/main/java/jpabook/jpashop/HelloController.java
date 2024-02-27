package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/1")
    public String hello(Model model){
        model.addAttribute("message", "qwew msg");
        return "hello";
    }

    @GetMapping("/2")
    public String hello2(Model model){
        model.addAttribute("message", "qwew msg");
        return "hello";
    }


}
