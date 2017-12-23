package location.com.nearme.repository;


import android.content.Context;
import android.widget.ImageView;

public interface ImageLoader {
    void loadImage(ImageView imgView, Context context, String url, int height, int width);

    void initImageViewer(Context context);
}
