package com.accumulate.service.authentication;

import com.accumulate.dto.authentication.AuthResult;
import com.accumulate.dto.authentication.AuthResultType;
import com.accumulate.entity.UserEntity;

public abstract class AbstractAuthenticator<T extends Credential> {

	/**
	 * @param credential
	 *            用户凭证
	 * @return 如果凭证无法找到用户则返回null
	 */
	protected abstract UserEntity exchangeByCredential(T credential);


	public final AuthResult auth(T credential) {
		AuthResult result = AuthResult.build();

		// 使用凭证查询用户
		UserEntity user = exchangeByCredential(credential);

		// 用户是否存在
		if (user == null) {
			result.setSuccess(false);
			result.setType(AuthResultType.NOT_EXIST);
			return result;
		}

		// 检查用户合法性
		//result.type = userValidService.checkUser(user, credential);
		return result;
	}


}
