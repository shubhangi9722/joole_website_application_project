
package com.itlizesession.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "certification")
    private String certification;

    @OneToOne(cascade={CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @OneToOne(cascade={CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "technical_detail_id")
    private TechnicalDetail technicalDetail;

    @OneToOne(cascade={CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "description_id")
    private Description description;

    @OneToMany(mappedBy = "product", orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.EAGER )
    //@JsonManagedReference
    //@JsonIgnore
    private List<ProjectProduct> productList;


    public Product() {

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<ProjectProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<ProjectProduct> productList) {
        this.productList = productList;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public TechnicalDetail getTechnicalDetail() {
        return technicalDetail;
    }

    public void setTechnicalDetail(TechnicalDetail technicalDetail) {
        this.technicalDetail = technicalDetail;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productBrand='" + productBrand + '\'' +
                ", certification='" + certification + '\'' +
                ", productType=" + productType +
                ", technicalDetail=" + technicalDetail +
                ", description=" + description +
                '}';
    }
}


