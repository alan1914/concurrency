package com.mmall.concurrency.example.threadlocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author stone
 * @des TODO
 * @date 2019/2/25/025 16:39
 **/
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test() {
        return RequestHolder.getId();
    }

}
