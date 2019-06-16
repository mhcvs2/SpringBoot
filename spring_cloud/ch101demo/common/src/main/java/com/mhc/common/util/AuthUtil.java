package com.mhc.common.util;

import com.mhc.common.vo.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

public class AuthUtil {
	public static boolean authUser(User user, HttpServletResponse respone) throws Exception{
		if(StringUtils.isEmpty(user.getUserId())) {
			return false;
		}else {
			return true;
		}
	}
}
