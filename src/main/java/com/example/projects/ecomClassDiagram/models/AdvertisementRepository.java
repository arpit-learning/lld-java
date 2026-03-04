package com.example.projects.ecomClassDiagram.models;

import java.util.List;

public class AdvertisementRepository {
  private Category category;
  private List<Advertisement> advertisements;

  public AdvertisementRepository () {
  }

  public Category getCategory () {
    return category;
  }

  public AdvertisementRepository setCategory (Category category) {
    this.category = category;
    return this;
  }

  public List<Advertisement> getAdvertisements () {
    return advertisements;
  }

  public AdvertisementRepository setAdvertisements (List<Advertisement> advertisements) {
    this.advertisements = advertisements;
    return this;
  }
}
