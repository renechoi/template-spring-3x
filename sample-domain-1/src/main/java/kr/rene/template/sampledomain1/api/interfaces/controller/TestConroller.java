package kr.rene.template.sampledomain1.api.interfaces.controller;

import static kr.rene.template.sampledomain1.common.model.api.CommonApiResponse.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.rene.template.sampledomain1.common.model.api.CommonApiResponse;

/**
 * @author : Rene Choi
 * @since : 2023/12/19
 */
@RestController
@RequestMapping("/test")
public class TestConroller {

	@GetMapping
	public CommonApiResponse<Void> test(){
		return OK();
	}
}
