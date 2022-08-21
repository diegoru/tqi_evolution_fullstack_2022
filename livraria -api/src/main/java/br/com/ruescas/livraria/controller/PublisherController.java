package br.com.ruescas.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruescas.livraria.data.vo.v1.PublisherVO;
import br.com.ruescas.livraria.services.PublisherServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/publisher/v1")
@Tag(name = "Publisher", description = "Endpoints for Managing Publisher")
public class PublisherController {

        @Autowired
        private PublisherServices service;

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Finds all Publisher", description = "Finds all Publisher", tags = {
                        "Publisher" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                                        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PublisherVO.class)))
                                        }),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                                        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
                        })
        public List<PublisherVO> findAll() {
                return service.findAll();
        }

        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Finds a Publisher", description = "Finds a Publisher", tags = {
                        "Publisher" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PublisherVO.class))),
                                        @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                                        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
                        })
        public PublisherVO findById(@PathVariable(value = "id") Long id) {
                return service.findById(id);
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Adds a new Publisher", description = "Adds a new Publisher by passing in a JSON, XML or YML representation of the publisher!", tags = {
                        "Publisher" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PublisherVO.class))),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
                        })
        public PublisherVO create(@RequestBody PublisherVO publisher) {
                return service.create(publisher);
        }

        @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @Operation(summary = "Updates a Publisher", description = "Updates a Publisher by passing in a JSON, XML or YML representation of the publisher!", tags = {
                        "Publisher" }, responses = {
                                        @ApiResponse(description = "Updated", responseCode = "200", content = @Content(schema = @Schema(implementation = PublisherVO.class))),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                                        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
                        })
        public PublisherVO update(@RequestBody PublisherVO publisher) {
                return service.update(publisher);
        }

        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Deletes a Publisher", description = "Deletes a Publisher by passing in a JSON, XML or YML representation of the publisher!", tags = {
                        "Publisher" }, responses = {
                                        @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                                        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                                        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                                        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
                        })
        public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
                service.delete(id);
                return ResponseEntity.noContent().build();
        }
}
