// package main ini berfungsi untuk mengatur main frame
package main;

// Modul 9 (Pertemuan 10) - Studi Kasus

// import untuk mengatur main frame
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import biodata.*;
import dao.BiodataDao;

// class MainFrame ini berfungsi untuk mengatur main frame
public class MainFrame extends JFrame {
    // deklarasi variabel
    private List<Biodata> biodataList;
    private JLabel namaLabel;
    private JTextField namaTextField;
    private JLabel alamatLabel;
    private JTextArea alamatTextArea;
    private JLabel noHpLabel;
    private JTextField noHpTextField;
    private JLabel jenisKelaminLabel;
    private JRadioButton lakiLakiRadioButton;
    private JRadioButton perempuanRadioButton;
    private ButtonGroup bg;
    private JButton simpanButton;
    private JButton ubahButton;
    private JButton hapusButton;
    private JButton updateButton;
    private JButton simpanTxt;
    private JTable table;
    private JScrollPane scrollableTable;
    private BiodataDao biodataDao;
    private BiodataTableModel tableModel;
    private String[] id;
    private String idActive = "";

    // method MainFrame ini berfungsi untuk mengatur main frame
    public MainFrame(BiodataDao biodataDao) {
        // method ini berfungsi untuk mengatur window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(
                        MainFrame.this,
                        "Apakah anda yakin ingin keluar?",
                        "Exit", JOptionPane.YES_NO_OPTION
                ) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        // deklarasi variabel
        this.biodataDao = biodataDao;
        this.biodataList = biodataDao.findAll();

        // JLabel ini berfungsi untuk mengatur label nama
        namaLabel = new JLabel("Nama:");
        namaLabel.setBounds(15, 40, 100, 10);

        // JTextField ini berfungsi untuk mengatur text field nama
        namaTextField = new JTextField();
        namaTextField.setBounds(15, 60, 350, 30);

        // JLabel ini berfungsi untuk mengatur label nomor hp
        noHpLabel = new JLabel("Nomor HP:");
        noHpLabel.setBounds(15, 100, 100, 10);

        // JTextField ini berfungsi untuk mengatur text field nomor hp
        noHpTextField = new JTextField();
        noHpTextField.setBounds(15, 120, 350, 30);

        // JLabel ini berfungsi untuk mengatur label jenis kelamin
        jenisKelaminLabel = new JLabel("Jenis Kelamin:");
        jenisKelaminLabel.setBounds(15, 160, 350, 10);

        // JRadioButton ini berfungsi untuk mengatur radio button jenis kelamin laki-laki
        lakiLakiRadioButton = new JRadioButton("Laki-laki");
        lakiLakiRadioButton.setBounds(15, 180, 350, 30);

        // JRadioButton ini berfungsi untuk mengatur radio button jenis kelamin perempuan
        perempuanRadioButton = new JRadioButton("Perempuan");
        perempuanRadioButton.setBounds(15, 210, 350, 30);

        // ButtonGroup ini berfungsi untuk mengatur button group jenis kelamin
        bg = new ButtonGroup();
        bg.add(lakiLakiRadioButton);
        bg.add(perempuanRadioButton);

        // JLabel ini berfungsi untuk mengatur label alamat
        alamatLabel = new JLabel("Alamat:");
        alamatLabel.setBounds(15, 240, 350, 20);

        // JTextArea ini berfungsi untuk mengatur text area alamat
        alamatTextArea = new JTextArea();
        alamatTextArea.setBounds(15, 270, 350, 90);

        // JButton ini berfungsi untuk mengatur button simpan
        simpanButton = new JButton("Simpan");
        simpanButton.setBounds(15, 380, 100, 40);

        // JButton ini berfungsi untuk mengatur button ubah
        ubahButton = new JButton("Ubah");
        ubahButton.setBounds(120, 380, 100, 40);

        // JButton ini berfungsi untuk mengatur button hapus
        hapusButton = new JButton("Hapus");
        hapusButton.setBounds(225, 380, 100, 40);

        // JButton ini berfungsi untuk mengatur button update
        updateButton = new JButton("Update");
        updateButton.setBounds(330, 380, 100, 40);

