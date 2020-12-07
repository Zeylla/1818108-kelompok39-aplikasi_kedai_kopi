package com.example.sqlite_kedai;

public class Kedai {
    private String _id, _nama, _harga;
    public Kedai (String id, String nama, String harga) {
        this._id = id;
        this._nama = nama;
        this._harga = harga;
    }
    public Kedai() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }

}
