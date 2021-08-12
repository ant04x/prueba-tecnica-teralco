package dev.ant04x.pruebatecnicateralco.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private double cost;
  @ManyToOne
  private Car priceCarIdFk;

  public Price() {}

  public Price(Timestamp startTime, Timestamp endTime, double cost, Car priceCarIdFk) {
    setStartTime(startTime);
    setEndTime(endTime);
    setCost(cost);
    setPriceCarIdFk(priceCarIdFk);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }


  public Car getPriceCarIdFk() {
    return priceCarIdFk;
  }

  public void setPriceCarIdFk(Car priceCarIdFk) {
    this.priceCarIdFk = priceCarIdFk;
  }
}
