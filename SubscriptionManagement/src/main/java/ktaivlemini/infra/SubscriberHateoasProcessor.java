package ktaivlemini.infra;

import ktaivlemini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class SubscriberHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Subscriber>> {

    @Override
    public EntityModel<Subscriber> process(EntityModel<Subscriber> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/activatesubscription"
                )
                .withRel("activatesubscription")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "readbookwithsubscription"
                )
                .withRel("eadbookwithsubscription")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "requestsubscription"
                )
                .withRel("equestsubscription")
        );

        return model;
    }
}
