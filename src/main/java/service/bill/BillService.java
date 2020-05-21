package main.java.service.bill;

import main.java.model.Bill;

import java.sql.SQLException;
import java.util.List;

public interface BillService {
    Bill selectBill(int id);

    List<Bill> selectAllBills();

    boolean updateBill(Bill bill) throws SQLException;
}
