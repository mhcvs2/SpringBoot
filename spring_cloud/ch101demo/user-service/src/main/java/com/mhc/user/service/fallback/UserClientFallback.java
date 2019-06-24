package com.mhc.user.service.fallback;

import com.mhc.user.service.dataservice.DataService;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements DataService {

    @Override
    public String getDefaultUser() {
        return "getDefaultUser failed";
    }

    @Override
    public String getContextUserId() {
        return "getContextUserId failed";
    }
}
