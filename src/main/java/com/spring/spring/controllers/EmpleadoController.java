package com.spring.spring.controllers;

import com.spring.spring.entities.Empleado;


import com.spring.spring.entities.ObjetoRespuesta;
import com.spring.spring.services.GestorEmpleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
    public class EmpleadoController {

        // Controlador info
        private GestorEmpleado gestorEmpleado = new GestorEmpleado(); // De la clase GestorEmpleado que contiene los empleados

        @GetMapping("/users") //Va a traer todos los usuarios
        public ResponseEntity<List<Empleado>> getEmpleados(){   //Vamos a responder una entidad
            return new ResponseEntity<>(gestorEmpleado.getEmpleados(), HttpStatus.OK);
        }
/*
        @RequestMapping("/user/{id}")
        public ResponseEntity<String> getUsuariospath(@PathVariable String id) {
            return new ResponseEntity<>(id, HttpStatus.OK);

        }
        */
    @GetMapping("/user")
    public ResponseEntity<Object> getUsuarios(@RequestParam long id) {
        try {
            Empleado empleado = gestorEmpleado.getEmpleado(id);
            return new ResponseEntity<>(empleado, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
        /*
        @RequestMapping("enterprises/{id}")
    public Empresa buscarEmpresaPorId(@PathVariable long id){
        return empresaService.getEmpresa(id);
    *
    @RequestMapping("/user/{id}")
    public Empleado Getporid(@PathVariable long id){
        return gestorEmpleado.getEmpleado(id);
    }
    */
    @PostMapping("/users")
        public ResponseEntity<String> postusuario(@RequestBody Empleado usuario_parametro) {
            try {
                String mensaje = gestorEmpleado.setEmpleado(usuario_parametro);
                return new ResponseEntity<>(mensaje, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    @PatchMapping("/usuario/{id}")
    public ResponseEntity<Object> patchUsuario(@RequestBody Empleado empleado_update, @PathVariable long id){
        try {
            Empleado empleado_bdts = gestorEmpleado.updateUsuario(empleado_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion existosa",empleado_bdts),HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage() ,null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteUsuario(@PathVariable long id){

        try {
            String mensaje = gestorEmpleado.deleteUsuario(id);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
