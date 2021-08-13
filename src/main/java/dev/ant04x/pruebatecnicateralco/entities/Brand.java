package dev.ant04x.pruebatecnicateralco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL)
  private List<Price> cars;

  public Brand() {}

  public Brand(String name) {
    this.setName(name);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Price> getCars() {
    return cars;
  }

  public void setCars(List<Price> cars) {
    this.cars = cars;
  }
}
