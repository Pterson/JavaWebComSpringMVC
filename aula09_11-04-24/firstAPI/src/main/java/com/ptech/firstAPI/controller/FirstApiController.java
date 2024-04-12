package com.ptech.firstAPI.controller;

import com.ptech.firstAPI.model.FirstApiPost;
import com.ptech.firstAPI.repository.FirstApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstApiController {

        @Autowired
        FirstApiRepository firstApiRepository;
        @GetMapping("/recebeDadosApi")
        public String exibirMinhaApi() {

                return "Funcionou";
        }

        @PostMapping("/enviaDadosApi")
        public String enviarParaApi(@RequestBody FirstApiPost firstApiPost) {

                firstApiRepository.save(firstApiPost);

                return "o texto enviado: " + firstApiPost.getMeuTexto();
        }

}
