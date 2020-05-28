package hoanglinh.codegym.service;

import hoanglinh.codegym.model.QuocGia;

public interface QuocGiaSerVice {
    Iterable<QuocGia> findAll();
    QuocGia findById(Long id);
    void save( QuocGia quocGia);
    void delete (Long id);
}
