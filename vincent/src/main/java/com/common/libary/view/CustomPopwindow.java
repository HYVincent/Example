package com.common.libary.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.common.libary.util.SystemUtil;
import com.vincent.libary.R;


/**
 * Created by Vincent on 2016/11/5.
 */

public class CustomPopwindow extends PopupWindow {
    private View mView;
    public CustomPopwindow(Activity context, View.OnClickListener itemsOnClick){
        super(context);
        initView(context,itemsOnClick);
    }

    private void initView(final Activity context, View.OnClickListener itemsOnClick) {
        // TODO Auto-generated method stub
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mInflater.inflate(R.layout.act_choose_img,null);
        LinearLayout ll_select01 = (LinearLayout) mView.findViewById(R.id.ll_select01);
        LinearLayout ll_select02 = (LinearLayout) mView.findViewById(R.id.ll_select02);
        LinearLayout ll_select03 = (LinearLayout) mView.findViewById(R.id.ll_select03);
        //取消按钮
        /*ll_select03.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //销毁弹出框
                dismiss();
                backgroundAlpha(context, 1f);
            }
        });*/
        ll_select03.setOnClickListener(itemsOnClick);
        //设置按钮监听
        ll_select01.setOnClickListener(itemsOnClick);
        ll_select02.setOnClickListener(itemsOnClick);
        //设置SelectPicPopupWindow的View
        this.setContentView(mView);
        //设置SelectPicPopupWindow弹出窗体的宽
//        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(Integer.valueOf(SystemUtil.getScreenParameterWidth(context))/5*4);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置PopupWindow可触摸
        this.setTouchable(true);
        //设置非PopupWindow区域是否可触摸
//        this.setOutsideTouchable(false);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.select_anim);
        this.setOutsideTouchable(false);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        backgroundAlpha(context,0.5f);//0.0-1.0
        this.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                // TODO Auto-generated method stub
                backgroundAlpha(context, 1f);
            }
        });
    }
    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public static void backgroundAlpha(Activity context, float bgAlpha)
    {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

}
