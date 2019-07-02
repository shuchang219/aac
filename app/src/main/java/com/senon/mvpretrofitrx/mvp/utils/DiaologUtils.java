package com.senon.mvpretrofitrx.mvp.utils;

import android.app.Dialog;
import android.content.Context;

public class DiaologUtils {
    public interface ClickDialog {
        /**
         * 对话框按钮点击回调
         * @param tag
         */
        void onButtonClicked(Dialog dialog, Object tag);

        /**
         * 当对话框消失的时候回调
         *
         * @param tag
         */
        void onCancelDialog(Dialog dialog, Object tag);
    }

    /**
     * 清除緩存
     * @param context
     * @param clickDialog
     */
    public static void clearCachDialog(Context context, final ClickDialog clickDialog){
//        final Dialog dialog = new Dialog(context, R.style.DialogNoTitleStyleTranslucentBg);
//        View contentView = LayoutInflater.from(context).inflate(R.layout.clearcach, null);
//        dialog.setCanceledOnTouchOutside(false);
////		dialog.setCancelable(isCanCancelabel);
//        dialog.setContentView(contentView);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setGravity(Gravity.CENTER);
//        dialog.show();
//        TextView hcun_tv = contentView.findViewById(R.id.hcun_tv);
//        ImageView close_iv = contentView.findViewById(R.id.close_iv);
//        Button sure_btn =  contentView.findViewById(R.id.sure_btn);
//
//        try {
//            hcun_tv.setText(CleanDataUtils.getTotalCacheSize(context));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        sure_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickDialog.onButtonClicked(dialog,null);
//            }
//        });
//
//
//        close_iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        dialog.setCancelable(false);
    }

}
