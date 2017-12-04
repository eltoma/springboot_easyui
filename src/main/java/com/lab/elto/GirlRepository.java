package com.lab.elto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by elotoma on 2017/7/3.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    // 扩展 按照指定字段 查询
    List<Girl> findByAge(Integer id);
}
