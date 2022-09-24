package com.spring.spring.services;

import com.spring.spring.entities.Empleado;
import com.spring.spring.entities.Empresa;
import com.spring.spring.entities.Enum_RoleName;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.Optional;

public class GestorEmpleado {


    private ArrayList<Empleado> empleados; //Lista de objetos para probar controlador

    public GestorEmpleado() {
        this.empleados = new ArrayList<>();

        //Informacion de prueba
        this.empleados.add(new Empleado(1, "José Rodriguez", "jose_rodruiguez@gmail.com", new Empresa("Sigmi", "27", "26626", "5845"), Enum_RoleName.ADMIN));
        this.empleados.add(new Empleado(2, "David Ortiz", "davidestebanortizjernandez@gmail.com", new Empresa("plantaringeneria", "22", "321055", "1111"), Enum_RoleName.OPERARIO));
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

/*
        @RequestMapping(value = "nombreEmpleado")
        public String getNombreEmpleado(){
           return empleados.get(0).getNombre();
        }
*/

    public Empleado getEmpleado(long idnombre) throws Exception {
        for (Empleado empleado : this.empleados) {
            if (empleado.getId() == (idnombre)) ;
            {
                return empleado;
            }
        }
        throw new Exception("Usuario no existe");
    }


    public String setEmpleado(Empleado id) throws Exception {

        try {
            //Consulta de existencia del usuario
            getEmpleado(id.getId());
        } catch (Exception e) {
            //Creacion del usuario
            this.empleados.add(id);
            return "Creacion del usuario exitosa";
        }
        //Error si el usuario ya existe
        throw new Exception("Usuario existe");
    }

    public Empleado updateUsuario(Empleado empleado_update, long id) throws Exception {
        try {
            Empleado empleado_bdts = getEmpleado(id);

            if(empleado_update.getEmpresa() != null && !empleado_update.getEmpresa().equals("")) {
                empleado_bdts.setEmpresa(empleado_update.getEmpresa());

            }
            if(empleado_update.getNombre() != null && !empleado_update.getNombre().equals("")) {
                empleado_bdts.setNombre(empleado_update.getNombre());
            }
            if(empleado_update.getEmail() != null && !empleado_update.getEmail().equals("")) {
                empleado_bdts.setEmail(empleado_update.getEmail());
            }

            return empleado_bdts;

        } catch (Exception e) {
            throw new Exception("Usuario no existe, fallo actualizacion");
        }


}

    public String deleteUsuario(long id) throws Exception {
        try {
            Empleado empleado = getEmpleado(id);

            this.empleados.remove(empleado);

            return "Eliminado exitoso";
        } catch (Exception e) {
            throw new Exception("Usuario NO Existe para Eliminar");
        }

    }
}