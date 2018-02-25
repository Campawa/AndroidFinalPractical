package com.example.chelsi.androidfinalpractical;

import java.util.List;

/**
 * Created by Chelsi on 2/25/2018.
 */

public class DogModel {

    String status;
    List<String> message;

    public DogModel(String status, List <String> message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public List <String> getMessage() {
        return message;
    }
}
