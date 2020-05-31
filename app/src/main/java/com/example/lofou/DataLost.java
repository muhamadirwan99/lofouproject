package com.example.lofou;

public class DataLost {
    private String NamaBarang;
    private String WaktuKehilangan;
    private String Lokasi;
    private String Deskripsi;
    private String ImageID;

    public DataLost() {
    }

    public String getNamaBarang() {
        return NamaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        NamaBarang = namaBarang;
    }

    public String getWaktuKehilangan() {
        return WaktuKehilangan;
    }

    public void setWaktuKehilangan(String waktuKehilangan) {
        WaktuKehilangan = waktuKehilangan;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        Lokasi = lokasi;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }

    public String getImageID() {
        return ImageID;
    }

    public void setImageID(String imageID) {
        ImageID = imageID;
    }
}
