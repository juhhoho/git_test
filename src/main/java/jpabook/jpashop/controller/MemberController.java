package jpabook.jpashop.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Form.MemberCreateForm;
import jpabook.jpashop.domain.Form.MemberLoginForm;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.zip.DataFormatException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // create member
    @GetMapping("/signup")
    public String signup(MemberCreateForm memberCreateForm){
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "member/signup";
        }
        if(!memberCreateForm.getMpw1().equals(memberCreateForm.getMpw2())){
            bindingResult.rejectValue("mpw2", "passwordInCorrect","2개의 패스워드 불일치함");
            return "member/signup";
        }
        try{
            memberService.create(memberCreateForm.getMid(), memberCreateForm.getMpw1(), memberCreateForm.getEmail());
        }catch(DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed","이미 등록된 사용자입니다");
            return "member/signup";
        }
        catch(Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "member/signup";
        }
        return "redirect:/hello";
    }

    // login의 과정은 security가 직접 처리하므로 별도의 post과정이 필요없다
    @GetMapping("/login")
    public String loginGET(MemberLoginForm memberLoginForm){
        return "member/login";
    }



}
