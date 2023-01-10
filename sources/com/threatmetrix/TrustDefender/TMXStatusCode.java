package com.threatmetrix.TrustDefender;

public enum TMXStatusCode {
    TMX_NotYet("Not Yet", "TMXProfile request has started successfully but has not completed"),
    TMX_OK("Okay", "Completed, No errors"),
    TMX_Connection_Error("Connection Error", "There was a connection issue, profiling aborted"),
    TMX_HostNotFound_Error("Host Not Found", "Unable to resolve the host name"),
    TMX_NetworkTimeout_Error("Network Timeout", "Communications layer timed out"),
    TMX_Internal_Error("Internal Error", "Internal Error, profiling incomplete or interrupted"),
    TMX_HostVerification_Error("Host Verification Error", "Certificate verification failure! Potential MITM attack"),
    TMX_Interrupted_Error("Interrupted", "Request was cancelled"),
    TMX_ConfigurationError("Configuration Error", "Failed to retrieve configuration from server"),
    TMX_PartialProfile("Partial TMXProfile", "Connection error, only partial profile completed"),
    TMX_Blocked("Profiling is blocked", "Profiling is blocked.(Screen is off)"),
    TMX_EndNotifier_NotFound("TMXEndNotifier not found", "TMXEndNotifier is mandatory in profile request"),
    TMX_In_Quiet_Period("In Quiet Period", "Profiling is blocked (In Quiet Period)"),
    TMX_Certificate_Mismatch("Certificate Mismatch", "The pinned certificate does not match the server's certificate"),
    TMX_StrongAuth_Failed("Registration / Stepup failed", "System has rejected Registration / Stepup attempt"),
    TMX_StrongAuth_Cancelled("Registration / Stepup was cancelled", "User has chosen not to proceed with Registration / Stepup"),
    TMX_StrongAuth_Unsupported("Strong Auth Method Unsupported", "Hardware/OS does not support this functionality."),
    TMX_StrongAuth_UserNotFound("User context not found", "User context is not registered on the device, Stepup failed"),
    TMX_StrongAuth_AlreadyRegistered("User context already registered ", "User context is already registered on the device, Registration failed"),
    TMX_CertificateError("Certificate Error", "This exception indicates one of a variety of certificate problems"),
    TMX_CertificateEncodingError("Certificate Encoding Error", "Certificate Encoding Exception"),
    TMX_CertificateExpired("Certificate Expired", "Certificate Expired Exception"),
    TMX_CertificateNotYetValid("Certificate is not yet valid", "Certificate is not yet valid exception"),
    TMX_CertificateParsingError("Certificate Parsing Error", "Certificate Parsing Exception"),
    TMX_CertPathBuilderError("Certificate Path Build Error", "An exception indicating one of a variety of problems encountered when building a certification path with a CertPathBuilder"),
    TMX_CertPathValidatorError("Certificate Path Validator Error", "An exception indicating one of a variety of problems encountered when validating a certification path"),
    TMX_CertStoreError("Certificate Store Error", "An exception indicating one of a variety of problems retrieving certificates and CRLs from a CertStore"),
    TMX_CRLError("CRL Error", "Certificate Revocation List Exception"),
    TMX_ProfileTimeout_Error("TMXProfile Timeout", "Profiling timed out");
    
    private final String b0064dd00640064d;
    private final String bddd00640064d;

    private TMXStatusCode(String str, String str2) {
        this.bddd00640064d = str;
        this.b0064dd00640064d = str2;
    }

    public String getDesc() {
        return this.b0064dd00640064d;
    }

    public String toString() {
        return this.bddd00640064d;
    }
}
