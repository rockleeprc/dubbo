package org.example.web;


import com.example.domain.Person;
import com.example.service.IPersonServer;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/person")
public class PersonController {

    @Reference
    private IPersonServer personServer;

    @RequestMapping("/findAll")
    public List<Person> findAll(){
        return personServer.findAll();
    }

}
