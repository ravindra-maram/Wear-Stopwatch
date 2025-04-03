package com.example.ravindrareddymaramassignment1;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Chronometer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.ravindrareddymaramassignment1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Chronometer.OnChronometerTickListener {
    private ActivityMainBinding binding;
    private boolean isStarted = false; // Tracks if stopwatch is running
    private long isPaused = 0; // Tracks elapsed time when paused

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Apply fade-in animation to Chronometer
        animateChronometer();

        // Set the listener for the chronometer
        binding.chronometer.setOnChronometerTickListener(this);

        // Set up button click listeners
        binding.startButton.setOnClickListener(v -> startStopwatch());
        binding.stopButton.setOnClickListener(v -> stopStopwatch());
        binding.resetButton.setOnClickListener(v -> resetStopwatch());

        // Set initial button states
        updateButtonStates(true, false, false);
    }

    /**
     * Implements the onChronometerTick method from the OnChronometerTickListener interface.
     */
    @Override
    public void onChronometerTick(Chronometer chronometer) {
        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        long seconds = (elapsedMillis / 1000) % 60;
        long minutes = (elapsedMillis / (1000 * 60)) % 60;
        long hours = (elapsedMillis / (1000 * 60 * 60));
        chronometer.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    /**
     * Animates the Chronometer when the app starts.
     */
    private void animateChronometer() {
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(binding.chronometer, "alpha", 0f, 1f);
        fadeIn.setDuration(1000);
        fadeIn.setInterpolator(new AccelerateDecelerateInterpolator());
        fadeIn.start();
    }

    /**
     * Starts the stopwatch and updates UI states.
     */
    private void startStopwatch() {
        if (!isStarted) {
            binding.chronometer.setBase(SystemClock.elapsedRealtime() - isPaused);
            binding.chronometer.start();
            isStarted = true;

            animateButton(binding.startButton);
            updateButtonStates(false, true, true);
        }
    }

    /**
     * Stops the stopwatch and updates UI states.
     */
    private void stopStopwatch() {
        if (isStarted) {
            binding.chronometer.stop();
            isPaused = SystemClock.elapsedRealtime() - binding.chronometer.getBase();
            isStarted = false;

            animateButton(binding.stopButton);
            updateButtonStates(true, false, true);
        }
    }

    /**
     * Resets the stopwatch and updates UI states.
     */
    private void resetStopwatch() {
        binding.chronometer.setBase(SystemClock.elapsedRealtime());
        isPaused = 0;

        animateButton(binding.resetButton);
        updateButtonStates(true, false, false);
    }

    /**
     * Updates button states (visibility and color grading).
     */
    private void updateButtonStates(boolean startEnabled, boolean stopEnabled, boolean resetEnabled) {
        binding.startButton.setEnabled(startEnabled);
        binding.startButton.setBackgroundTintList(getButtonColor(startEnabled, R.color.start_button));

        binding.stopButton.setEnabled(stopEnabled);
        binding.stopButton.setBackgroundTintList(getButtonColor(stopEnabled, R.color.stop_button));

        binding.resetButton.setEnabled(resetEnabled);
        binding.resetButton.setBackgroundTintList(getButtonColor(resetEnabled, R.color.reset_button));
    }

    /**
     * Handles button color changes for different states.
     */
    private ColorStateList getButtonColor(boolean isEnabled, int normalColor) {
        return ColorStateList.valueOf(ContextCompat.getColor(this, isEnabled ? normalColor : R.color.disabled));
    }

    /**
     * Animates button clicks for smooth UI feedback.
     */
    private void animateButton(View button) {
        ObjectAnimator scaleDown = ObjectAnimator.ofFloat(button, "scaleX", 0.8f, 1f);
        scaleDown.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleDown.setDuration(150);
        scaleDown.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.startButton.setOnClickListener(null);
        binding.stopButton.setOnClickListener(null);
        binding.resetButton.setOnClickListener(null);
        binding = null; // Prevent memory leaks
    }
}
