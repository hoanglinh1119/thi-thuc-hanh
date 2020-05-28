package hoanglinh.codegym.service.Impl;

import hoanglinh.codegym.model.QuocGia;
import hoanglinh.codegym.repositories.QuocGiaRepository;
import hoanglinh.codegym.service.QuocGiaSerVice;
import org.springframework.beans.factory.annotation.Autowired;


public class QuocGiaServiceImpl implements QuocGiaSerVice {
    @Autowired
    private QuocGiaRepository quocGiaRepository;


    @Override
    public Iterable<QuocGia> findAll() {
        return quocGiaRepository.findAll();
    }

    @Override
    public QuocGia findById(Long id) {
        return quocGiaRepository.findOne(id);
    }

    @Override
    public void save(QuocGia quocGia) {
    quocGiaRepository.save(quocGia);
    }

    @Override
    public void delete(Long id) {
     quocGiaRepository.delete(id);
    }
}
