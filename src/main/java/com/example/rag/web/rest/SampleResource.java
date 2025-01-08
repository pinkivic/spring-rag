
package com.example.rag.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleResource {

    @GetMapping("/samples/{value}")
    public String hello(@PathVariable(value = "value", required = false) final String value) {
        return "Hello " + value + "!";
    }

}