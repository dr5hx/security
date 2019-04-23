package com.dr5hx.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
//import java.util.logging.Logger;

@RestController
@RequestMapping("/order")

public class OrderController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping
    public Callable<String> simpleAsync() {
        log.info("主线程开始");

        Callable<String> callable = () -> {
            log.info("进入副线程");
            Thread.sleep(1000);
            log.info("进入副线程结束");
            return "result";
        };

        Thread thread = new Thread(() ->
                log.info("aaa")
        );
        thread.start();
        log.info("主线程结束:" + callable);
        return callable;
    }

    @RequestMapping("/async")
    public DeferredResult<String> order() throws Exception {
        log.info("主线程开始");
        log.info("deferredResultHolder_2：" + deferredResultHolder);
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
        return result;
    }
}