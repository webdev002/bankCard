package uz.pdp.bankcardproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

import java.util.UUID;

public class KimYozganiniQaytaradigan {
    @Bean
    AuditorAware<UUID> auditorAware(){
        return new  KimYozganiniBilish();
    }
}
