// package biodata ini berfungsi untuk mengatur tabel biodata
package biodata;

// Modul 9 (Pertemuan 10) - Studi Kasus

// import library untuk mengatur tabel biodata
import javax.swing.table.AbstractTableModel;
import java.io.FileWriter;
import java.util.List;

// class BiodataTableModel ini berfungsi untuk mengatur tabel biodata
public class BiodataTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Nama", "Alamat", "Nomor HP", "Jenis Kelamin"};
    private List<Biodata> data;

    // method BiodataTableModel ini berfungsi untuk mengatur tabel biodata
    public BiodataTableModel(List<Biodata> data) {
        this.data = data;
    }

    // method getColumnCount ini berfungsi untuk mengatur jumlah kolom
    public int getColumnCount() {
        return columnNames.length;
    }

    // method getRowCount ini berfungsi untuk mengatur jumlah baris
    public int getRowCount() {
        return data.size();
    }

    // method getColumnName ini berfungsi untuk mengatur nama kolom
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // method getValueAt ini berfungsi untuk mengatur isi tabel
    public Object getValueAt(int row, int col) {
        Biodata rowItem = data.get(row);
        String value = "";

        switch(col) {
            case 0:
                value = rowItem.getId();
                break;
            case 1:
                value = rowItem.getNama();
                break;
            case 2:
                value = rowItem.getAlamat();
                break;
            case 3:
                value = rowItem.getNoHp();
                break;
            case 4:
                value = rowItem.getJenisKelamin();
                break;
        }
        return value;
    }

    // method isCellEditable ini berfungsi untuk mengatur apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // method add ini berfungsi untuk menambahkan data ke tabel
    public void add(Biodata value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    // method update ini berfungsi untuk mengubah data di tabel
    public void update(int row, int col, Biodata value) {
        Biodata rowItem = data.get(row);

        switch (col) {
            case 0:
                rowItem.setId(value.getId());
                break;
            case 1:
                rowItem.setNama(value.getNama());
                break;
            case 2:
                rowItem.setAlamat(value.getAlamat());
                break;
            case 3:
                rowItem.setNoHp(value.getNoHp());
                break;
            case 4:
                rowItem.setJenisKelamin(value.getJenisKelamin());
                break;
        }

        data.set(row, rowItem);
        fireTableRowsUpdated(row, col);
    }

    // method delete ini berfungsi untuk menghapus data di tabel
    public void delete(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }

    // method saveToTxt ini berfungsi untuk menyimpan data ke file txt
    public void saveToTxt() throws Exception {
        FileWriter saveText = new FileWriter("data.txt");
        int rowLength = getRowCount();
        int colLength = getColumnCount();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if(j != 0) saveText.write(" - ");
                saveText.write(getValueAt(i, j).toString());
            }
            saveText.write("\n");
        }

        saveText.close();
    }
}