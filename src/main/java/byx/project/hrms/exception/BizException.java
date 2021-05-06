package byx.project.hrms.exception;

import byx.project.hrms.common.Status;

/**
 * 业务逻辑异常
 *
 * @author byx
 */
public class BizException extends RuntimeException {
    private final Status status;
    private final Object data;

    public BizException(Status status, Object data) {
        super(status.getMsg());
        this.status = status;
        this.data = data;
    }

    public BizException(Status status) {
        super(status.getMsg());
        this.status = status;
        this.data = null;
    }

    public Status getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }
}
