package powerwaveinteractive.com.seoulture.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yeonhuikim on 2014. 9. 9..
 */
public class BarChartView extends View{
    int _numElements = 0;
    int[] _elements;

    public BarChartView(Context context) {
        super(context);
    }

    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BarChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(int numElements , int[] elements)
    {
        _numElements = numElements;
        _elements = elements;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        int circleCol = Color.RED, labelCol = Color.BLUE;
        Paint circlePaint = new Paint();
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);
        circlePaint.setColor(labelCol);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(30);

        int[] colors = {Color.parseColor("#9FC05A"), Color.parseColor("#ADD633"), Color.parseColor("#FFD834"),
        Color.parseColor("#FFB234"), Color.parseColor("#FF8B5A")};
        int colorsCount = colors.length;

        int max = 1;
        for (int i = 0; i < _numElements; i++) {
            if (max < _elements[i]) max = _elements[i];
        }

        int barHeight = (this.getMeasuredHeight()) / _numElements;
        int maxBarWidth = this.getMeasuredWidth();
        Rect rect = new Rect(0,0,100,barHeight);
        for (int i = 1; i <= _numElements; i++) {
            circlePaint.setColor(colors[i%colorsCount]);
            rect.right = maxBarWidth * _elements[i]/max;
            canvas.drawRect(rect, circlePaint);
            rect.top += barHeight;rect.bottom += barHeight;
        }

    }
}
