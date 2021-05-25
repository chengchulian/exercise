
package y2021.m05.d12;

import java.util.List;


public class Product {

//----------------标识-----------------
    /**
     * 商城编码。指定返回商品的商城。
     */
    private String marketplaceId;
    /**
     * 商品的亚马逊标准识别码（ASIN）
     */
    private String asin;



//----------------属性----------------

    /**
     * 各组属性使用的语言都由 lang 属性表示
     */
    private String lang;

    /**
     * 包装方式 ?
     */
    private String binding;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 分类
     */
    private String department;
    /**
     * 特征
     */
    private List<String> feature;


    /**
     * 物品尺寸
     */
    private ItemDimensions ItemDimensions;

    /**
     * 标签
     */
    private String label;
    /**
     * 标牌价: 制造商建议的产品标价。
     */
    private ListPrice listPrice;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 型号
     */
    private String model;

    private PackageDimensions PackageDimensions;



    private String packageQuantity;
    private String partNumber;
    /**
     * 产品分组
     */
    private String productGroup;
    /**
     * 产品类型
     */
    private String productTypeName;
    /**
     * 发行商
     */
    private String publisher;
    private     SmallImage SmallImage;
    private String studio;
    /**
     * 标题
     */
    private String title;


    /**
     * 商品关系
     */
    private Relationships Relationships;
    /**
     * 商品销量
     */
    private SalesRankings SalesRankings;

}