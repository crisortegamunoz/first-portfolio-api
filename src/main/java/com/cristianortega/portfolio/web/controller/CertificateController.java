package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.CertificateDomain;
import com.cristianortega.portfolio.domain.dto.search.SearchResults;
import com.cristianortega.portfolio.domain.service.CertificateService;
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
@RequestMapping("/certificate")
public class CertificateController extends WsUtil {

    @Autowired
    private CertificateService certificateService;

    @GetMapping()
    @ApiOperation(value = "Get all certificate", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<CertificateDomain>> getAll() {
        return new ResponseEntity<>(certificateService.getAll(), HttpStatus.OK);
    }

    @GetMapping("find-by-id/{id}")
    @ApiOperation("Search certificate by id")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<CertificateDomain> findById(@PathVariable("id") Long id) {
        return certificateService.findById(id)
                .map(certificate -> new ResponseEntity<>(certificate, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation(value = "Create certificate", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<CertificateDomain> save(@RequestBody CertificateDomain certificateDomain) {
        return new ResponseEntity<>(certificateService.save(certificateDomain), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update certificate", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public ResponseEntity<CertificateDomain> update (@PathVariable("id") Long id, @RequestBody CertificateDomain certificateDomain) {
        return new ResponseEntity<>(certificateService.update(id, certificateDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete certificate by id", authorizations = {
            @Authorization(value="JWT")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Certificate cannot delete because wasn't found")
    })
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        if (certificateService.delete(id)) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find-by-page")
    @ApiOperation("Search certificates by page")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Certificate not found")
    })
    public ResponseEntity<SearchResults> findByPage(@RequestParam("pageNumber") Long pageNumber,
                                                    @RequestParam("pageSize") Long pageSize) {

        if (pageNumber == null || pageSize == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Long count = certificateService.count();
        if (count > 0) {
            return certificateService.findByPage(pageNumber.intValue() - 1, pageSize.intValue())
                    .map(certificates -> {
                        SearchResults<CertificateDomain> results = loadResultCer(certificates, pageNumber, pageSize, count);
                        return new ResponseEntity<SearchResults>(results, HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}
