package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.LaboratoryDomain;
import com.cristianortega.portfolio.domain.dto.search.SearchResults;
import com.cristianortega.portfolio.domain.service.LaboratoryService;
import com.cristianortega.portfolio.web.controller.util.WsUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,
        RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RestController
@RequestMapping("/laboratory")
public class LaboratoryController extends WsUtil {

    @Autowired
    private LaboratoryService laboratoryService;

    @GetMapping()
    @ApiOperation(value = "Get all laboratories", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<LaboratoryDomain>> getAll() {
        return new ResponseEntity<>(laboratoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("find-by-id/{id}")
    @ApiOperation("Search laboratory by id")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<LaboratoryDomain> findById(@PathVariable("id") Long id) {
        return laboratoryService.findById(id)
                .map(laboratory -> new ResponseEntity<>(laboratory, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation(value = "Create laboratory", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<LaboratoryDomain> save(@RequestBody  LaboratoryDomain laboratoryDomain) {
        return new ResponseEntity<>(laboratoryService.save(laboratoryDomain), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update laboratory", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<LaboratoryDomain> update (@PathVariable("id") Long id, @RequestBody LaboratoryDomain laboratoryDomain) {
        return new ResponseEntity<>(laboratoryService.update(id, laboratoryDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete laboratory by id", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Laboratory cannot delete because wasn't found")
    })
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        if (laboratoryService.delete(id)) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("find-by-page")
    @ApiOperation("Search laboratory by page")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Laboratory not found")
    })
    public ResponseEntity<SearchResults> findByPage(@RequestParam("pageNumber") Long pageNumber,
                                                    @RequestParam("pageSize") Long pageSize) {
        if (pageNumber == null || pageSize == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Long count = laboratoryService.count();
        if (count > 0) {
            return laboratoryService.findByPage(pageNumber.intValue() - 1, pageSize.intValue())
                    .map(laboratories -> {
                        SearchResults<LaboratoryDomain> results = loadResultLab(laboratories, pageNumber, pageSize, count);
                        return new ResponseEntity<SearchResults>(results, HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("filter-by-technology/")
    @ApiOperation("Search laboratory by technology name")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Laboratory not found")
    })
    public ResponseEntity<SearchResults> findByTechnologyName(@RequestParam("pageNumber") Long pageNumber,
                                                              @RequestParam("pageSize") Long pageSize,
                                                              @RequestParam("name") String name) {
        if (pageNumber == null || pageSize == null || name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Long count = laboratoryService.count();
        if (count > 0) {
            return laboratoryService.findByTechnologyName(pageNumber.intValue() - 1, pageSize.intValue(), name)
                    .map(laboratories -> {
                        SearchResults<LaboratoryDomain> results = loadResultLab(laboratories, pageNumber, pageSize, count);
                        return new ResponseEntity<SearchResults>(results, HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
