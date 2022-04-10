package com.bp.msdevops.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.msdevops.domain.enumeration.EstadoApiResponseEnum;
import com.bp.msdevops.domain.enumeration.EstadoErrorEnum;
import com.bp.msdevops.domain.exception.ManejoExcepciones;
import com.bp.msdevops.domain.service.DevOpsService;
import com.bp.msdevops.dto.ApiResponse;
import com.bp.msdevops.payload.DevOpsPayload;

@RestController
@RequestMapping("/DevOps")
public class DevOpsController {

	private ManejoExcepciones manejoExcepciones = new ManejoExcepciones(this.getClass().getName());

	@Autowired
	private DevOpsService devOpsService;

    @PostMapping()
    public ApiResponse sendMessage(@RequestBody DevOpsPayload payload) {
		try {
            return new ApiResponse(EstadoApiResponseEnum.OK.getCode(),
				devOpsService.sendMessage(payload));
        } catch (Exception e) {
            return manejoExcepciones.registraLogExcepcionRest(e, EstadoErrorEnum.EJECUCION.getCode());
        }
    }

    @GetMapping()
    public String sendMessageErrorGet() {
        return "ERROR";
    }

    @PutMapping()
    public String sendMessageErrorPut() {
        return "ERROR";
    }

    @DeleteMapping()
    public String sendMessageErrorDelete() {
        return "ERROR";
    }
}