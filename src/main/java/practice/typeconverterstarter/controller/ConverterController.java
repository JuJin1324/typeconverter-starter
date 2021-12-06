package practice.typeconverterstarter.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.typeconverterstarter.type.IpPort;
import practice.typeconverterstarter.type.UserStatus;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/12/04
 */

@Controller
public class ConverterController {

    @GetMapping("/int")
    public String requestParamInt(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/boolean")
    public String requestParamBoolean(@RequestParam Boolean data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String requestParamIpPort(@RequestParam IpPort data) {
        System.out.println("ipPort.getIp() = " + data.getIp());
        System.out.println("ipPort.getPort() = " + data.getPort());
        return "ok";
    }

    @GetMapping("/user-status")
    public String requestParamUserStatus(@RequestParam UserStatus data) {
        System.out.println("userStatus = " + data);
        return "ok";
    }

    @GetMapping("/converter-view")
    public String converterView(Model model) {
        model.addAttribute("number", 10000);
        model.addAttribute("ipPort", new IpPort("127.0.0.1", 8080));
        return "converter-view";
    }

    @GetMapping("/converter/edit")
    public String converterForm(Model model) {
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        Form form = new Form(ipPort);
        model.addAttribute("form", form);

        return "converter-form";
    }

    @PostMapping("/converter/edit")
    public String converterEdit(@ModelAttribute Form form, Model model) {
        IpPort ipPort = form.getIpPort();
        model.addAttribute("ipPort", ipPort);

        return "converter-view";
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Form {
        private IpPort ipPort;
    }
}
