package main.java.model.dao;

import main.java.model.product.Import;

import java.util.List;

/**
 * @author Duc on 5/17/2020
 * @project casestudy-module3-duongshoe
 **/

public interface IDAOProduct {
    List<Import> getImportList();
}
