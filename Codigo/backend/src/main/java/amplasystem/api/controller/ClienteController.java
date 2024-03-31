package amplasystem.api.controller;

import amplasystem.api.dtos.cliente.ClienteDTO;
import amplasystem.api.dtos.cliente.RequestClientDTO;
import amplasystem.api.models.Cliente;
import amplasystem.api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Integer id) {
        ClienteDTO cliente = clienteService.getById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody RequestClientDTO requestClientDTO) {
        ClienteDTO createdCliente = clienteService.save(requestClientDTO);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody RequestClientDTO requestClientDTO) {
        ClienteDTO updatedCliente = clienteService.update(requestClientDTO);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
