package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.AboutMeDomain;
import com.cristianortega.portfolio.domain.dto.search.SearchResults;
import com.cristianortega.portfolio.domain.service.AboutMeService;
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
@RequestMapping("/about-me")
public class AboutMeController extends WsUtil {

    @Autowired
    private AboutMeService aboutMeService;


    @GetMapping()
    @ApiOperation(value = "Get All Personal information", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<AboutMeDomain>> getAll() {
        return new ResponseEntity<>(aboutMeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("find-by-id/{id}")
    @ApiOperation("Search personal information by ID")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<AboutMeDomain> findById(@PathVariable("id") Long id) {
        return  aboutMeService.findById(id)
                .map(aboutMe -> new ResponseEntity<>(aboutMe, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation(value = "Create Personal information", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<AboutMeDomain> save(@RequestBody AboutMeDomain aboutMeDomain) {
        return new ResponseEntity<>(aboutMeService.save(aboutMeDomain), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Personal information", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<AboutMeDomain> update (@PathVariable("id") Long id, @RequestBody AboutMeDomain aboutMeDomain) {
        return new ResponseEntity<>(aboutMeService.update(id, aboutMeDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Personal information", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Personal Information cannot delete because wasn't found")
    })
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        if (aboutMeService.delete(id)) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find-by-page")
    @ApiOperation("Search personal information by page")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Personal Information not found")
    })
    public ResponseEntity<SearchResults> findByPage(@RequestParam("pageNumber") Long pageNumber,
                                                          @RequestParam("pageSize") Long pageSize) {
        if (pageNumber == null || pageSize == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Long count = aboutMeService.count();
        if (count > 0) {
            return aboutMeService.findByPage(pageNumber.intValue() - 1, pageSize.intValue())
                    .map(aboutmeList -> {
                        SearchResults<AboutMeDomain> results = loadResultMe(aboutmeList, pageNumber, pageSize, count);
                        return new ResponseEntity<SearchResults>(results, HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
