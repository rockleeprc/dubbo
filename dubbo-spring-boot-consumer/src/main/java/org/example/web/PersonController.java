package org.example.web;


import com.example.domain.Person;
import com.example.service.IPersonServer;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/person")
public class PersonController {

    /**
     * check = false 只有全局、类级别，没有方法级别
     * retries = 2 默认2，不包含第一次请求失败，重试2次，总共3次请求
     */
    @Reference
    private IPersonServer personServer;

    @RequestMapping("/findAll")
    public List<Person> findAll() {
        return personServer.findAll();
    }

}
