package main.java.service.record.stock;

import main.java.model.ImportRecord;

import java.util.List;

/**
 * @author Duc on 5/19/2020
 * @project casestudy-module3-duongshoe
 **/

public interface IImportService {
    List<ImportRecord> getImportRecords(int id);
}
