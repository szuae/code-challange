package location.com.nearme.repository;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import location.com.nearme.BuildConfig;

public class ImageLoaderImpl implements ImageLoader {

    private interface PhotoServiceParameter {
        String ENDPOINT = "photo?";
        String KEY_PARAMETER = "key";
        String MAX_WIDTH = "maxwidth";
        String MAX_HEIGHT = "maxheight";
        String REFERENCE = "photoreference";
        String AMPERCENT = "&";
        String EQUAL = "=";
    }

    private static final String endpoint = "";

    @Override
    public void loadImage(ImageView imgView, Context context, String refrence, int height, int width) {
        Glide.with(context)
                .load(buildUrl(refrence, "" + width, "" + height))
                .centerCrop()
                .override(width, height)
                .into(imgView);
    }

    @Override
    public void initImageViewer(Context context) {
//        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
//                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
//                .setResizeAndRotateEnabledForNetwork(true)
//                .setDownsampleEnabled(true)
//                .build();
//        Fresco.initialize(this, config);
    }

    private String buildUrl(String reference, String width, String height) {
        return new StringBuilder()
                .append(BuildConfig.BaseURL)
                .append(PhotoServiceParameter.ENDPOINT)
                .append(PhotoServiceParameter.KEY_PARAMETER)
                .append(PhotoServiceParameter.EQUAL)
                .append(BuildConfig.secret_key)
                .append(PhotoServiceParameter.AMPERCENT)
                .append(PhotoServiceParameter.REFERENCE)
                .append(PhotoServiceParameter.EQUAL)
                .append(reference)
                .append(PhotoServiceParameter.AMPERCENT)
                .append(PhotoServiceParameter.MAX_WIDTH)
                .append(PhotoServiceParameter.EQUAL)
                .append(width)
                .append(PhotoServiceParameter.AMPERCENT)
                .append(PhotoServiceParameter.MAX_HEIGHT)
                .append(PhotoServiceParameter.EQUAL)
                .append(height).toString();
    }

}
