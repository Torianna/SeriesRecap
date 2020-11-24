package com.seriesrecap.SeriesRecap.Entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ShareList {

   @Id
   String id;

   @OneToMany
   private List<Series> seriesList;

   public ShareList(String id, List<Series> seriesList){
      this.id = id;
      this.seriesList = seriesList;
   }

   public ShareList() {
      
   }
}
