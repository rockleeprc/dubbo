package org.example.service;

import com.example.domain.Person;
import com.example.service.IPersonServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ConsumerService {

    /**
     * check = false 只有全局、类级别，没有方法级别
     * retries = 2 默认2，不包含第一次请求失败，重试2次，总共3次请求
     */
    @Reference(version = "1.0.0", check = true)
    private IPersonServer personServer;

    @HystrixCommand(fallbackMethod = "reliable")
    public List<Person> findAll() {
        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            int result = 1 / 0;
        }
        return personServer.findAll();
    }


    public List<Person> reliable() {
        return Arrays.asList(new Person("hystrix"));
    }
}
