package com.ironhack.erp.clientservice.controller.impl;

import com.ironhack.erp.clientservice.controller.interfaces.ClientControllerInterface;
import com.ironhack.erp.clientservice.model.entities.Client;
import com.ironhack.erp.clientservice.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Client Controller
 */
@Tag(name = "Client Controller", description = "Client query endpoints")
@RestController
public class ClientControllerImpl implements ClientControllerInterface {

    @Autowired
    ClientService clientService;


    @Operation(summary = "Find All",
            description = "This end-point provides the list of all clients")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(schema = @Schema(implementation = Client.class)))})
    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Operation(summary = "Find by ID",
            description = "This end-point provides a client by Identifier")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(schema = @Schema(implementation = Client.class))),
            @ApiResponse(responseCode = "404", description = "Client not found")})
    @GetMapping("/client/{id}")
    public Client findById(@PathVariable @Parameter(description = "Client Identifier") Long id) {
        return clientService.findById(id);
    }

    @Operation(summary = "Create a client",
            description = "This end-point is used to create a client")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successful operation",
            content = @Content(schema = @Schema(implementation = Client.class)))})
    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody @Parameter(description = "Client") Client client) {
        return clientService.createClient(client);
    }

    @PostMapping("/client/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody @Parameter(description = "Client") Client client, @PathVariable Long id) {
        return clientService.updateClient(client, id);
    }

    @Operation(summary = "Delete Client",
            description = "This end-point is used to delete a client")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Successful operation",
            content = @Content(schema = @Schema(implementation = Client.class)))})
    @DeleteMapping("/client/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable @Parameter(description = "Client Identifier") Long id) {
        clientService.deleteClient(id);
    }

}
