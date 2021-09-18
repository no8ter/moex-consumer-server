package ru.sbrf.trade.data.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.trade.data.da.DataStorageConnection;
import ru.sbrf.trade.data.da.entity.ch.MoexColumnNameDto;
import ru.sbrf.trade.data.da.entity.ch.MoexDto;

import javax.inject.Qualifier;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/shares-consumer")
public class MoexConsumerController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MoexConsumerController.class);
    private final DataStorageConnection clickHouse;

    @Autowired
    public MoexConsumerController(DataStorageConnection clickHouse) {
        this.clickHouse = clickHouse;
    }

    @PostMapping
    @ResponseBody
    private Integer getTopSharesByDay(@RequestBody List<MoexDto> moexDtos) throws IOException, SQLException {
        LOGGER.info("SENDING MESSAGES TO DB");
        clickHouse.uploadClickhouse(moexDtos, new MoexColumnNameDto());

        return HttpStatus.I_AM_A_TEAPOT.value();
    }
}
