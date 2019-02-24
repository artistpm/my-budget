package hu.nemethi.mybudget.controller.restcontroller;

import hu.nemethi.mybudget.dto.IncomeDto;
import hu.nemethi.mybudget.service.impl.IncomeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/income", produces = "application/json", consumes = "application/json")
public class IncomeController {

    private static final Logger LOGGER = LogManager.getLogger(IncomeController.class);

    private IncomeServiceImpl incomeServiceImpl;

    public IncomeController(IncomeServiceImpl incomeServiceImpl) {
        this.incomeServiceImpl = incomeServiceImpl;
    }

    @PostMapping("/save")
    public ResponseEntity<IncomeDto> save(@RequestBody IncomeDto incomeDto){
        IncomeDto resp = incomeServiceImpl.create(incomeDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam String incomeId){
        incomeServiceImpl.delete(incomeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/all/{userId}")
    public ResponseEntity<Void> deleteAll(@RequestParam UUID userId){
        incomeServiceImpl.deleteAllByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("modify")
    public ResponseEntity<IncomeDto> modify(@RequestBody IncomeDto incomeDto){
        IncomeDto resp = incomeServiceImpl.modify(incomeDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<IncomeDto>> listAllByUserId(@RequestParam UUID userId){
        List<IncomeDto> incomeDtos = incomeServiceImpl.listAllByUserId(userId);
        return new ResponseEntity<>(incomeDtos, HttpStatus.OK);
    }
}
