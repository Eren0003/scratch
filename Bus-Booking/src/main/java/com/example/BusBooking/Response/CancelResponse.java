package com.example.BusBooking.Response;

import org.springframework.stereotype.Component;

@Component
public class CancelResponse {
   private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
