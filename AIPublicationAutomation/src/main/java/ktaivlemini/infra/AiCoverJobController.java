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
// @RequestMapping(value="/aiCoverJobs")
@Transactional
public class AiCoverJobController {

    @Autowired
    AiCoverJobRepository aiCoverJobRepository;

    @RequestMapping(
        value = "/aiCoverJobsstartaicovergeneration",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public AiCoverJob startAiCoverGeneration(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody StartAiCoverGenerationCommand startAiCoverGenerationCommand
    ) throws Exception {
        System.out.println(
            "##### /aiCoverJob/startAiCoverGeneration  called #####"
        );
        AiCoverJob aiCoverJob = new AiCoverJob();
        aiCoverJob.startAiCoverGeneration(startAiCoverGenerationCommand);
        aiCoverJobRepository.save(aiCoverJob);
        return aiCoverJob;
    }

    @RequestMapping(
        value = "/aiCoverJobsfailaicovergeneration",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public AiCoverJob failAiCoverGeneration(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody FailAiCoverGenerationCommand failAiCoverGenerationCommand
    ) throws Exception {
        System.out.println(
            "##### /aiCoverJob/failAiCoverGeneration  called #####"
        );
        AiCoverJob aiCoverJob = new AiCoverJob();
        aiCoverJob.failAiCoverGeneration(failAiCoverGenerationCommand);
        aiCoverJobRepository.save(aiCoverJob);
        return aiCoverJob;
    }

    @RequestMapping(
        value = "/aiCoverJobscreateaicoverjob",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public AiCoverJob createAiCoverJob(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateAiCoverJobCommand createAiCoverJobCommand
    ) throws Exception {
        System.out.println("##### /aiCoverJob/createAiCoverJob  called #####");
        AiCoverJob aiCoverJob = new AiCoverJob();
        aiCoverJob.createAiCoverJob(createAiCoverJobCommand);
        aiCoverJobRepository.save(aiCoverJob);
        return aiCoverJob;
    }

    @RequestMapping(
        value = "/aiCoverJobscompleteaicovergeneration",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public AiCoverJob completeAiCoverGeneration(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CompleteAiCoverGenerationCommand completeAiCoverGenerationCommand
    ) throws Exception {
        System.out.println(
            "##### /aiCoverJob/completeAiCoverGeneration  called #####"
        );
        AiCoverJob aiCoverJob = new AiCoverJob();
        aiCoverJob.completeAiCoverGeneration(completeAiCoverGenerationCommand);
        aiCoverJobRepository.save(aiCoverJob);
        return aiCoverJob;
    }
}
//>>> Clean Arch / Inbound Adaptor
