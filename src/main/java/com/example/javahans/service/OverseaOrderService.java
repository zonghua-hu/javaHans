package com.example.javahans.service;

import com.example.javahans.dao.OverseaOrderMapper;
import com.example.javahans.model.WmsOverseasOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverseaOrderService {
    @Autowired
    private OverseaOrderMapper overseaOrderMapper;

    public WmsOverseasOrder queryById(Long id) {
        return this.overseaOrderMapper.selectByPrimaryKey(id);
    }
}
