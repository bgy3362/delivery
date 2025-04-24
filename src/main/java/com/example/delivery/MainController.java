package com.example.delivery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
//    @GetMapping(value = "/search")
//    public String search(Model model) {
//        return "search";
//    }

    @GetMapping("/search")
    public String showMap(Model model) {
        // 샘플 Store 객체 (실제로는 DB에서 조회해야 함)
        Store store = Store.builder()
                .name("맛있는 식당")
                .latitude(37.5665)
                .longitude(126.9780)
                .table(10)
                .waiting(3)
                .build();

        model.addAttribute("store", store);
        return "search";
    }

}
