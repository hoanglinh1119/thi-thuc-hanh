package hoanglinh.codegym.controller;

import hoanglinh.codegym.model.QuocGia;
import hoanglinh.codegym.model.ThanhPho;
import hoanglinh.codegym.service.QuocGiaSerVice;
import hoanglinh.codegym.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThanhPhoController {
    @Autowired
    private ThanhPhoService thanhPhoService;

    @Autowired
    private QuocGiaSerVice quocGiaSerVice;

    @ModelAttribute("quocGias")
    public Iterable<QuocGia> quocGias(){
        return quocGiaSerVice.findAll();
    }
    @GetMapping("/danhsachthanhpho")
    public ModelAndView danhsachthanhpho( @PageableDefault(size = 3) Pageable pageable){

        Page<ThanhPho> thanhPhoPage= thanhPhoService.findAll( pageable);
        ModelAndView modelAndView = new ModelAndView("/thanh-pho/danh-sach");
        modelAndView.addObject("city", thanhPhoPage);
        return modelAndView;

    }

    @GetMapping("/taomoithanhpho")
    public ModelAndView formtaomoi(){
        ModelAndView modelAndView = new ModelAndView("/thanh-pho/tao-moi");
        modelAndView.addObject("thanhpho", new ThanhPho());
        return modelAndView;
    }


    @PostMapping("/taomoithanhpho")
    public ModelAndView taomoi(@Validated @ModelAttribute("thanhpho") ThanhPho thanhPho,BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/thanh-pho/tao-moi");
        if (!bindingResult.hasFieldErrors()){
            thanhPhoService.save(thanhPho);
            modelAndView.addObject("thanhpho", new ThanhPho());
            modelAndView.addObject("message", "Tao moi thanh pho thanh cong");
        }

        return modelAndView;
    }

    @GetMapping("/suathanhpho/{id}")
    public ModelAndView formEdit(@PathVariable Long id){
        ThanhPho thanhPho = thanhPhoService.findById(id);
        if(thanhPho != null) {
            ModelAndView modelAndView = new ModelAndView("/thanh-pho/sua");
            modelAndView.addObject("thanhpho", thanhPho);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/suathanhpho")
    public ModelAndView suathanhpho(@Validated @ModelAttribute("thanhpho") ThanhPho thanhPho,BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/thanh-pho/sua");
        if (!bindingResult.hasFieldErrors()){
            thanhPhoService.save(thanhPho);

            modelAndView.addObject("thanhpho", thanhPho);
            modelAndView.addObject("message", " sua thanh cong");
        }
        return modelAndView;
    }

    @GetMapping("/xoathanhpho/{id}")
    public ModelAndView formDelete(@PathVariable Long id){
        ThanhPho thanhPho = thanhPhoService.findById(id);
        if(thanhPho != null) {
            ModelAndView modelAndView = new ModelAndView("/thanh-pho/xoa");
            modelAndView.addObject("thanhpho", thanhPho);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/xoathanhpho")
    public String deleteCustomer(@ModelAttribute("thanhpho") ThanhPho thanhPho){
        thanhPhoService.delete(thanhPho.getId());
        return "redirect:danhsachthanhpho";
    }


}
