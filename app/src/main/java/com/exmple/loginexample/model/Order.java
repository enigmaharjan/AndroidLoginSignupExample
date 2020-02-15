package com.exmple.loginexample.model;

public class Order {
    String _id, userid, instrumentid, cart, sold;

    public Order(String _id, String userid, String instrumentid, String cart, String sold) {
        this._id = _id;
        this.userid = userid;
        this.instrumentid = instrumentid;
        this.cart = cart;
        this.sold = sold;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getInstrumentid() {
        return instrumentid;
    }

    public void setInstrumentid(String instrumentid) {
        this.instrumentid = instrumentid;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }
}
