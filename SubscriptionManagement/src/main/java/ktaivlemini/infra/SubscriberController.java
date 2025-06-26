package ktaivlemini.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import ktaivlemini.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/subscribers")
@Transactional
public class SubscriberController {

    @Autowired
    SubscriberRepository subscriberRepository;

    @RequestMapping(
        value = "/subscribersactivatesubscription",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Subscriber activateSubscription(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ActivateSubscriptionCommand activateSubscriptionCommand
    ) throws Exception {
        System.out.println(
            "##### /subscriber/activateSubscription  called #####"
        );
        Subscriber subscriber = new Subscriber();
        subscriber.activateSubscription(activateSubscriptionCommand);
        subscriberRepository.save(subscriber);
        return subscriber;
    }

    @RequestMapping(
        value = "/subscribersreadbookwithsubscription",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Subscriber readBookWithSubscription(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReadBookWithSubscriptionCommand readBookWithSubscriptionCommand
    ) throws Exception {
        System.out.println(
            "##### /subscriber/readBookWithSubscription  called #####"
        );
        Subscriber subscriber = new Subscriber();
        subscriber.readBookWithSubscription(readBookWithSubscriptionCommand);
        subscriberRepository.save(subscriber);
        return subscriber;
    }

    @RequestMapping(
        value = "/subscribersrequestsubscription",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Subscriber requestSubscription(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RequestSubscriptionCommand requestSubscriptionCommand
    ) throws Exception {
        System.out.println(
            "##### /subscriber/requestSubscription  called #####"
        );
        Subscriber subscriber = new Subscriber();
        subscriber.requestSubscription(requestSubscriptionCommand);
        subscriberRepository.save(subscriber);
        return subscriber;
    }
}
//>>> Clean Arch / Inbound Adaptor
