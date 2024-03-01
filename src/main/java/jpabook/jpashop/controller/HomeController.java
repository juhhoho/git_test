package jpabook.jpashop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/hello")
    public String homeGET(Model model){
        model.addAttribute("msg","hello");
        return "hello";
    }
}
