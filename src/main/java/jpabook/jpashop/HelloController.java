package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    public String hello(Model model) {
        model.addAttribute("data", "hello!!!"); //key,value
        return "hello"; //resource 템플릿을 반환 html을 안붙여도됨

    }  //model이라는 view에 값을 넘길 수 있다.
}
