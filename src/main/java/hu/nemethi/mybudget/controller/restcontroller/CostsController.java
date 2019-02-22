package hu.nemethi.mybudget.controller.restcontroller;

import hu.nemethi.mybudget.dto.CostDto;
import hu.nemethi.mybudget.service.impl.CostServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/cost", produces = "application/json", consumes = "application/json")
public class CostsController {

    private static final Logger LOGGER = LogManager.getLogger(CostsController.class);

    private CostServiceImpl costService;

    public CostsController(CostServiceImpl costService) {
        this.costService = costService;
    }

    @PostMapping("/save")
    public ResponseEntity<CostDto> save(@RequestBody CostDto costDto) throws SQLException {
        CostDto response = costService.create(costDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{costId}")
    public ResponseEntity<Void> delete(@RequestParam String costId) throws SQLException {
        costService.delete(costId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/modify")
    public ResponseEntity<CostDto> modify(@RequestBody CostDto costDto) throws SQLException {
        CostDto response = costService.modify(costDto);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<CostDto>> listAll(@RequestParam UUID userId) throws SQLException {
        List<CostDto> response = costService.listAllByUserId(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/all/{userId}")
    public ResponseEntity<Void> deleteAllByUserId(@RequestParam UUID userId) throws SQLException {
        costService.deleteAllByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
