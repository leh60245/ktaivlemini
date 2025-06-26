package ktaivlemini.infra;

import ktaivlemini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PublicationRequestHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PublicationRequest>> {

    @Override
    public EntityModel<PublicationRequest> process(
        EntityModel<PublicationRequest> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/failpublication"
                )
                .withRel("failpublication")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/completepublication"
                )
                .withRel("completepublication")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/startpublicationprocessing"
                )
                .withRel("startpublicationprocessing")
        );

        return model;
    }
}
