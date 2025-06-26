package ktaivlemini.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import ktaivlemini.config.kafka.KafkaProcessor;
import ktaivlemini.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    BookRepository bookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointExhausted'"
    )
    public void wheneverPointExhausted_RecommendPlanOnPointExhausted(
        @Payload PointExhausted pointExhausted
    ) {
        PointExhausted event = pointExhausted;
        System.out.println(
            "\n\n##### listener RecommendPlanOnPointExhausted : " +
            pointExhausted +
            "\n\n"
        );
        // Comments //
        //구독자의 포인트가 모두 소진되면 도서 열람이 불가하므로, KT 이동 및 특정 요금제 가입을 추천하는 알림을 제공함

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
