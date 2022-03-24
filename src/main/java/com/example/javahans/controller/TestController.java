package com.example.javahans.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

@Controller
public class TestController
{
    final JdbcTemplate jdbcTemplate;

    /**
     * 构造函数
     * @param jdbcTemplate
     */
    public TestController(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map()
    {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from finance_config");
        return list.get(0);
    }
}
