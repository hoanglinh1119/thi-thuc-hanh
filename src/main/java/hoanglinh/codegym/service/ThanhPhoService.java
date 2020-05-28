package hoanglinh.codegym.service;

import hoanglinh.codegym.model.ThanhPho;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThanhPhoService {
    Page<ThanhPho> findAll(Pageable pageable);
    ThanhPho findById(Long id);
    void save( ThanhPho thanhPho);
    void delete (Long id);
//    Page<ThanhPho> findAllByOrderByNameDesc(Pageable p);
}
