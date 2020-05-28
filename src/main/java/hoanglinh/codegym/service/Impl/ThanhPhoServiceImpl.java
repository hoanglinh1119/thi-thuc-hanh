package hoanglinh.codegym.service.Impl;

import hoanglinh.codegym.model.ThanhPho;
import hoanglinh.codegym.repositories.ThanhPhoRepository;
import hoanglinh.codegym.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ThanhPhoServiceImpl implements ThanhPhoService {
      @Autowired
      private ThanhPhoRepository thanhPhoRepository;
    @Override
    public Page<ThanhPho> findAll(Pageable pageable) {
        return thanhPhoRepository.findAll(pageable);
    }

    @Override
    public ThanhPho findById(Long id) {
        return thanhPhoRepository.findOne(id);
    }

    @Override
    public void save(ThanhPho thanhPho) {
   thanhPhoRepository.save(thanhPho);
    }

    @Override
    public void delete(Long id) {
     thanhPhoRepository.delete(id);
    }
}
