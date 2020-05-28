package hoanglinh.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min = 5,max = 30)
    private String tenThanhPho;

    @ManyToOne
    private QuocGia quocGia;

    @Min(0)
    private Long dienTich;
    @Min(0)
    private Long danSo;
    @Min(0)
    private Long gDP;
    @NotEmpty
    private String  mota;

    public ThanhPho(Long id, @NotEmpty @Size(min = 25, max = 50) String tenThanhPho, QuocGia quocGia,
                    @Min(0) Long dienTich, @Min(0) Long danSo, @Min(0) Long gDP, @NotEmpty String mota) {
        this.id = id;
        this.tenThanhPho = tenThanhPho;
        this.quocGia = quocGia;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gDP = gDP;
        this.mota = mota;
    }

    public ThanhPho() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public Long getDienTich() {
        return dienTich;
    }

    public void setDienTich(Long dienTich) {
        this.dienTich = dienTich;
    }

    public Long getDanSo() {
        return danSo;
    }

    public void setDanSo(Long danSo) {
        this.danSo = danSo;
    }

    public Long getgDP() {
        return gDP;
    }

    public void setgDP(Long gDP) {
        this.gDP = gDP;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }
}
