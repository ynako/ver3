package team.domain;

import java.util.*;
import lombok.*;
import team.domain.*;
import team.infra.AbstractEvent;

@Data
@ToString
public class AddCart extends AbstractEvent {

    private Long orderId;
    private Long userId;
    private Date orderdate;
    private String menuId;
    private Integer totalPrice;
    private String orderStatus;
}