        // JButton ini berfungsi untuk mengatur button simpan ke txt
        simpanTxt = new JButton("Simpan ke TXT");
        simpanTxt.setBounds(435, 380, 130, 40);

        // JTable ini berfungsi untuk mengatur table
        table = new JTable();
        // JScrollPane ini berfungsi untuk mengatur scrollable table
        scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 430, 550, 150);

        // BiodataTableModel ini berfungsi untuk mengatur table model
        tableModel = new BiodataTableModel(this.biodataList);
        table.setModel(tableModel);

        // ActionListener ini berfungsi untuk mengatur action listener
        ButtonAddActionListener addActionListener = new ButtonAddActionListener(this, biodataDao);
        ButtonUbahActionListener ubahActionListener = new ButtonUbahActionListener(this);
        ButtonDeleteActionListener deleteActionListener = new ButtonDeleteActionListener(this, biodataDao);
        ButtonUpdateActionListener updateActionListener = new ButtonUpdateActionListener(this, biodataDao);
        ButtonSimpanTxtActionListener simpanTxtActionListener = new ButtonSimpanTxtActionListener(this, biodataDao);

        simpanButton.addActionListener(addActionListener);
        ubahButton.addActionListener(ubahActionListener);
        hapusButton.addActionListener(deleteActionListener);
        updateButton.addActionListener(updateActionListener);
        simpanTxt.addActionListener(simpanTxtActionListener);

        // mengatur semua komponen
        this.add(namaLabel);
        this.add(namaTextField);
        this.add(noHpLabel);
        this.add(noHpTextField);
        this.add(jenisKelaminLabel);
        this.add(lakiLakiRadioButton);
        this.add(perempuanRadioButton);
        this.add(alamatLabel);
        this.add(alamatTextArea);
        this.add(simpanButton);
        this.add(ubahButton);
        this.add(hapusButton);
        this.add(updateButton);
        this.add(simpanTxt);
        this.add(scrollableTable);

        // mengatur ukuran swing
        this.setSize(600, 650);
        this.setLayout(null);
        this.setVisible(true);
    }

    /*
        * 
        *  Kumpulan getter dan setter
        * 
     */
    
    public void setId(String idActive) {
        this.idActive = idActive;
    }

    public String getId() {
        return this.idActive;
    }

    public String getNama() {
        return this.namaTextField.getText();
    }

    public void setNama(String nama) {
        this.namaTextField.setText(nama);
    }

    public String getAlamat() {
        return this.alamatTextArea.getText();
    }

    public void setAlamat(String alamat) {
        this.alamatTextArea.setText(alamat);
    }

    public String getNoHp() {
        return this.noHpTextField.getText();
    }

    public void setNoHp(String noHp) {
        this.noHpTextField.setText(noHp);
    }

    public String getJenisKelamin() {
        if(this.lakiLakiRadioButton.isSelected()) {
            return "Laki-laki";
        }
        else if(this.perempuanRadioButton.isSelected()) {
            return "Perempuan";
        }
        else {
            return "";
        }
    }

    public void setJenisKelamin(String jenisKelamin) {
        if(jenisKelamin.equals("Laki-laki")) {
            this.lakiLakiRadioButton.setSelected(true);
        }
        else if(jenisKelamin.equals("Perempuan")) {
            this.perempuanRadioButton.setSelected(true);
        }
    }

    //  method getTable ini berfungsi untuk mengatur table
    public JTable getTable() {
        return this.table;
    }

    // method clearForm ini berfungsi untuk mengatur clear form
    public void clearForm() {
        this.idActive = "";
        this.namaTextField.setText("");
        this.alamatTextArea.setText("");
        this.noHpTextField.setText("");
        this.bg.clearSelection();
    }

    /*
        * 
        *  Kumpulan CRUD Biodata
        * 
     */
    public void addBiodata(Biodata biodata) {
        this.tableModel.add(biodata);
    }

    public void updateBiodata(int row, int col, Biodata biodata) {
        this.tableModel.update(row, col, biodata);
    }

    public void deleteBiodata() {
        this.tableModel.delete(this.table.getSelectedRow());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame f = new MainFrame(new BiodataDao());
                f.setVisible(true);
            }
        });
    }
}