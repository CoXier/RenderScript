package com.uniquestudio.renderscript.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;

import com.uniquestudio.renderscript.ScriptC_magnifier;

/**
 * Created by CoXier on 2016/8/12.
 */
public class MagnifierUtil {
    public static Bitmap magnifierBitmap(Bitmap bitmap, int x, int y, int radius,int scale, Context context){
        RenderScript rs = RenderScript.create(context);

        Allocation in = Allocation.createFromBitmap(rs, bitmap);
        Allocation out = Allocation.createTyped(rs,in.getType());


        ScriptC_magnifier magnifier = new ScriptC_magnifier(rs);

        magnifier.set_inputAllocation(in);
        magnifier.set_atX(x);
        magnifier.set_atY(y);
        magnifier.set_radius(radius);
        magnifier.set_scale(scale);


        magnifier.forEach_magnify(in,out);

        out.copyTo(bitmap);

        rs.destroy();
        magnifier.destroy();
        in.destroy();
        out.destroy();

        return bitmap;


    }
}
