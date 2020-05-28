package hoanglinh.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuocGia {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String ten;
    @OneToMany(targetEntity = QuocGia.class)
    private List<QuocGia> quocGiaList;
    public QuocGia(Long id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public QuocGia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
