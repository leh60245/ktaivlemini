package ktaivlemini.infra;

import ktaivlemini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PointWalletHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PointWallet>> {

    @Override
    public EntityModel<PointWallet> process(EntityModel<PointWallet> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "registersubscriber"
                )
                .withRel("egistersubscriber")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "readbookwithpoints"
                )
                .withRel("eadbookwithpoints")
        );

        return model;
    }
}
