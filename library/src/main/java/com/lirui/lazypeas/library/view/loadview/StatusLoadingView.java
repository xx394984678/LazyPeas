package com.lirui.lazypeas.library.view.loadview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;

/**
 * Created by lirui on 2018/3/6.
 */

public class StatusLoadingView extends ImageView {
    private ObjectAnimator rotationAnimator;
    private Interpolator interpolator;

    public StatusLoadingView(Context context) {
        super(context);
    }

    public StatusLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        if (isVisible) {
            startAnimator();
        } else {
            stopAnimator();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rotationAnimator.end();
    }

    private void startAnimator() {
        if (getVisibility() != VISIBLE || getWindowVisibility() != VISIBLE) {
            return;
        }
        if (rotationAnimator != null && rotationAnimator.isRunning()) {
            return;
        }
        if (rotationAnimator == null) {
            rotationAnimator = ObjectAnimator.ofFloat(this, "rotation", 0f, 359f);
        }
        if (interpolator == null) {
            interpolator = new AccelerateDecelerateInterpolator();
        }
        rotationAnimator.setDuration(2000);
        rotationAnimator.setRepeatMode(ValueAnimator.RESTART);
        rotationAnimator.setInterpolator(interpolator);
        rotationAnimator.setRepeatCount(-1);
        rotationAnimator.start();
    }

    private void stopAnimator() {
        rotationAnimator.end();
    }
}
