package com.kapitonau.projectstudio.referenceservice.dto;

public record ReferenceItemResponse(
        Long referenceItemId,
        String referenceType,
        String itemCode,
        String description
) {
}
