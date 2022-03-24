package com.example.javahans.model;

import lombok.Data;

import javax.persistence.Id;

@Data
public class WmsOverseasOrder {
    @Id
    private Long woo_id;
    private int zid;
    private String overseas_order_no;
    private String remark;
}
