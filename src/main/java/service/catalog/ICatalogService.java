package main.java.service.catalog;

import main.java.model.Catalog;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Duc on 5/20/2020
 * @project casestudy-module3-duongshoe
 **/

public interface ICatalogService {
    List<Catalog> getCatalogList() throws SQLException;
}
