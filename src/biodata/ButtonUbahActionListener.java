// package ini berfungsi untuk mengatur button ubah
package biodata;

// Modul 9 (Pertemuan 10) - Studi Kasus

// import untuk mengatur button ubah
import dao.BiodataDao;
import main.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// class ButtonUbahActionListener ini berfungsi untuk mengatur button ubah
public class ButtonUbahActionListener implements ActionListener {
    // deklarasi variabel
    private MainFrame mainFrame;

    // method ButtonUbahActionListener ini berfungsi untuk mengatur button ubah
    public ButtonUbahActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    // method actionPerformed ini berfungsi untuk mengatur aksi yang dilakukan ketika button ubah diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = this.mainFrame.getTable();

        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(mainFrame, "Tolong pilih baris yang ingin diubah!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!this.mainFrame.getNama().equals("") || !this.mainFrame.getAlamat().equals("") || !this.mainFrame.getNoHp().equals("") || !this.mainFrame.getJenisKelamin().equals("")) {
            int confirmStatus = JOptionPane.showConfirmDialog(mainFrame, "Form sedang digunakan, apakah anda yakin ingin menimpanya?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmStatus != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(mainFrame, "Proses Dibatalkan!", "Cancel", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            this.mainFrame.clearForm();
        }

        int row = table.getSelectedRow();

        this.mainFrame.setId(table.getValueAt(row, 0).toString());
        this.mainFrame.setNama(table.getValueAt(row, 1).toString());
        this.mainFrame.setAlamat(table.getValueAt(row, 2).toString());
        this.mainFrame.setNoHp(table.getValueAt(row, 3).toString());
        this.mainFrame.setJenisKelamin(table.getValueAt(row, 4).toString());
    }
}