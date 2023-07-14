package com.programmers.voucher.exception;

import com.programmers.voucher.constant.ErrorCode;

public class InvalidCommandException extends IllegalArgumentException {
    public InvalidCommandException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
