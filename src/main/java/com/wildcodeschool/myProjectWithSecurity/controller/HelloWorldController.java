package com.wildcodeschool.myProjectWithSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Welcome to the SHIELD";
    }

    @GetMapping("/avengers/assemble")
    @ResponseBody
    public String hello_champion() {
        return "Avengers... Assemble";
    }

    @GetMapping("/secret-bases")
    @ResponseBody
    public String hello_director() {

        String[] bases = {
                "Amsterdam",
                "Barcelone",
                "Berlin",
                "Biarritz",
                "Bordeaux",
                "Bruxelles",
                "Bucarest",
                "La loupe",
                "Lille",
                "Lisbonne",
                "Londres"

        };

        String html = "<html>\n" +
                "<header><title>Les bases du shield</title></header>\n" +
                "<body>\n" +
                "<ul>\n" ;

        for (int i = 0; i < bases.length; i++) {
            html += "<li>" + bases[i] + "</li>\n";
        }

        html += "</ul>\n" +
                "</body>\n" +
                "</html>";

        return html;
    }

}
