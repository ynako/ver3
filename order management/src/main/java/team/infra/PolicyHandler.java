package team.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import team.config.kafka.KafkaProcessor;
import team.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrdermenuRepository ordermenuRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AddCart'"
    )
    public void wheneverAddCart_OrderAccept(@Payload AddCart addCart) {
        AddCart event = addCart;
        System.out.println(
            "\n\n##### listener OrderAccept : " + addCart + "\n\n"
        );

        // Sample Logic //
        Ordermenu.orderAccept(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
