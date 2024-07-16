package com.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class MyMainController {
    @Autowired private UserService userService;

    @GetMapping("/login")
    public void getLogin() {
    }

    @GetMapping("/home")
    public void getHome(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.odcloud.kr/api/15109950/v1/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4?page=2&perPage=10&serviceKey=WX/qIsVj4inhHOXPUgOGfxI7MQh1LIHyhfli2ch1DGUWsG37xoDDh724K5F05MzVG2OQJuigRzUq63r/nTMfRg==";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map resultMap = response.getBody();
        List dataList = (List) resultMap.get("data");
        model.addAttribute("dataList", dataList);
    }

    @GetMapping("/admin")
    public void getAdmin(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.odcloud.kr/api/15109950/v1/uddi:1f78fe49-78b4-4784-a5f0-e2c8a60515b4?page=2&perPage=10&serviceKey=WX/qIsVj4inhHOXPUgOGfxI7MQh1LIHyhfli2ch1DGUWsG37xoDDh724K5F05MzVG2OQJuigRzUq63r/nTMfRg==";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map resultMap = response.getBody();
        List dataList = (List) resultMap.get("data");
        model.addAttribute("dataList", dataList);
    }

    @PostMapping("/login")
    public String login(String id, String password, HttpSession session) {
        UserDTO user = userService.getUserById(id);
        if(Objects.equals(user.getId(), "admin") && user.getPassword().equals("admin")) {
            session.setAttribute("admin", user);
            return "redirect:/admin";
        }
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/home";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
