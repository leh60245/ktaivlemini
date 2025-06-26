package ktaivlemini.infra;

import ktaivlemini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AiCoverJobHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AiCoverJob>> {

    @Override
    public EntityModel<AiCoverJob> process(EntityModel<AiCoverJob> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/startaicovergeneration"
                )
                .withRel("startaicovergeneration")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/failaicovergeneration"
                )
                .withRel("failaicovergeneration")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "createaicoverjob"
                )
                .withRel("reateaicoverjob")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/completeaicovergeneration"
                )
                .withRel("completeaicovergeneration")
        );

        return model;
    }
}
