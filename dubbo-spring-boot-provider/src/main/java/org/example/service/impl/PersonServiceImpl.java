package org.example.service.impl;

import com.example.domain.Person;
import com.example.service.IPersonServer;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonServer {

    public List<Person> findAll() {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("marry", 10));
        list.add(new Person("tom", 11));
        list.add(new Person("jack", 12));
        System.out.println(System.currentTimeMillis());
        return list;
    }
}
