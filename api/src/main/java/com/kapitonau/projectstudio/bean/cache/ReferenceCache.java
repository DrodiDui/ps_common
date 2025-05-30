package com.kapitonau.projectstudio.bean.cache;

import com.kapitonau.projectstudio.referenceservice.dto.ReferenceItemResponse;

public interface ReferenceCache {

    ReferenceItemResponse getReferenceItemById(Long id);

    ReferenceItemResponse getReferenceItemByTypeAndCode(String referenceType, String itemCode);

}
