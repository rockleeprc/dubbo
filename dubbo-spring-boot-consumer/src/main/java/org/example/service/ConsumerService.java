package org.example.service;

import com.example.domain.Person;
import com.example.service.IPersonServer;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {

    /**
     * check = false 只有全局、类级别，没有方法级别
     * retries = 2 默认2，不包含第一次请求失败，重试2次，总共3次请求
     */
    @Reference(version = "1.0.0")
    private IPersonServer personServer;


    public List<Person> findAll() {
        return personServer.findAll();

    }
}
