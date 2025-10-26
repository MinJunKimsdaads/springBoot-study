package hello.hello_spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello");
        return "hello";
    }
    @GetMapping("mvc-pattern")
    public String mvcPattern(@RequestParam("data") String data,Model model) {
        model.addAttribute("data",data);
        return "mvcPattern";
    }
    @GetMapping("api-test")
    @ResponseBody
    public APITest apiTest(@RequestParam("data") String data) {
        APITest apiTest = new APITest();
        apiTest.setData(data);
        return apiTest;
    }

    static class APITest {
        private String data;
        
        public String getData(){
            return data;
        }

        public void setData(String data){
            this.data = data;
        }
    }
}