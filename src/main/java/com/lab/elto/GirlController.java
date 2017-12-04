package com.lab.elto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by elotoma on 2017/7/3.
 */

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询所有女生
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 创建一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") int age) {
        Girl g = new Girl();
        g.setAge(age);
        g.setCupSize(cupSize);
        return girlRepository.save(g);
    }
    // 查询一个女生
    @GetMapping(value = "girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    // 更新女生信息
    @PutMapping(value = "girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl g = new Girl();
        g.setId(id);
        g.setCupSize(cupSize);
        g.setAge(age);

        return girlRepository.save(g);
    }

    // 删除一个女生
    @DeleteMapping(value = "girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    // 通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public  List<Girl> girlListByAge(@PathVariable("age") Integer age) {
         return  girlRepository.findByAge(age);
    }


}
