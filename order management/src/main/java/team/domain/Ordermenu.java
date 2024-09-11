package team.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import team.OrderManagementApplication;
import team.domain.OrderDeleted;
import team.domain.StatusUpdated;

@Entity
@Table(name = "Ordermenu_table")
@Data
//<<< DDD / Aggregate Root
public class Ordermenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderMenuId;

    private Long orderId;

    private Long menuId;

    private Integer quantity;

    private String menuStatus;

    @PostUpdate
    public void onPostUpdate() {
        StatusUpdated statusUpdated = new StatusUpdated(this);
        statusUpdated.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        OrderDeleted orderDeleted = new OrderDeleted(this);
        orderDeleted.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static OrdermenuRepository repository() {
        OrdermenuRepository ordermenuRepository = OrderManagementApplication.applicationContext.getBean(
            OrdermenuRepository.class
        );
        return ordermenuRepository;
    }

    //<<< Clean Arch / Port Method
    public static void 주문접수(AddCart addCart) {
        //implement business logic here:

        /** Example 1:  new item 
        Ordermenu ordermenu = new Ordermenu();
        repository().save(ordermenu);

        */

        /** Example 2:  finding and process
        
        repository().findById(addCart.get???()).ifPresent(ordermenu->{
            
            ordermenu // do something
            repository().save(ordermenu);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
