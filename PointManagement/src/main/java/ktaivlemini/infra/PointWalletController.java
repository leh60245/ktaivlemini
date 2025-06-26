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
// @RequestMapping(value="/pointWallets")
@Transactional
public class PointWalletController {

    @Autowired
    PointWalletRepository pointWalletRepository;

    @RequestMapping(
        value = "/pointWalletsregistersubscriber",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PointWallet registerSubscriber(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RegisterSubscriberCommand registerSubscriberCommand
    ) throws Exception {
        System.out.println(
            "##### /pointWallet/registerSubscriber  called #####"
        );
        PointWallet pointWallet = new PointWallet();
        pointWallet.registerSubscriber(registerSubscriberCommand);
        pointWalletRepository.save(pointWallet);
        return pointWallet;
    }

    @RequestMapping(
        value = "/pointWalletsreadbookwithpoints",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PointWallet readBookWithPoints(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReadBookWithPointsCommand readBookWithPointsCommand
    ) throws Exception {
        System.out.println(
            "##### /pointWallet/readBookWithPoints  called #####"
        );
        PointWallet pointWallet = new PointWallet();
        pointWallet.readBookWithPoints(readBookWithPointsCommand);
        pointWalletRepository.save(pointWallet);
        return pointWallet;
    }
}
//>>> Clean Arch / Inbound Adaptor
