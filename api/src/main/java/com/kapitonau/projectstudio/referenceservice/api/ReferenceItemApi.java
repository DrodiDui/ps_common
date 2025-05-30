package com.kapitonau.projectstudio.referenceservice.api;

import com.kapitonau.projectstudio.referenceservice.dto.ReferenceItemResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReferenceItemApi {

    @GetMapping("/references/items/{referenceItemId}")
    ReferenceItemResponse getReferenceItemById(@PathVariable(name = "referenceItemId") Long referenceItemId);

    @GetMapping("/references/items")
    List<ReferenceItemResponse> getAllReferenceItems(
            @RequestParam("referenceType") String referenceType,
            @RequestParam(name = "itemCode", required = false) String itemCode
    );

}
