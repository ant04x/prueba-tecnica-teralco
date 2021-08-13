package dev.ant04x.pruebatecnicateralco.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.sql.Timestamp;

@Document(collection = "api_calls")
public class AccessLog {

    @Id
    private String id;
    private String ipAddress;
    private Timestamp date;
    private Integer serviceNum;

    public AccessLog() {}

    public AccessLog(String ipAddress, Timestamp date, Integer serviceNum) {
        this.ipAddress = ipAddress;
        this.date = date;
        this.serviceNum = serviceNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(Integer serviceNum) {
        this.serviceNum = serviceNum;
    }
}
