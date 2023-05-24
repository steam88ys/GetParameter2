package kr.hs.study.GetParameter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

}
