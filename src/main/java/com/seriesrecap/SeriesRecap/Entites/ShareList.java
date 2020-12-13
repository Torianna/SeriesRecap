package com.seriesrecap.SeriesRecap.Entites;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import java.util.List;


@Entity
public class ShareList {

   @Id
   String id;

   @ManyToMany
   private List<Series> seriesList;

   public ShareList(String id, List<Series> seriesList){
      this.id = id;
      this.seriesList = seriesList;
   }

   public ShareList() {
      
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public List<Series> getSeriesList() {
      return seriesList;
   }

   public void setSeriesList(List<Series> seriesList) {
      this.seriesList = seriesList;
   }
}
