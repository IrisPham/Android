package com.example.visualstudio.simpleactivity.demoservice.object;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;

/**
 * Created by Visual Studio on 7/9/2017.
 * Class làm nhiệm vụ hiển thị giá trị cho Progressbar
 */

public class ShowPrgessBarTask extends AsyncTask<Integer,Integer,Integer> {
    private ProgressBar progressBar;
    private TextView tvPercent;
    private ButtonRectangle btnStartIntentService;

    public ShowPrgessBarTask(ProgressBar progressBar, TextView tvPercent, ButtonRectangle btnStartIntentService) {
        this.progressBar = progressBar;
        this.tvPercent = tvPercent;
        this.btnStartIntentService = btnStartIntentService;
    }

    @Override
    protected Integer doInBackground(Integer... agrs) {
        return agrs[0];
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        progressBar.setProgress(result);
        tvPercent.setText(result + " % Loaded");
        if (result == 100) {
            tvPercent.setText("Completed");
            btnStartIntentService.setEnabled(true);
        }

    }
}