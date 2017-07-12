package cn.sky.framework.cxf.interceptor;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptor;

public interface AccessOutInterceptor<T extends Message> extends PhaseInterceptor<T> {

}
