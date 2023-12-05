// package ini berfungsi untuk mengatur button delete
package biodata;

// Modul 9 (Pertemuan 10) - Studi Kasus

// import untuk mengatur button delete
import dao.BiodataDao;
import main.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class ButtonDeleteActionListener ini berfungsi untuk mengatur button delete
public class ButtonDeleteActionListener implements ActionListener {
    // deklarasi variabel
    private MainFrame mainFrame;
    private BiodataDao biodataDao;
    private BiodataTableModel tableModel;

    // method ButtonDeleteActionListener ini berfungsi untuk mengatur button delete
    public ButtonDeleteActionListener(MainFrame mainFrame, BiodataDao bidoataDao) {
        this.mainFrame = mainFrame;
        this.biodataDao = new BiodataDao();
        this.tableModel = new BiodataTableModel(biodataDao.findAll());
    }

    // method actionPerformed ini berfungsi untuk mengatur aksi yang dilakukan ketika button delete diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = this.mainFrame.getTable();

        if(table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(mainFrame, "Tolong pilih baris yang ingin dihapus!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int row = table.getSelectedRow();

        int confirmStatus = JOptionPane.showConfirmDialog(mainFrame, "Apakah anda yakin ingin menghapus data ini?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if(confirmStatus != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(mainFrame, "Proses Dibatalkan!", "Cancel", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Data berhasil dihapus!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        String id = this.mainFrame.getTable().getValueAt(this.mainFrame.getTable().getSelectedRow(), 0).toString();

        this.mainFrame.deleteBiodata();
        this.biodataDao.delete(id);
        this.mainFrame.clearForm();
    }
}