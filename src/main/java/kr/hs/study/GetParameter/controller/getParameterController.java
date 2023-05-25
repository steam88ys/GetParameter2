package kr.hs.study.GetParameter.controller;

import kr.hs.study.GetParameter.dto.login;
import kr.hs.study.GetParameter.dto.test7;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class getParameterController {
    @GetMapping("/test1")
    public String test1(HttpServletRequest req) {
        String a = req.getParameter("data1");
        String b = req.getParameter("data2");
        String c = req.getParameter("data3");

        System.out.println("data1: " + a);
        System.out.println("data2: " + b);
        System.out.println("data3: " + c);

        return "result";
    }

    @GetMapping("/test2")
    public String test2(HttpServletRequest req) {
        String c[] = req.getParameterValues("data3");

        for(String str:c) {
            System.out.println("data3: "+str);
        }

        return "result";
    }

    @GetMapping("/test3")
    public String test3(WebRequest req) {
        String c[] = req.getParameterValues("data3");

        for(String str:c) {
            System.out.println("data3: "+str);
        }

        return "result";
    }

    @PostMapping("/test4")
    public String test4(HttpServletRequest req) {
        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");
        String data3[] = req.getParameterValues("data3");

        System.out.println("data1: " + data1);
        System.out.println("data2: " + data2);
        for(String str:data3) {
            System.out.println("data3: "+str);
        }

        return "result";
    }

    @GetMapping("/test5")
    public String test5(@RequestParam("data1") int data1,
                        @RequestParam("data2") int data2,
                        @RequestParam("data3") int data3[]) {
        System.out.println("data1: " + data1);
        System.out.println("data2: " + data2);
        for(int str:data3) {
            System.out.println("data3: "+str);
        }
        return "result";
    }

    @GetMapping("/test6/{a}/{b}/{c}")
    public String test6(@PathVariable String a,
                        @PathVariable String b,
                        @PathVariable String c) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        return "result";
    }

    @GetMapping("/test7")
    public String test7(@ModelAttribute test7 t) {
        // @ModelAttribute test7 t: test7객체 t를 만들어서 데이터를 주입시킨다. (자동DI: @Autowired)
        System.out.println(t.getData1());
        System.out.println(t.getData2());
        System.out.println(t.getData3());
        return "result";
    }

    @GetMapping("/test8")
    public String test8() {
        return "login_form";
    }
    @PostMapping("/test8")
    public String login_form(@ModelAttribute login login1) {
        System.out.println("id: " + login1.getUser_id());
        System.out.println("pass: " + login1.getUser_pass());
        return "result";
    }

}
