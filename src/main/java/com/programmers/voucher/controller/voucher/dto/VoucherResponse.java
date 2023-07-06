package com.programmers.voucher.controller.voucher.dto;

import com.programmers.voucher.entity.voucher.Voucher;
import com.programmers.voucher.view.dto.VoucherType;

import java.util.UUID;

public record VoucherResponse(
        UUID voucherId,
        VoucherType voucherType,
        int amount
) {
    public static VoucherResponse from(Voucher voucher) {
        return new VoucherResponse(voucher.getId(), voucher.getType(), voucher.getAmount());
    }

    @Override
    public String toString() {
        return switch (voucherType) {
            case FIXED_AMOUNT -> String.format("[%s] %d discount voucher", voucherId, amount);
            case PERCENT_DISCOUNT -> String.format("[%s] %d%% discount voucher", voucherId, amount);
        };
    }
}
