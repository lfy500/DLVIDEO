package com.example.lfy.dlvideo.guide;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.livecloud.live.AlivcMediaFormat;
import com.example.lfy.dlvideo.R;
import com.example.lfy.dlvideo.utils.ToastUtils;

public class GuideInto extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    //    private EditText urlET;
    private Button connectBT;
    private Button bubblingView;
    private RadioGroup resolutionCB;
    private RadioButton resolution240button;
    private RadioButton resolution360button;
    private RadioButton resolution480button;
    private RadioButton resolution540button;
    private RadioButton resolution720button;
    private RadioGroup rotationGroup;
    private RadioButton screenOrientation1;
    private RadioButton screenOrientation2;
    private CheckBox frontCameraMirror;
    private String rtmp = "rtmp://video-center.alivecdn.com/AppName/StreamName?vhost=zhibo.yixian8.com&auth_key=1470925985-0-0-da25208c45bf805dc54794451840729d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_into);

        connectBT = (Button) findViewById(R.id.connectBT);
        connectBT.setOnClickListener(this);
        bubblingView = (Button) findViewById(R.id.bubbling_view);
        bubblingView.setOnClickListener(this);
//        urlET = (EditText) findViewById(R.id.rtmpUrl);
        resolutionCB = (RadioGroup) findViewById(R.id.resolution_group);
        resolution240button = (RadioButton) findViewById(R.id.radiobutton0);
        resolution360button = (RadioButton) findViewById(R.id.radiobutton1);
        resolution480button = (RadioButton) findViewById(R.id.radiobutton2);
        resolution540button = (RadioButton) findViewById(R.id.radiobutton3);
        resolution720button = (RadioButton) findViewById(R.id.radiobutton4);
        rotationGroup = (RadioGroup) findViewById(R.id.rotation_group);
        screenOrientation1 = (RadioButton) findViewById(R.id.screenOrientation1);
        screenOrientation2 = (RadioButton) findViewById(R.id.screenOrientation2);
        frontCameraMirror = (CheckBox) findViewById(R.id.front_camera_mirror);
        resolutionCB.setOnCheckedChangeListener(this);
        rotationGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.connectBT:
                int videoResolution = 0;
                int cameraFrontFacing = 0;
                boolean screenOrientation = false;
                if (resolution240button.isChecked()) {
                    videoResolution = AlivcMediaFormat.OUTPUT_RESOLUTION_240P;
                } else if (resolution360button.isChecked()) {
                    videoResolution = AlivcMediaFormat.OUTPUT_RESOLUTION_360P;
                } else if (resolution480button.isChecked()) {
                    videoResolution = AlivcMediaFormat.OUTPUT_RESOLUTION_480P;
                } else if (resolution540button.isChecked()) {
                    videoResolution = AlivcMediaFormat.OUTPUT_RESOLUTION_540P;
                } else if (resolution720button.isChecked()) {
                    videoResolution = AlivcMediaFormat.OUTPUT_RESOLUTION_720P;
                }
                if (frontCameraMirror.isChecked()) {
                    cameraFrontFacing = AlivcMediaFormat.CAMERA_FACING_FRONT;
                } else {
                    cameraFrontFacing = AlivcMediaFormat.CAMERA_FACING_BACK;
                }

                if (screenOrientation1.isChecked()) {
                    screenOrientation = true;
                } else {
                    screenOrientation = false;
                }

                if (TextUtils.isEmpty(rtmp)) {
                    ToastUtils.showToast(v.getContext(), "Push url is null");
                    return;
                }
                LiveCameraActivity.startActivity(v.getContext(), rtmp, videoResolution, screenOrientation, cameraFrontFacing);

                break;
            case R.id.bubbling_view:

                BubblingAnimationActivity.startActivity(v.getContext());

                break;
        }
    }
}
