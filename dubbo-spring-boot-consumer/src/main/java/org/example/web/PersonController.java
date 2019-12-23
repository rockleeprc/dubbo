package org.example.web;


import com.example.domain.Person;
import com.example.service.IPersonServer;
import org.apache.dubbo.config.annotation.Reference;
import org.example.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/findAll")
    public List<Person> findAll() {
        return consumerService.findAll();
    }

}
