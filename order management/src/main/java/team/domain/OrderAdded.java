package team.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import team.domain.*;
import team.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderAdded extends AbstractEvent {

    private Long orderMenuId;
    private Long orderId;
    private Long menuId;
    private Integer quantity;
    private String menuStatus;

    public OrderAdded(Ordermenu aggregate) {
        super(aggregate);
    }

    public OrderAdded() {
        super();
    }
}
//>>> DDD / Domain Event
