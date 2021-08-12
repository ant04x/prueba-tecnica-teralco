package dev.ant04x.pruebatecnicateralco.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;

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

}
