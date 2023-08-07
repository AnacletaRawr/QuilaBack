package quila.tiendaquila.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contacto_cliente")
public class ContactoClienteEntity {
    // Declaración de Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long contactoId;

    // Declaración de foreign Keys

    // Declaración de otros atributos
    private String nombrecontacto;
    private String emailContacto;
    private String telefonoContacto;
    private String asuntoMensaje;
    private String contenidoMensaje;

    // Registro de la fecha y hora del contacto

    // constructores

    public ContactoClienteEntity(String nombrecontacto, String emailContacto, String telefonoContacto, String asuntoMensaje, String contenidoMensaje) {
        this.nombrecontacto = nombrecontacto;
        this.emailContacto = emailContacto;
        this.telefonoContacto = telefonoContacto;
        this.asuntoMensaje = asuntoMensaje;
        this.contenidoMensaje = contenidoMensaje;
    }

    public ContactoClienteEntity() {
    }

// Getters & Setters


    public Long getContactoId() {
        return contactoId;
    }


    public String getNombrecontacto() {
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getAsuntoMensaje() {
        return asuntoMensaje;
    }

    public void setAsuntoMensaje(String asuntoMensaje) {
        this.asuntoMensaje = asuntoMensaje;
    }

    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenidoMensaje) {
        this.contenidoMensaje = contenidoMensaje;
    }
}
