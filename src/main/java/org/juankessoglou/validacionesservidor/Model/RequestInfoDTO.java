package org.juankessoglou.validacionesservidor.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestInfoDTO {
    private String clientIp;
    private String userAgent;
    private String operatingSystem;
    private String renderingEngine;
    private String remoteHost;
    private String preferredLanguage;
    private String locale;
}
