package com.example.sistemaannedecor2.Controller;

import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.Venta;
import com.example.sistemaannedecor2.Dto.DtoVenta;
import com.example.sistemaannedecor2.Dto.DtoVentacortina;
import com.example.sistemaannedecor2.Service.ClienteService;
import com.example.sistemaannedecor2.Service.VentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:5174")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Ventas")

public class VentaController {

    private VentaService ventaService;

    public VentaController(VentaService vs) {
        this.ventaService = vs;
    }
    @GetMapping
    public List<Venta> findAllVenta(){
        System.out.println("Entro");
        return ventaService.findAll();
    }
    @PostMapping
    public Venta GuardarVenta(@RequestBody Venta venta){
        return ventaService.Save(venta);
    }

    @PutMapping
    public void ActualizarVenta(@RequestBody Venta venta){
        ventaService.update(venta);
    }
    @DeleteMapping({"/{id}"})
    public void eliminarVenta(@PathVariable int id){
        ventaService.delete(id);
    }
    @GetMapping("/{id}")
    public Venta buscarVentaPorId(@PathVariable int id){
        return ventaService.findById(id);
    }
    @PostMapping("/{idCortina}/{idVenta}")
    public Cortina AgregarCortinasAVenta(@PathVariable int idCortina,@PathVariable int idVenta){
        System.out.println("Entro");
        System.out.println(idCortina);
        return ventaService.SaveCortinasVenta(idCortina,idVenta);
    }
    @GetMapping("/Dto")
    public List<DtoVenta> findAllVentaDto(){
        return ventaService.findAllDto();
    }
    @GetMapping("/Dto/{NombreCli}")
    public List<DtoVenta> findAllVentaDto(@PathVariable String NombreCli){
        return ventaService.findAllDtoLike(NombreCli);
    }
    @GetMapping("/DtoVentaCor/{IdVenta}")
    public List<DtoVentacortina> findAllVentaDto(@PathVariable int IdVenta){
        System.out.println("Entro");
        return ventaService.findAllDtoVC(IdVenta);
    }
    @GetMapping("/DtoVentaCor/Next")
    public List<DtoVenta> findNextVentaDto(){
        return ventaService.findNextDto();
    }

    }

