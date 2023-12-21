package kr.rene.template.sampledomain1.api.interfaces.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import kr.rene.template.sampledomain1.api.application.facade.UserAccountFacade;
import kr.rene.template.sampledomain1.api.interfaces.dto.UserAccountCreateRequest;
import lombok.RequiredArgsConstructor;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAccountController {

	private final UserAccountFacade userAccountFacade;

	@PutMapping("/object-mapper")
	@Operation(summary = "신규 유저 생성 - ojectMapper")
	public void saveWithObjectMapper(@RequestBody UserAccountCreateRequest userAccountCreateRequest){
		userAccountFacade.saveWithObjectMapper(userAccountCreateRequest);
	}

	@PutMapping("/model-mapper")
	@Operation(summary = "신규 유저 생성 - modelMapper")
	public void saveWithModelMapper(@RequestBody UserAccountCreateRequest userAccountCreateRequest){
		userAccountFacade.saveWithModelMapper(userAccountCreateRequest);
	}

	@PutMapping("/map-struct")
	@Operation(summary = "신규 유저 생성 - mapStruct")
	public void saveWithMapStruct(@RequestBody UserAccountCreateRequest userAccountCreateRequest){
		userAccountFacade.saveWithMapStruct(userAccountCreateRequest);
	}


	@PutMapping("/builder")
	@Operation(summary = "신규 유저 생성 - mapStruct")
	public void saveWithBuilder(@RequestBody UserAccountCreateRequest userAccountCreateRequest){
		userAccountFacade.saveWithBuilder(userAccountCreateRequest);
	}


}
