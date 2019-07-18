import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.customview.R;

public class CircleWithTextView extends View {
    private int circleColor, textColor; //circle and text color
    private String text;// text

    public CircleWithTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.custom_attributes, 0, 0);
        try {
//get the text and colors specified using the names in attrs.xml
            text = a.getString(R.styleable.custom_attributes_circleView_text);
            textColor = a.getInteger(R.styleable.custom_attributes_circleView_textColor, 0);
            circleColor = a.getInteger(R.styleable.custom_attributes_circleView_circleColor, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;
        int radius = 0;
        if (viewWidthHalf > viewHeightHalf)
            radius = viewHeightHalf
                    -
                    10;
        else
            radius = viewWidthHalf
                    -
                    10;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(circleColor);
        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, paint);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(50);
        canvas.drawText(text, viewWidthHalf, viewHeightHalf, paint);
    }
}