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
// @RequestMapping(value="/publicationRequests")
@Transactional
public class PublicationRequestController {

    @Autowired
    PublicationRequestRepository publicationRequestRepository;

    @RequestMapping(
        value = "/publicationRequestsfailpublication",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationRequest failPublication(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody FailPublicationCommand failPublicationCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationRequest/failPublication  called #####"
        );
        PublicationRequest publicationRequest = new PublicationRequest();
        publicationRequest.failPublication(failPublicationCommand);
        publicationRequestRepository.save(publicationRequest);
        return publicationRequest;
    }

    @RequestMapping(
        value = "/publicationRequestscompletepublication",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationRequest completePublication(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CompletePublicationCommand completePublicationCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationRequest/completePublication  called #####"
        );
        PublicationRequest publicationRequest = new PublicationRequest();
        publicationRequest.completePublication(completePublicationCommand);
        publicationRequestRepository.save(publicationRequest);
        return publicationRequest;
    }

    @RequestMapping(
        value = "/publicationRequestsstartpublicationprocessing",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationRequest startPublicationProcessing(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody StartPublicationProcessingCommand startPublicationProcessingCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationRequest/startPublicationProcessing  called #####"
        );
        PublicationRequest publicationRequest = new PublicationRequest();
        publicationRequest.startPublicationProcessing(
            startPublicationProcessingCommand
        );
        publicationRequestRepository.save(publicationRequest);
        return publicationRequest;
    }
}
//>>> Clean Arch / Inbound Adaptor
