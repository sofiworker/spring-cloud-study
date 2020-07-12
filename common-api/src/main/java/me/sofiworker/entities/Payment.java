package me.sofiworker.entities;

import java.io.Serializable;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/3 18:00
 */
public class Payment implements Serializable {
    private Long id;
    private String serial;

    public Payment() {}

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
