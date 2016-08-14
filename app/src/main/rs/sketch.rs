#pragma version(1)
#pragma rs_fp_relaxed
#pragma rs java_package_name(com.uniquestudio.renderscript)



uchar4 __attribute__((kernel)) invert(uchar4 in, uint32_t x, uint32_t y) {
   //Convert input uchar4 to float4
   float4 f4 = rsUnpackColor8888(in);

   float r = f4.r;
   float g = f4.g;
   float b = f4.b;

   if((r+g+b)*255/3>=100){
       return rsPackColorTo8888(1, 1, 1, f4.a);
   }else{
       return rsPackColorTo8888(0, 0, 0, f4.a);
   }
}