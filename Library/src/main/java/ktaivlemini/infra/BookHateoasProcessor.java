package ktaivlemini.infra;

import ktaivlemini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BookHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Book>> {

    @Override
    public EntityModel<Book> process(EntityModel<Book> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "registerbookauto"
                )
                .withRel("egisterbookauto")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "readbook")
                .withRel("eadbook")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/designatebookasbestseller"
                )
                .withRel("designatebookasbestseller")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "createbookpublishingrequest"
                )
                .withRel("reatebookpublishingrequest")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/publishbook")
                .withRel("publishbook")
        );

        return model;
    }
}
