package ktaivlemini.infra;

import ktaivlemini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ManuscriptHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Manuscript>> {

    @Override
    public EntityModel<Manuscript> process(EntityModel<Manuscript> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "createmanuscript"
                )
                .withRel("reatemanuscript")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/savemanuscript")
                .withRel("savemanuscript")
        );

        return model;
    }
}
