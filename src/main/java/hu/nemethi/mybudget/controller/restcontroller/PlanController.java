package hu.nemethi.mybudget.controller.restcontroller;

import hu.nemethi.mybudget.dto.PlanDto;
import hu.nemethi.mybudget.service.impl.PlanServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/plan", produces = "application/json", consumes = "application/json")
public class PlanController {

    private static final Logger LOGGER = LogManager.getLogger(PlanController.class);

    private PlanServiceImpl planServiceImpl;

    public PlanController(PlanServiceImpl planServiceImpl) {
        this.planServiceImpl = planServiceImpl;
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deletePlan(@RequestParam String planId) {
        planServiceImpl.delete(planId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/all/{userId}")
    public ResponseEntity<Void> deleteAllPlan(@RequestParam UUID userId) {
        planServiceImpl.deleteAllByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<PlanDto>> listAllPlanByUserId(@RequestParam UUID userId) {
        List<PlanDto> planDtoList = planServiceImpl.listAllByUserId(userId);
        return new ResponseEntity<>(planDtoList, HttpStatus.OK);
    }

    @PatchMapping("modify")
    public ResponseEntity<PlanDto> modifyPlan(@RequestBody PlanDto planDto){
        PlanDto resp = planServiceImpl.modify(planDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<PlanDto> createPlan(@RequestBody PlanDto planDto){
        PlanDto resp = planServiceImpl.create(planDto);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }
}
