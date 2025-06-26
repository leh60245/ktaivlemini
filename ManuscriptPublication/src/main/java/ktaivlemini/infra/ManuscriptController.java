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
// @RequestMapping(value="/manuscripts")
@Transactional
public class ManuscriptController {

    @Autowired
    ManuscriptRepository manuscriptRepository;

    @RequestMapping(
        value = "/manuscriptscreatemanuscript",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Manuscript createManuscript(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateManuscriptCommand createManuscriptCommand
    ) throws Exception {
        System.out.println("##### /manuscript/createManuscript  called #####");
        Manuscript manuscript = new Manuscript();
        manuscript.createManuscript(createManuscriptCommand);
        manuscriptRepository.save(manuscript);
        return manuscript;
    }

    @RequestMapping(
        value = "/manuscriptssavemanuscript",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Manuscript saveManuscript(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SaveManuscriptCommand saveManuscriptCommand
    ) throws Exception {
        System.out.println("##### /manuscript/saveManuscript  called #####");
        Manuscript manuscript = new Manuscript();
        manuscript.saveManuscript(saveManuscriptCommand);
        manuscriptRepository.save(manuscript);
        return manuscript;
    }
}
//>>> Clean Arch / Inbound Adaptor
