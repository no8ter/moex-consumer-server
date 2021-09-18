package sber.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.trade.data.da.entity.ch.MoexDto;

import java.util.List;

@RestController
@RequestMapping("/shares-consumer")
public class MoexConsumerController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MoexConsumerController.class);

    MoexConsumerController() {
    }

    @PostMapping
    @ResponseBody
    private Integer getTopSharesByDay(@RequestBody List<MoexDto> moexDtos) {
        LOGGER.info(moexDtos.toString());
        return HttpStatus.I_AM_A_TEAPOT.value();
    }
}
