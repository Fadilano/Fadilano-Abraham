package myspend;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class ControllerSpending {

    public void insertData(String tanggal, String deskripsi, int jumlah) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            ModelSpending spending = new ModelSpending(tanggal, deskripsi, jumlah);
            session.save(spending);
            transaction.commit();
            System.out.println("Data successfully saved!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Insert error: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public DefaultTableModel showData() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Tanggal");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Jumlah");

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM ModelSpending");
            List<ModelSpending> spendingList = query.list();

            for (ModelSpending spending : spendingList) {
                tableModel.addRow(new Object[]{spending.getTanggal(), spending.getDeskripsi(), spending.getJumlah()});
            }
        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return tableModel;
    }
}
