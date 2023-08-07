package quila.tiendaquila.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "noticias_quila")
public class ActividadesEntity {
    // Declaración de Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long publicacionId;

    // Declaración de foreign Keys

    // Declaración de otros atributos
    private String titularNoticia;
    private String bajadaNoticia;
    private String cuerpoNoticia;
    private String imagenNoticia;


    // constructores

    public ActividadesEntity(String titularNoticia, String bajadaNoticia, String cuerpoNoticia, String imagenNoticia) {

        this.titularNoticia = titularNoticia;
        this.bajadaNoticia = bajadaNoticia;
        this.cuerpoNoticia = cuerpoNoticia;
        this.imagenNoticia = imagenNoticia;
    }

    public ActividadesEntity() {
    }

    // Getters & Setters

    public Long getPublicacionId() {
        return publicacionId;
    }

    public String getTitularNoticia() {
        return titularNoticia;
    }

    public void setTitularNoticia(String titularNoticia) {
        this.titularNoticia = titularNoticia;
    }

    public String getBajadaNoticia() {
        return bajadaNoticia;
    }

    public void setBajadaNoticia(String bajadaNoticia) {
        this.bajadaNoticia = bajadaNoticia;
    }

    public String getCuerpoNoticia() {
        return cuerpoNoticia;
    }

    public void setCuerpoNoticia(String cuerpoNoticia) {
        this.cuerpoNoticia = cuerpoNoticia;
    }

    public String getImagenNoticia() {
        return imagenNoticia;
    }

    public void setImagenNoticia(String imagenNoticia) {
        this.imagenNoticia = imagenNoticia;
    }

}
