package com.project.krisi.alibaba.activities;

/**
 * Created by Krisi on 22.10.2017 г..
 */

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.OverScroller;

public class OnSwipeTouchListener implements OnTouchListener {

//    private RectF mCurrentViewport =
//            new RectF(AXIS_X_MIN, AXIS_Y_MIN, AXIS_X_MAX, AXIS_Y_MAX);

    // The current destination rectangle (in pixel coordinates) into which the
// chart data should be drawn.
    private Rect mContentRect;

    private OverScroller mScroller;
    private RectF mScrollerStartViewport;

    private final GestureDetector gestureDetector;
    private Context context;

    /* (non-Javadoc)
     * @see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
     */
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    /**
     * Gets the gesture detector.
     *
     * @return the gesture detector
     */
    public GestureDetector getGestureDetector(){
        return  gestureDetector;
    }

    /**
     * Instantiates a new on swipe touch listener.
     *
     * @param context
     *            the context
     */
    public OnSwipeTouchListener(Context context) {
        super();
        this.context = context;
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        /* (non-Javadoc)
         * @see android.view.GestureDetector.SimpleOnGestureListener#onDown(android.view.MotionEvent)
         */
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

    /* (non-Javadoc)
     * @see android.view.GestureDetector.SimpleOnGestureListener#onFling(android.view.MotionEvent, android.view.MotionEvent, float, float)
     */

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getRawY() - e1.getRawY();
                float diffX = e2.getRawX() - e1.getRawX();
                if ((Math.abs(diffX) - Math.abs(diffY)) > SWIPE_THRESHOLD) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeBottom(velocityX, velocityY);
                        } else {
                            onSwipeTop();
                        }
                    }
                }
            } catch (Exception e) {

            }
            return result;
        }
    }

    /**
     * On swipe right.
     */
    public void onSwipeRight() {
    }

    /**
     * On swipe left.
     */
    public void onSwipeLeft() {
    }

    /**
     * On swipe top.
     */
    public void onSwipeTop() {
    }

    /**
     * On swipe bottom.
     */
    public void onSwipeBottom(float velocityX, float velocityY) {
//        releaseEdgeEffects();
//        // Flings use math in pixels (as opposed to math based on the viewport).
//        Point surfaceSize = computeScrollSurfaceSize();
//        mScrollerStartViewport.set(mCurrentViewport);
//        int startX = (int) (surfaceSize.x * (mScrollerStartViewport.left -
//                AXIS_X_MIN) / (
//                AXIS_X_MAX - AXIS_X_MIN));
//        int startY = (int) (surfaceSize.y * (AXIS_Y_MAX -
//                mScrollerStartViewport.bottom) / (
//                AXIS_Y_MAX - AXIS_Y_MIN));
//        // Before flinging, aborts the current animation.
//        mScroller.forceFinished(true);
//        // Begins the animation
//        mScroller.fling(
//                // Current scroll position
//                startX,
//                startY,
//                velocityX,
//                velocityY,
//            /*
//             * Minimum and maximum scroll positions. The minimum scroll
//             * position is generally zero and the maximum scroll position
//             * is generally the content size less the screen size. So if the
//             * content width is 1000 pixels and the screen width is 200
//             * pixels, the maximum scroll offset should be 800 pixels.
//             */
//                0, surfaceSize.x - mContentRect.width(),
//                0, surfaceSize.y - mContentRect.height(),
//                // The edges of the content. This comes into play when using
//                // the EdgeEffect class to draw "glow" overlays.
//                mContentRect.width() / 2,
//                mContentRect.height() / 2);
//        // Invalidates to trigger computeScroll()
//        ViewCompat.postInvalidateOnAnimation(this);
    }
}
