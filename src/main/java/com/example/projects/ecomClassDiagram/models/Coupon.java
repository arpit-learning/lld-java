package com.example.projects.ecomClassDiagram.models;

public class Coupon {
  private String code;
  private CouponStatus status;

  public Coupon () {
  }

  public String getCode () {
    return code;
  }

  public Coupon setCode (String code) {
    this.code = code;
    return this;
  }

  public CouponStatus getStatus () {
    return status;
  }

  public Coupon setStatus (CouponStatus status) {
    this.status = status;
    return this;
  }
}
