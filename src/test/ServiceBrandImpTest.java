package test;

import main.java.service.brand.ServiceBrandImp;
import main.java.service.brand.IServiceBrand;
import org.junit.jupiter.api.Test;

/**
 * @author Duc on 5/18/2020
 * @project casestudy-module3-duongshoe
 **/

class ServiceBrandImpTest {

    @Test
    void getImportList() {
        IServiceBrand dao = new ServiceBrandImp();
    }
}