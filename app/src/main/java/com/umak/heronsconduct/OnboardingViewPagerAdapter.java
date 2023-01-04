package com.umak.heronsconduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class OnboardingViewPagerAdapter extends PagerAdapter {

    Context context;

    int images[]={
            R.drawable.onboarding1,
            R.drawable.onboarding2,
            R.drawable.onboarding3,
            R.drawable.onboarding4

    };

    int heading[]={

            R.string.heading_1,
            R.string.heading_2,
            R.string.heading_3,
            R.string.heading_4

    };

    int description[]={

            R.string.desc_1,
            R.string.desc_2,
            R.string.desc_3,
            R.string.desc_4

    };

    public OnboardingViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (LinearLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.onboarding_slider_layout, container, false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeading = (TextView) view.findViewById(R.id.texttitle);
        TextView slideDesciption = (TextView) view.findViewById(R.id.textdeccription);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(heading[position]);
        slideDesciption.setText(description[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }

}
