package team.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import team.domain.*;
import team.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AddCart extends AbstractEvent {

    private Long orderId;
    private Long userId;
    private Date orderdate;
    private String menuId;
    private Integer totalPrice;
    private String orderStatus;

    public AddCart(Order aggregate) {
        super(aggregate);
    }

    public AddCart() {
        super();
    }
}
//>>> DDD / Domain Event
