package com.example.demo2;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin {
    @SerializedName("_id")
    private String _id;

    @SerializedName("username")
    private String username;

    @SerializedName("role")
    private String role;

    @SerializedName("jwt")
    private String jwt;

    public ResponseLogin(String _id, String username, String role, String jwt) {
        this._id = _id;
        this.username = username;
        this.role = role;
        this.jwt = jwt;
    }

    public ResponseLogin() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
