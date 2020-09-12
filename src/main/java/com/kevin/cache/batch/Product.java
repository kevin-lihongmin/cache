package com.kevin.cache.batch;

import lombok.Data;

import java.io.Serializable;

/**
 *  模拟对象有20个字段需要缓存
 * @author kevin
 * @date 2020/9/12 17:05
 * @since 1.0.0
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 5044381356108340682L;

    private Long id;

    private String name;

    private String productInfo1;
    private String productInfo2;
    private String productInfo3;
    private String productInfo4;
    private String productInfo5;
    private String productInfo6;
    private String productInfo7;
    private String productInfo8;
    private String productInfo9;
    private String productInfo10;
    private String productInfo11;
    private String productInfo12;
    private String productInfo13;
    private String productInfo14;
    private String productInfo15;
    private String productInfo16;
    private String productInfo17;
    private String productInfo18;

}
