package com.bp.msdevops.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.msdevops.dto.ApiResponseDTO;
import com.bp.msdevops.enumeration.EstadoApiResponseEnum;
import com.bp.msdevops.enumeration.EstadoErrorEnum;
import com.bp.msdevops.exception.ManejoExcepciones;
import com.bp.msdevops.payload.DevOpsPayload;
import com.bp.msdevops.service.DevOpsService;

@RestController
@RequestMapping("/DevOps")
public class DevOpsController {

	private ManejoExcepciones manejoExcepciones = new ManejoExcepciones(this.getClass().getName());

	@Autowired
	private DevOpsService devOpsService;

    @PostMapping()
    public ApiResponseDTO sendMessage(@RequestBody DevOpsPayload payload) {
		try {
            return new ApiResponseDTO(EstadoApiResponseEnum.OK.getCode(),
				devOpsService.sendMessage(payload));
        } catch (Exception e) {
            return manejoExcepciones.registraLogExcepcionRest(e, EstadoErrorEnum.EJECUCION.getCode());
        }
    }

    @GetMapping()
    public String sendMessageErrorGet() {
        return EstadoApiResponseEnum.ERROR.getCode();
    }

    @PutMapping()
    public String sendMessageErrorPut() {
        return EstadoApiResponseEnum.ERROR.getCode();
    }

    @DeleteMapping()
    public String sendMessageErrorDelete() {
        return EstadoApiResponseEnum.ERROR.getCode();
    }
}