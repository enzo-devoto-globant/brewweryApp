package com.enzoApps.beer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.spi.LocaleNameProvider;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "brewerys", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}
)
public class Brewery {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "brewery_type")
    private String brewery_type;
    @Column(name = "street")
    private String street;
    @Column(name = "address_2")
    private String address_2;
    @Column(name = "address_3")
    private String address_3;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "county_province")
    private String county_province;
    @Column(name = "postal_code")
    private String postal_code;
    @Column(name = "country")
    private String country;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "phone")
    private String phone;
    @Column(name = "website_url")
    private String website_url;
    @Column(name = "updated_at")
    private String updated_at;
    @Column(name = "created_at")
    private String created_at;

}
