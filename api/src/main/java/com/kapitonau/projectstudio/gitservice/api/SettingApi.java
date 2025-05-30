package com.kapitonau.projectstudio.gitservice.api;

import com.kapitonau.projectstudio.gitservice.dto.setting.SettingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SettingApi {

    @GetMapping("/settings/${settingId}")
    SettingResponse getSetting(@PathVariable(name = "settingId") Long settingId);

    @GetMapping("/settings/repository/{repositoryId}")
    List<SettingResponse> getSettings(@PathVariable(name = "repositoryId") Long repositoryId);

}
