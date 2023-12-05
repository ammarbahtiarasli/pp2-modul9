// package biodata ini berfungsi untuk mengatur button add
package biodata;

// Modul 9 (Pertemuan 10) - Studi Kasus

// import untuk mengatur button add
import dao.BiodataDao;
import main.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

// class ButtonAddActionListener ini berfungsi untuk mengatur button add
public class ButtonAddActionListener implements ActionListener {
    // deklarasi variabel
    private MainFrame mainFrame;
    private BiodataDao biodataDao;

    // method ButtonAddActionListener ini berfungsi untuk mengatur button add
    public ButtonAddActionListener(MainFrame mainFrame, BiodataDao bidoataDao) {
        this.mainFrame = mainFrame;
        this.biodataDao = new BiodataDao();
    }

    // method actionPerformed ini berfungsi untuk mengatur aksi yang dilakukan ketika button add diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!mainFrame.getId().equals("")) {
            int confirmStatus = JOptionPane.showConfirmDialog(mainFrame, "Form sedang digunakan, apakah anda ingin menambah data baru?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmStatus != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(mainFrame, "Proses Dibatalkan!", "Cancel", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            this.mainFrame.clearForm();
            return;
        }

        JTable table = this.mainFrame.getTable();

        if(mainFrame.getNama().equals("")) {
            JOptionPane.showMessageDialog(mainFrame, "Tolong isi nama!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(mainFrame.getNoHp().equals("")) {
            JOptionPane.showMessageDialog(mainFrame, "Tolong isi nomor hp!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        else if(mainFrame.getNoHp().toString().length() > 12) {
            JOptionPane.showMessageDialog(mainFrame, "Nomor hp harus dibawah 12 digit!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String jk = "";
        if(mainFrame.getJenisKelamin() == null ) {
            JOptionPane.showMessageDialog(mainFrame, "Tolong pilih jenis kelamin!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(mainFrame.getAlamat().equals("")) {
            JOptionPane.showMessageDialog(mainFrame, "Tolong isi alamat!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmStatus = JOptionPane.showConfirmDialog(mainFrame, "Apakah anda yakin ingin menyimpan data ini?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if(confirmStatus != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(mainFrame, "Proses Dibatalkan!", "Cancel", JOptionPane.INFORMATION_MESSAGE);
            return;
        } 
        else {
            JOptionPane.showMessageDialog(mainFrame, "Data berhasil ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        String nama = this.mainFrame.getNama();
        String noHp = this.mainFrame.getNoHp();
        String jenisKelamin = this.mainFrame.getJenisKelamin();
        String alamat = this.mainFrame.getAlamat();
        Biodata biodata = new Biodata();
        biodata.setId(UUID.randomUUID().toString());
        biodata.setNama(nama);
        biodata.setNoHp(noHp);
        biodata.setJenisKelamin(jenisKelamin);
        biodata.setAlamat(alamat);

        this.mainFrame.addBiodata(biodata);
        this.biodataDao.insert(biodata);
        this.mainFrame.clearForm();
    }
}