package com.kapitonau.projectstudio.bean.cache;

import com.kapitonau.commonspring.exception.CommonServiceException;
import com.kapitonau.projectstudio.bean.client.ReferenceItemApiClient;
import com.kapitonau.projectstudio.referenceservice.dto.ReferenceItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class InMemoryReferenceCache implements ReferenceCache {

    private static final Map<Long, ReferenceItemResponse> ID_CACHE = new HashMap<>();
    private static final Map<String, ReferenceItemResponse> REFERENCE_TYPE_ITEM_CODE_CACHE = new HashMap<>();

    private final ReferenceItemApiClient referenceItemApiClient;


    @Override
    public ReferenceItemResponse getReferenceItemById(Long id) {
        if (ID_CACHE.containsKey(id)) {
            return ID_CACHE.get(id);
        } else {
            ReferenceItemResponse referenceItemResponse = referenceItemApiClient.getReferenceItemById(id);
            ID_CACHE.put(id, referenceItemResponse);
            return referenceItemResponse;
        }
    }

    @Override
    public ReferenceItemResponse getReferenceItemByTypeAndCode(String referenceType, String itemCode) {
        if (REFERENCE_TYPE_ITEM_CODE_CACHE.containsKey(referenceType + "_" + itemCode)) {
            return REFERENCE_TYPE_ITEM_CODE_CACHE.get(referenceType + "_" + itemCode);
        } else {
            List<ReferenceItemResponse> referencesByTypeAndCode = referenceItemApiClient.getAllReferenceItems(referenceType, itemCode);
            if (!referencesByTypeAndCode.isEmpty()) {
                ReferenceItemResponse referenceItemResponse = referencesByTypeAndCode.get(0);
                REFERENCE_TYPE_ITEM_CODE_CACHE.put(referenceType + "_" + itemCode, referenceItemResponse);
                return referenceItemResponse;
            } else {
                throw new CommonServiceException("REFERENCE_SERVICE", "Reference item not found");
            }
        }
    }
}
