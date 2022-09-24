package com.spring.spring.entities;




public class Empresa {

        private long id;

        private String nombre;

        private String nit;

        private String direccion;

        private String telefono;



        public Empresa(String nombre, String direccion, String telefono, String nit) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.telefono = telefono;
            this.nit = nit;
        }

        public String getNit() {
            return nit;
        }

        public void setNit(String nit) {
            this.nit = nit;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public long getId() {
            return id;
        }
    }
