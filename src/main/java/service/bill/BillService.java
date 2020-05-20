package main.java.service.bill;

import main.java.model.Bill;

import java.sql.SQLException;
import java.util.List;

public interface BillService {
    //    List<Bill> findAll();
//
//    void save(Bill bill);
//
//    Bill findById(int id);
//
//    void update(int id, Bill bill);
//
//    void remove(int id);
    public void insertBill(Bill bill) throws SQLException;

    public Bill selectBill(int id);

    public List<Bill> selectAllBills();

    public boolean deleteBill(int id) throws SQLException;

    public boolean updateBill(Bill bill) throws SQLException;
}
