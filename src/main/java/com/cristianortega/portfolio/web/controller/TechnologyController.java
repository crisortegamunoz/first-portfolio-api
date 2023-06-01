package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.TechnologyDomain;
import com.cristianortega.portfolio.domain.dto.search.SearchResults;
import com.cristianortega.portfolio.domain.service.TechnologyService;
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
@RequestMapping("/technology")
public class TechnologyController extends WsUtil {

    @Autowired
    private TechnologyService technologyService;

    @GetMapping("find-by-id/{id}")
    @ApiOperation("Search technology by id")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<TechnologyDomain> findById(@PathVariable("id") Long id) {
        return technologyService.findById(id)
                .map(technology -> new ResponseEntity<>(technology, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation(value = "Create technology", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<TechnologyDomain> save(@RequestBody TechnologyDomain technologyDomain) {
        return new ResponseEntity<>(technologyService.save(technologyDomain), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update technology", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<TechnologyDomain> update (@PathVariable("id") Long id, @RequestBody TechnologyDomain technologyDomain) {
        return new ResponseEntity<>(technologyService.update(id, technologyDomain), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete technology by id", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Technology cannot delete because wasn't found")
    })
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        if(technologyService.delete(id)) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("find-by-page")
    @ApiOperation("Search technologies by page")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Technologies not found")
    })
    public ResponseEntity<SearchResults> findByPage(@RequestParam("pageNumber") Long pageNumber,
                                                    @RequestParam("pageSize") Long pageSize) {
        if (pageNumber == null || pageSize == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Long count = technologyService.count();
        if (count > 0) {
            return technologyService.findByPage(pageNumber.intValue() - 1, pageSize.intValue())
                    .map(technologies -> {
                        SearchResults<TechnologyDomain> results = loadResultTech(technologies, pageNumber, pageSize, count);
                        return new ResponseEntity<SearchResults>(results, HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/get-important")
    @ApiOperation("Search important technologies")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Technologies not found")
    })
    public ResponseEntity<List<TechnologyDomain>> getImportantTechnologies() {
        return technologyService.findImportantTechnologies(true)
                .map(technologies -> new ResponseEntity<>(technologies, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    @ApiOperation("Search all technologies")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Technologies not found")
    })
    public ResponseEntity<List<TechnologyDomain>> getAll() {
        return new ResponseEntity<>(technologyService.getAll(), HttpStatus.OK);
    }

}
