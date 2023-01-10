package didinet;

import didihttp.Interceptor;
import didihttp.Request;
import didihttp.Response;
import didinet.NetEngine;
import java.io.IOException;

public class ParamInterceptor implements Interceptor {

    /* renamed from: a */
    private static final String f59896a = "CityId";

    /* renamed from: b */
    private static final String f59897b = "Flowtag";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        NetEngine.ExternalParamGetter paramGetter = NetEngine.getInstance().getParamGetter();
        if (paramGetter != null) {
            Request.Builder newBuilder = request.newBuilder();
            NetEngine.ExternalParam onGetExternalParam = paramGetter.onGetExternalParam();
            if (onGetExternalParam != null) {
                if (onGetExternalParam.hasCityId()) {
                    newBuilder.removeHeader(f59896a);
                    newBuilder.addHeader(f59896a, String.valueOf(onGetExternalParam.getCityId()));
                }
                if (onGetExternalParam.hasFlowTag()) {
                    newBuilder.removeHeader(f59897b);
                    newBuilder.addHeader(f59897b, String.valueOf(onGetExternalParam.getFlowTag()));
                }
                return chain.proceed(newBuilder.build());
            }
        }
        return chain.proceed(request);
    }
}
