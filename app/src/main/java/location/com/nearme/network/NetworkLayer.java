package location.com.nearme.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import location.com.nearme.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkLayer {

    /**
     * @param service Retrofit interface class to be instantiated
     * @param <T>     Service type
     * @return Retrofit service.
     */
    public <T> T createApiService(@NonNull final Class<T> classOf) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.BaseURL)
                .client(new OkHttpClient.Builder()
                        .readTimeout(1, TimeUnit.MINUTES)
                        .addInterceptor(new HttpLoggingInterceptor())
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .build())
                .build()
                .create(classOf);
    }
}
