package main.java.service.brand;

import main.java.model.Brand;

import java.util.List;

/**
 * @author Duc on 5/17/2020
 * @project casestudy-module3-duongshoe
 **/

public interface IServiceBrand {
    List<Brand> getBrandList();

    Brand getBrandById(int id);

    boolean addBrandToDB(Brand brand);

    boolean updateBrand(Brand brand);

    boolean isExist(int id);

}
