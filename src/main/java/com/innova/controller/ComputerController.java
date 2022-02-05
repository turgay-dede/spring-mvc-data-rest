package com.innova.controller;

import com.innova.entity.ComputerEntity;
import com.innova.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.Optional;

@Controller
public class ComputerController {
    @Autowired
    ComputerRepository computerRepository;

    @GetMapping("/computer/create")
    @ResponseBody
    public String getCreateComputer(){
        ComputerEntity computer = ComputerEntity.builder()
                .computerId(0L)
                .computerName("ComputerName28")
                .computerTrade("computerTrade28")
                .computerPrice("computerPrice28")
                .build();
        computerRepository.save(computer);
        return "Ekleme basarili";
    }

    @GetMapping("/computer/create2")
    @ResponseBody
    public String getCreateComputer2(
            @RequestParam(name = "computer_name") String computerName,
            @RequestParam(name = "computer_trade") String computerTrade,
            @RequestParam(name = "computer_price") String computerPrice
    ){
        ComputerEntity computer = ComputerEntity.builder()
                .computerId(0L)
                .computerName(computerName)
                .computerTrade(computerTrade)
                .computerPrice(computerPrice)
                .build();
        computerRepository.save(computer);
        return "Ekleme basarili";
    }

    @GetMapping("/computer/find/{id}")
    @ResponseBody
    public String getFindComputer(@PathVariable(name = "id") Long id){
        Optional<ComputerEntity> optional = computerRepository.findById(id);
        if(optional.isPresent()){
            ComputerEntity computer = optional.get();
            return "bulundu: "+computer;
        }
        return "Data bulunamadi";
    }

    @GetMapping("/computer/delete/{id}")
    @ResponseBody
    public String getDeleteComputer(@PathVariable(name = "id") Long id){
        Optional<ComputerEntity> optional = computerRepository.findById(id);
        if(optional.isPresent()){
            ComputerEntity computer = optional.get();
            computerRepository.deleteById(id);
            return "Silindi: "+computer;
        }
        return "Data bulunamadi";
    }

    @GetMapping("/computer/update/{id}")
    @ResponseBody
    public String getUpdateComputer(
            @PathVariable(name="id")  Long idim,
            @RequestParam(name="computer_name") String computerName,
            @RequestParam(name="computer_trade") String computerTrade,
            @RequestParam(name="computer_price") String computerPrice
    ){
        Optional<ComputerEntity> optional=computerRepository.findById(idim);
        if(optional.isPresent()){
            ComputerEntity computerEntity2= optional.get();
            computerEntity2.setComputerName(computerName);
            computerEntity2.setComputerTrade(computerTrade);
            computerEntity2.setComputerPrice(computerPrice);
            computerRepository.save(computerEntity2);
            return "Güncelleme yapıldı "+computerEntity2;
        }else{
            return " data bulunamadı ve güncellenemedi !!! ";
        }
    }
}
